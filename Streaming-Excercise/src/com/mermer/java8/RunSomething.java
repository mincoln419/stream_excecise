package com.mermer.java8;

public interface RunSomething {
	int doIt(int a);
	
	static void printName() {
		System.out.println("Mermer");
	}
	
	default void printAge() {
		System.out.println("36");
	}
}
