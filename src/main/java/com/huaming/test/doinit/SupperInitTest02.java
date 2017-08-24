package com.huaming.test.doinit;

public class SupperInitTest02 {
	public static int superI = 0;
	public static int superM = 5;
	static {
		System.out.println("SupperInitTest02.superM:"+superM);
	}
}
