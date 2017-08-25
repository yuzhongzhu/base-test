package com.huaming.test.anonymous;

public class CalleeAnnonymous extends MyIncrement {
	private int i = 0;

	@Override
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	
	private class Closuer implements Incrementable{

		public void increment() {
			CalleeAnnonymous.this.increment();
		}
		
	}
	
	Incrementable getCallbackIncrementable(){
		return new Closuer();
	}
	
}
