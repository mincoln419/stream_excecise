package com.mermer.java8;

public class Foo {
	public static void main(String[] args) {
		
		int finalNumber = 20;
		//�͸� ���� Ŭ���� - anonymous inner class
		RunSomething runSomething = new RunSomething() {
			
			@Override
			public int doIt(int a) {
				System.out.println("hello" + (a + finalNumber));
				return a + 10;
			}
		};
		//���ٽ�
		RunSomething runSomethingLamda = (a) -> {
			System.out.println("hello"+ (a+ finalNumber));
			return a + 20;
		};
		
		//finalNumber++ -> �͸� Ŭ���� �ȿ��� ���� ������ final�� ��޵Ǿ ������ �Ұ���������
		
		runSomething.doIt(1);
		
		runSomethingLamda.doIt(2);
	}
}
