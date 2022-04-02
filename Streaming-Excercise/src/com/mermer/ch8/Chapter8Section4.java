package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter8Section4 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		
		Optional<Integer> anyNegativeInteger = numbers.stream()
				.filter(x -> x < 0)
				.findAny();
		System.out.println(anyNegativeInteger.get());
		
		
		Optional<Integer> firstPositiveNumber = numbers.stream()
				.filter(x -> x > 0)
				.findFirst();
		System.out.println(firstPositiveNumber.get());
	
		
		
	}
	

}
