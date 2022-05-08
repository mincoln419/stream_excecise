package com.mermer.method;

public class DefaultBar implements Bar{

	String name;
	
	public DefaultBar(String name) {
		this.name = name;
	}
	
	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}
	

}
