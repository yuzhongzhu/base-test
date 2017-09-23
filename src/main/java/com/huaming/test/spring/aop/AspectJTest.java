package com.huaming.test.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class AspectJTest {
 @Pointcut("execution(* *.test(..))")	
 public void test(){
	 System.out.println("执行test");
 }
 @Before("test()")
 public void beforeTest(){
	 System.out.println("执行test方法之前");
 }
 @After("test()")
 public void afterTest(){
	 System.out.println("执行test方法之后");
 }
 
 @Around("test()")
 public void aroundTest(ProceedingJoinPoint p){
	System.out.println("aroundTest before");
	 try {
		p.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("aroundTest after");
 }
 

}
