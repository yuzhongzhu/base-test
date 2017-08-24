package com.huaming.test.doinit;

public enum Spiciness {
	NOT("失败"),MILD("2b"),MEDIUM("中等"),HOT("热");
	
	
	//默认是private
	private Spiciness(String value) {
		this.value = value;
	}

	public String value;

	public String getValue() {
		return value;
	}
	
}
