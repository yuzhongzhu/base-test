package com.huaming.test.doinit;

import java.lang.reflect.Proxy;

public class TestMain {
	/*static{
		System.out.println("TestMain---1");
		System.out.println(mainA);
	}*/
	/*static {
		System.out.println("TestMain--2");
		mainA ="zhangsan";
	};
	public static String mainA="1212";*/
	
	public static void main(String[] args) {
			//InitTest01 it = new InitTest01("bbint");
		   /* InitTest01.bb = "1212333main";
		    System.out.println(InitTest01.bb);*/
		    //System.out.println(mainA);
		  //System.out.println("TestMain ---ChildInitTest02.superI:"+ChildInitTest02.superI);
		//for(Spiciness s :Spiciness.values() ){
			System.out.println(Spiciness.HOT.value);
		//}
	}
	//static ConstructsTest02 test02  =new ConstructsTest02();
}
