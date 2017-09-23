package com.huaming.test.instrument;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class PerfMonXformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		 byte[] transformed = null;
		// System.out.println("transfroming class:"+className);
		 ClassPool pool = ClassPool.getDefault();
		 CtClass cl = null;
		 try {
			cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
			if(cl.isInterface() == false){
				CtBehavior []methods = cl.getDeclaredBehaviors();
				for (int i = 0; i < methods.length; i++) {
					if(!methods[i].isEmpty()){
						doMethod(methods[i],className);
					}
				}
				transformed = cl.toBytecode();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} finally{
			if(null !=cl){
				cl.detach();
			}
		}
		return transformed;
	}

	private void doMethod(CtBehavior method,String className) {
		try {
			/*method.insertBefore("long stime = System.nanoTime(); ");
			method.insertAfter("System.out.println(\"类"+className+"当前方法"+method.getName()+"执行耗时【\"+(System.nanoTime() - stime )+\"】毫秒\");");*/
			
			 method.instrument(new ExprEditor() {
		            public void edit(MethodCall m) throws CannotCompileException {
		            	if(m.getClassName().indexOf("java")<0&&m.getClassName().indexOf("sun")<0){
		            		 m.replace("{ long stime = System.nanoTime(); $_ = $proceed($$); System.out.println(\""
		                                + m.getClassName()+"."+m.getMethodName()
		                                + ":\"+(System.nanoTime()-stime));}");
		            	}
		               
		            }
		        });
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
	}

}
