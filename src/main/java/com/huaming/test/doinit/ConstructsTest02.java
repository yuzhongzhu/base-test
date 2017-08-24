package com.huaming.test.doinit;

public class ConstructsTest02 {
	static ConstructTest02 test01;
		static{
			test01 = new ConstructTest02(1);
		}
	public ConstructsTest02(){
		System.out.println("ConstructsTest02");
	}
}
