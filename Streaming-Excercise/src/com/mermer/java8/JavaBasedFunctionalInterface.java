package com.mermer.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class JavaBasedFunctionalInterface {

	
	
	public static void main(String[] args) {
		
		//function
		Function<Integer, Integer> plus1 = i -> i + 1;
		Plus10 plus10 = new Plus10();
		
		System.out.println(plus1.apply(10));
		System.out.println(plus10.apply(10));
		
		Function<Integer, Integer> multiply2 = i -> i *2;
		
		System.out.println(multiply2.apply(10));
	
		Function<Integer, Integer> andThenFunction =  plus1.andThen(multiply2);
		
		Function<Integer, Integer> composeFunction = plus10.compose(multiply2);
		
		System.out.println("andThenFunction::" + andThenFunction.apply(1));
		
		System.out.println("composeFunction::" + composeFunction.apply(2));
		
		Consumer<Integer> con = i -> System.out.println(i);
		con.accept(10);
		
		UnaryOperator<Integer> unary = i -> i * i;		
		System.out.println(unary.apply(10));
		
		
		Predicate<Integer> predicated = i -> i> 10;
		System.out.println(predicated.test(11));
		
		BinaryOperator<Integer> sum = (a, b) -> a+ b;
		System.out.println(sum.apply(10, 21));
		
		
	}
}
