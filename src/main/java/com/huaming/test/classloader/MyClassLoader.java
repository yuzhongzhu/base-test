package com.huaming.test.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	private  String path;
	private  String name;
	
	
	
	public MyClassLoader(String name,String path){
		super();//系统默认加载器
		this.name = name;
		this.path = path;
	}
	
	
	public MyClassLoader(ClassLoader parent,String name,String path){
		super(parent);//定义父classloader
		this.name = name;
		this.path = path;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	protected Class<?> findClass(String paramString)
			throws ClassNotFoundException {
		byte[] data = readFileByByteArray(paramString);
		return this.defineClass(name, data, 0, data.length);
	}


	private byte[] readFileByByteArray(String name) {
		ByteArrayOutputStream  outPutStream = new ByteArrayOutputStream();
		byte[] classByte = null;
		InputStream input = null;
		String filePath = this.path+name.replace(".", File.separator)+".class";
		File file = new File(filePath);
		try {
			input  =new FileInputStream(file);
			int len = 0;
			while((len=input.read())>0){
				outPutStream.write(len);
			}
			classByte = outPutStream.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				input.close();
				outPutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return classByte;
	}
	
	
	
	
	
}
