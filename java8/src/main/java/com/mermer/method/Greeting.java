package com.mermer.method;

public class Greeting {
	
	private String name;
	
	private Greeting() {
	}
	
	private Greeting(String name) {
		this.name = name;
	}
	
	public String hello(String name) {
		return "hello " + name;
	}
	
	public String hi(String name) {
		return "hi " + name;
	}

}
