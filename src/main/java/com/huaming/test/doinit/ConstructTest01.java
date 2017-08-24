package com.huaming.test.doinit;

public class ConstructTest01 {
	
	public int i;
	public String j;
	public ConstructTest01(){
		
	}
	public ConstructTest01(int i) {
		this("i");
		this.i = i;
	}
	
	
	public ConstructTest01(String j) {
		super();
		this.j = j;
	}
	public ConstructTest01(int i, String j) {
		this(j);
		this.i = i;
		this.j = j;
	}
	
}
