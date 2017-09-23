package com.huaming.test.instrument;
/**
 * 执行的时候加入参数
 * -javaagent:D:\src\base-test\target\base-test-0.0.1-SNAPSHOT.jar
 * @author Administrator
 *
 */
public class App {
 public static void main(String[] args) {
	new App().test();
}
 
 public void test(){
	 System.out.println("test");
 }
}
