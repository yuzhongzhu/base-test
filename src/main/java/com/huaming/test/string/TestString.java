package com.huaming.test.string;

public class TestString {
	public static void main(String[] args) {
		String str1="aaaaa";
		String str2 = str1;
		String str3="aa"+"aaa";
		System.out.println(str2==str1);
		System.out.println(str3==str1);
		str2.toUpperCase();
		System.out.println(str1);
		System.out.println(str2==str1);
	
	}
}
