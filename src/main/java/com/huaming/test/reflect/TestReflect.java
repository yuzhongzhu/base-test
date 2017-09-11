package com.huaming.test.reflect;

import java.lang.reflect.Constructor;

public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class clazz = Class.forName("com.huaming.test.reflect.AReflect");
		Constructor con = clazz.getDeclaredConstructor();
		con.setAccessible(true);
	 try {
		System.out.println(clazz.newInstance());
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
