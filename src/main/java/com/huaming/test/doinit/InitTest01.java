package com.huaming.test.doinit;
/**
 * 类加载的过程: 加载、验证、准备、解析、初始化、使用、卸载
 *   注意点：一、其中特殊情形下 解析有可能是在初始化之后进行
 * 一定触发初始化 1、new
 * 1、
 * @author Administrator
 *
 */
public class InitTest01 {
	public String a;
	public final static          String aa = "final";
	public static String bb="static1212";
	public static String n="1213";
	public String b="1212";
	
	public InitTest01(String m){
		System.out.println("a-->"+a);
		System.out.println("aa-->"+aa);
		System.out.println("bb-->"+bb);
		System.out.println("b-->"+b);
		System.out.println("n-->"+n);
		this.b = m;
		System.out.println("b-->"+b);
	}
	static{
		System.out.println("static--n-->"+n);
		System.out.println("static--aa-->"+aa);
		System.out.println("static--bb-->"+bb);
		n = "10";
	}
}
