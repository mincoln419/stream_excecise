package com.mermer;

public class Jvm {

	public static void main(String[] args) {
		Thread.currentThread();
		
		//Mermer.class
		ClassLoader classLoader = Mermer.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
	}
}
