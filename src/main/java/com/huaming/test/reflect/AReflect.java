package com.huaming.test.reflect;


/**
 * 反射机制
 * 1、没有显示申明构造函数时，使用默认
 * 2、显示申明默认构造函数为私用时 可通过获取申明的构造函数后修改其访问权限
 *   如:
 *    Constructor con = clazz.getDeclaredConstructor();
	  con.setAccessible(true);
 * @author Administrator
 *
 */
public class AReflect {
	public int a;
	
}
