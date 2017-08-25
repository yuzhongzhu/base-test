package com.huaming.test.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
	public static void main(String[] args) {
		UserService impl =  (UserService) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new MyHandler(new UserServiceImpl()));
		impl.run();
	
	}
}
