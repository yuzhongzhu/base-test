package com.huaming.test.anonymous;

import com.huaming.test.anonymous.TestAnnonymous03.TestInner03;

public class TestAnnonymous03Inhert extends TestInner03 {
	/*public TestAnnonymousInhert(){
		
	}*/
	public TestAnnonymous03Inhert(TestAnnonymous03 annonymous03){
		annonymous03.super(); //必须要，才能编译通过
	}

	@Override
	public void test() {
		super.test();
		System.out.println("内部类导出类重写");
	}
	
	
	
}
