package com.mermer.ch1;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.mermer.ch1.util.Adder;
import com.mermer.ch1.util.TriFunction;

public class Chapter1Section2 {
	
	
	
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, String> addToString 
		= (x, y) -> String.valueOf(x + y);
		
		System.out.println(addToString.apply(1,2));
		
		
		TriFunction<Integer, Integer, Integer, String> triFunction 
		= (x, y, z) -> String.valueOf(x + y + z);
		
		System.out.println("triFunction::" + triFunction.apply(10, 20, 30));
	}
	


} 
