package com.huaming.test.anonymous;

public class TestAnnonymous01 {
	class Inner{
		private String str;
		public void innerTest(){
			test(true);
		}
	}
	public void test(boolean b){
		System.out.println("疏忽");
		
	}
}
