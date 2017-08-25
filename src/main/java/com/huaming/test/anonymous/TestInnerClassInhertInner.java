package com.huaming.test.anonymous;

import com.huaming.test.anonymous.TestInnerClass04.TestInner04;

public class TestInnerClassInhertInner {
	class TestInnerInhertInner04 extends TestInner04{
		
		public TestInnerInhertInner04(TestInnerClass04 testInnerClass04, int i) {
			testInnerClass04.super(i);
			// TODO Auto-generated constructor stub
		}
	}
}
