package com.huaming.test.doinit;

public class ChildInitTest02 extends SupperInitTest02 {
	public static String childStr = "12121";
	static {
		System.out.println("ChildInitTest02"+childStr);
	}
}
