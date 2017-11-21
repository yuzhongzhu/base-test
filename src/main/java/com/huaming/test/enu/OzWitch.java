package com.huaming.test.enu;

public enum OzWitch  {
	WEST("10001","10001V"),
	NORTH("10002","10002V");
	private String key ;
	private String value;
	
	OzWitch(String key,String value){
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public  String getCode(){
		switch(this.values()[this.ordinal()]){
		
		}
		return null;
	}
	
}
