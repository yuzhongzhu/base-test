package com.huaming.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	private Object userService;
	
	
	public MyHandler(Object userService){
		this.userService = userService;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("1212121");
		
		Object obj = method.invoke(userService, args);
		return obj;
	}
	
}
