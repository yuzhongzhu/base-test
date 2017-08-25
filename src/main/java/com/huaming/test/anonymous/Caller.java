package com.huaming.test.anonymous;

public class Caller {
	private Incrementable incrementable;
	 Caller(Incrementable incrementable){
		this.incrementable = incrementable;
	}
	 
	void go(){
		incrementable.increment();
	}
}
