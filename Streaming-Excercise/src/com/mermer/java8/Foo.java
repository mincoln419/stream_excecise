package com.mermer.java8;

public class Foo {
	public static void main(String[] args) {
		//익명 내부 클래스 - anonymous inner class
		RunSomething runSomething = new RunSomething() {
			
			@Override
			public void doIt() {
				System.out.println("hello1");
			}
		};
		//람다식
		RunSomething runSomethingLamda = () -> System.out.println("hello2");
		
		
		runSomething.doIt();
		
		runSomethingLamda.doIt();
	}
}
