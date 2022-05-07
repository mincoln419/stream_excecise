package com.mermer.java8;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Bar {
	
	public static void main(String[] args) {
		
		
	
	}
	
	private void run() {
		int baseNumber = 10;
	
		//���� Ŭ����
		class LocalClass{
			void printBaseNumber() {// ���ο� baseNumber�� ������ �� ���� - ���� shadowing..
				int baseNumber = 11;
				System.out.println(baseNumber);
			}
		}
		
		//�͸� Ŭ����
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer baseNumber) {
				System.out.println("integerConsumer::"+ baseNumber);
			}
		};
		
		//���� -> shadowing�� �߻����� �ʴ´�
		IntConsumer printInt = i -> System.out.println(i + baseNumber);//���ο� baseNumber�� ������ �� ���� - ��, effective final�� ��
		
		LocalClass class1 = new LocalClass();
		class1.printBaseNumber();
		integerConsumer.accept(20);
		printInt.accept(10);
	}
	
	
}
