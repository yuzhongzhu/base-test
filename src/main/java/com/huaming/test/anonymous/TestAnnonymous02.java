package com.huaming.test.anonymous;

public interface TestAnnonymous02 {
	public void test();
	class TestInner{
		private String str;
		public void innerTest(){
			System.out.println("接口中使用");
		}
	}
}
