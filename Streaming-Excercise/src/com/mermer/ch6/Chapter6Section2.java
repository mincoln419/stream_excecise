package com.mermer.ch6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section2 {

	
	public static void main(String[] args) {
		

		Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
		Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
		List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumbers);
	
		
		List<Integer> newFilteredNumbers = Stream.of(3, -5, 7, 10, -3)
				.filter(x -> x > 0)
				.collect(Collectors.toList());
		User user1 = new User()
				.setId("Alice")
				.setname
		
		System.out.println(newFilteredNumbers);
	}
}
