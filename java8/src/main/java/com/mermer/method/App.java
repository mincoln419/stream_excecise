package com.mermer.method;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

	public static void main(String[] args) {
		//기존 메서드가 있으면 funtional interface에서 에서 참조하는 것
		//static매소드
		UnaryOperator<String> hi = Greeting::hi;
		System.out.println(hi.apply("Jhon"));
		
		//인스턴스 매소드
		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		System.out.println(hello.apply("Alice"));
		
		//생성자
		Supplier<Greeting> newGreeting = Greeting::new;
		newGreeting.get();
		
		Function<String, Greeting> newArgGreeting = Greeting::new;
		Greeting newGreetingChalie = newArgGreeting.apply("Chalie");
		System.out.println(newGreetingChalie.getName());
		
		Bar.printLowerCase("HELLO LOW");
		
	}
}
