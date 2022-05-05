package com.mermer.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Chapter1Section6 {
	
	
	
	public static void main(String[] args) {
		
		Predicate<Integer> isPositive = x -> x > 0;
		Predicate<Integer> isNonPositive = x -> x < 0;
		
		List<Integer> inputs = Arrays.asList(10,-1,20,-30,0,20,12);
		List<Integer> positive = filter(inputs, isPositive);
		System.out.println(positive);
		List<Integer> nonPositive = filter(inputs, isNonPositive);
		System.out.println(nonPositive);
	}
	
	public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
		
		List<T> output = new ArrayList<>();
		for(T input : inputs) {
			if(condition.test(input))output.add(input);
		}
		return output;
	}
	

} 
