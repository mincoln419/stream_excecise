package com.mermer.java8;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Bar {
	
	public static void main(String[] args) {
		
		
	
	}
	
	private void run() {
		int baseNumber = 10;
	
		//로컬 클래스
		class LocalClass{
			void printBaseNumber() {// 내부에 baseNumber를 정의할 수 있음 - 변수 shadowing..
				int baseNumber = 11;
				System.out.println(baseNumber);
			}
		}
		
		//익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer baseNumber) {
				System.out.println("integerConsumer::"+ baseNumber);
			}
		};
		
		//람다 -> shadowing이 발생하지 않는다
		IntConsumer printInt = i -> System.out.println(i + baseNumber);//내부에 baseNumber를 정의할 수 없음 - 단, effective final이 됨
		
		LocalClass class1 = new LocalClass();
		class1.printBaseNumber();
		integerConsumer.accept(20);
		printInt.accept(10);
	}
	
	
}
