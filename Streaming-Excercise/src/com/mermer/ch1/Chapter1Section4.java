package com.mermer.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Chapter1Section4 {
	
	
	
	public static void main(String[] args) {
		

		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> instList = Arrays.asList(1.2,2,3.5,4,5,8,6,7,9);
		process(instList, x -> resultMap.put("key"+x, x));
	
		System.out.println(resultMap);
		
		BiConsumer<Integer, Object> mybiconsumer = (x, y) -> resultMap.put(x+"+"+y+"key", x +"" + y);
		
		processBi(instList, mybiconsumer);
		System.out.println("biconsumer::" + resultMap);
	}
	
		
	public static <T> void process(List<T> inputs, Consumer<T> processor) {
		for(T input : inputs) {
			processor.accept(input);
		}
	}
	
	public static <T> void processBi(List<T> inputs, BiConsumer<Integer, T> processor) {
		for(int i = 0 ; i < inputs.size(); i++) {
			processor.accept(i, inputs.get(i));
		}
	}

} 
