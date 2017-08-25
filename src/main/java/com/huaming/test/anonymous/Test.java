package com.huaming.test.anonymous;

public class Test {
	public static void main(String[] args) {
		/*TestAnnonymous01 anonymous = new TestAnnonymous01();
		TestAnnonymous01.Inner inner = anonymous.new Inner();
		inner.innerTest();*/
		/*TestAnnonymous02 impl = new TestAnnoymousImpl();*/
		/*Callee callee = new Callee();
		CalleeAnnonymous callAnno = new CalleeAnnonymous();
		MyIncrement.f(callAnno);//Other operation
		//1
		Caller caller1 = new Caller(callee);
		Caller caller2 = new Caller(callAnno.getCallbackIncrementable());
		Caller caller3 = new Caller(callAnno.getCallbackIncrementable());
		caller1.go();// 第一次调用 1
		caller1.go();// 第一次调用 2
		caller2.go();
		//Other operation
		//2
		caller2.go();
//		Other operation
//		3
		caller3.go();*/
		TestAnnonymous03 anny03 = new TestAnnonymous03();
		TestAnnonymous03Inhert annyInher = new TestAnnonymous03Inhert(anny03);
		annyInher.test();
		
	}
}
