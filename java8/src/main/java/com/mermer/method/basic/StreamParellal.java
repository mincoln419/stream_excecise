package com.mermer.method.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamParellal {

	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("mermer");
		names.add("hello");
		names.add("youngsun");
		names.add("eunwoo");
		names.add("mother");
		names.add("");
		
		
		List<String> collect =  names.parallelStream().map(s -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		}).collect(Collectors.toList());
	
		collect.forEach(System.out::println);
	}
}
