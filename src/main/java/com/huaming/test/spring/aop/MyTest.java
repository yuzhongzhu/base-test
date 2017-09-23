package com.huaming.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public void test(){
		System.out.println("MyTest test");
	}
	
	 public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("testaop.xml");
			MyTest testAop =  (MyTest) context.getBean("test");
			testAop.test();
		}
}
