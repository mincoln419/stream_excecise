package com.mermer.java8;

public class Foo {
	public static void main(String[] args) {
		//�͸� ���� Ŭ���� - anonymous inner class
		RunSomething runSomething = new RunSomething() {
			
			@Override
			public void doIt() {
				System.out.println("hello1");
			}
		};
		//���ٽ�
		RunSomething runSomethingLamda = () -> System.out.println("hello2");
		
		
		runSomething.doIt();
		
		runSomethingLamda.doIt();
	}
}
