package com.mermer.method;

public interface Bar {

	void printName();
	
	
	/** @implSpec
	 * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다 
	 * @override 가능하다
	 * 굳이 impl에서 구현하지 않아도 사용할 수 있음
	 * 다만 Object에서 제공하는 매서드는 default로 정의 할 수 없다. 
	 * - 추상매서드로 선언하는 것은 가능하다.
	 * */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}

	String getName();
}
