package com.mermer.java8;

public interface RunSomething {
	void doIt();
	
	static void printName() {
		System.out.println("Mermer");
	}
	
	default void printAge() {
		System.out.println("36");
	}
}
