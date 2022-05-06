package com.mermer.java8;

public class Foo {
	public static void main(String[] args) {
		
		int finalNumber = 20;
		//익명 내부 클래스 - anonymous inner class
		RunSomething runSomething = new RunSomething() {
			
			@Override
			public int doIt(int a) {
				System.out.println("hello" + (a + finalNumber));
				return a + 10;
			}
		};
		//람다식
		RunSomething runSomethingLamda = (a) -> {
			System.out.println("hello"+ (a+ finalNumber));
			return a + 20;
		};
		
		//finalNumber++ -> 익명 클래스 안에서 사용된 변수는 final로 취급되어서 변경이 불가능해진다
		
		runSomething.doIt(1);
		
		runSomethingLamda.doIt(2);
	}
}
