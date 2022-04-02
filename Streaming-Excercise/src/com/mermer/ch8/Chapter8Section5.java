package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter8Section5 {

	public static void main(String[] args) {

		List<Integer> numbers = Stream.of(3, -4, 2, 7, 9)
				.collect(Collectors.toList())
				;
		System.out.println(numbers);
	
	
		Set<Integer> numberset = Stream.of(3, -4, 2, 7, 9)
				.collect(Collectors.toSet())
				;
		System.out.println(numberset);
	
		
		List<Integer> numberlist2 = Stream.of(3,5,6,2,1,3,-1,3,5-3)
			.collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
		System.out.println(numberlist2);
		
		Set<Integer> numberlist3 = Stream.of(3,5,6,2,1,3,-1,3,5-3)
				.collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
		System.out.println(numberlist3);
		
		
		int sum = Stream.of(3,5,6,2,1,3,-1,3,5-3)
			.collect(Collectors.reducing(0, (x,y) -> x + y));
		System.out.println(sum);
	}
	

}
