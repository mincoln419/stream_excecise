package com.mermer.ch1;

import java.util.function.Function;

import com.mermer.ch1.util.Adder;

public class Chapter1Section1 {
	
	
	
	public static void main(String[] args) {
		
		Adder adder = new Adder();
		int result = adder.apply(10);
		System.out.println(result);
		
		Function<Integer, Integer> myAdder = x -> x+11;
		System.out.println(myAdder.apply(10));
	}
	


} 
