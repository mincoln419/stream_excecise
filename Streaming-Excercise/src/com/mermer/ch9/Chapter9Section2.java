package com.mermer.ch9;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter9Section2 {

	public static void main(String[] args) {

//		if(returnTrue()||returnFalse()) {
//			//System.out.println("true");
//		}
//
//		if(or(returnTrue(), returnFalse())) {
//	//		System.out.println("true");
//		}
	
		if(lazyOr(() -> returnTrue(), () -> returnFalse())) {
			System.out.println("true");
		}
	
	
		Stream<Integer> integerStream = Stream.of(3,-2,5,8,-3,10)
				.filter(x -> x > 0)
				.peek(x -> System.out.println("peeking " + x))
				.filter(x -> x % 2 == 0);
		
		System.out.println("Before collect");
		List<Integer> integers = integerStream.collect(Collectors.toList());
		
		System.out.println("After Collect:" + integers);
		
	}
	
	public static boolean or(boolean x, boolean y) {
		return x || y;
	}

	
	public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
		return x.get()||y.get();
	}

	public static boolean returnTrue() {
		System.out.println("Returning True");
		return true;
	}
	
	public static boolean returnFalse() {
		
		System.out.println("Returning False");
		return false;
	}
	
}
