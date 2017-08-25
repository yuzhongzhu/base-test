package com.huaming.test.compile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
	private File dir;
	
	public MyClassLoader(){
		super();
	}
	public MyClassLoader(String filePath){
		this.dir = new File(filePath);
	}
	
	
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if(dir !=null){
			super.findClass(name);
			File clazzFile = new File(name, ".class");
			FileInputStream input = null;
			try {
				input = new FileInputStream(clazzFile);
				ByteArrayOutputStream outPut = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len=input.read(buffer))!=-1){
					outPut.write(buffer, 0, len);
				}
				defineClass("包路径"+name, outPut.toByteArray(), 0, outPut.size()) ;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
	
}
