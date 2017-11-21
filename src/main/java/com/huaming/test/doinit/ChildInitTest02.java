package com.huaming.test.doinit;


class SupperInitTest03 {
	public static int superI = 0;
	public static int superM = 5;
	static {
		System.out.println("SupperInitTest02.superM:"+superM);
	}
	SupperInitTest03(){
		System.out.println("2");
	}
	
	public final void test(){
		System.out.println("1111");
	}
	
}
public class ChildInitTest02 extends SupperInitTest03 {
	public static String childStr = "12121";
	static {
		System.out.println("ChildInitTest02"+childStr);
	}
	ChildInitTest02(){
		System.out.println("b");
	}
	public  void test1(){
		System.out.println("1111");
	}
	public static void main(String[] args) {
		new ChildInitTest02().test();
		
	}
}
