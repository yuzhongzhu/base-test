package com.huaming.test.anonymous;

public class Callee implements Incrementable {
	private int i = 0;
	public void increment() {
		i++;
		System.out.println(i);
	}

}
