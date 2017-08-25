package com.huaming.test.proxy;

public class UserServiceImpl implements UserService {

	public void run() {
		System.out.println("我被调用，开始跑了");

	}

	public void map() {
		System.out.println("我被调用，map");
		
	}
	
	

}
