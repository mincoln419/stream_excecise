package com.mermer.ch1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Chapter1Section3 {
	
	
	
	public static void main(String[] args) {
		
		Supplier<Double> mysupplier = () -> Math.random();
		printRandomDouble(mysupplier, 10);
		
		
		Consumer<Integer> myConsumer = x -> System.out.println("consume::" + x);
		List<Integer> instList = Arrays.asList(1,2,3,4,5,6,6,7,9);
		process(instList, myConsumer);
		
	}
	
	public static void printRandomDouble(Supplier<Double> randomSupplier, int count) {
		for(int i = 0 ; i < count ; i++) {
			System.out.println(randomSupplier.get());
		}
	}
	
	public static void process(List<Integer> inputs, Consumer<Integer> processor) {
		for(Integer input : inputs) {
			processor.accept(input);
		}
	}

} 
