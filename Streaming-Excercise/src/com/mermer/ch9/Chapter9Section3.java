package com.mermer.ch9;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.mermer.ch9.model.Order;
import com.mermer.ch9.model.OrderLine;

import com.mermer.ch9.processor.*;


public class Chapter9Section3 {

	public static void main(String[] args) {

		Function<Integer, Integer> multiplyByTwo = x -> x * 2;
		Function<Integer, Integer> addTen = x -> x + 10;
		
		Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
		System.out.println(composedFunction.apply(3));
		
		
		
		Order unprocessedOrder = new Order()
				.setCreatedByUserId(1001L)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(2000))
   						));
		
		
		List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);
		
		Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
				.reduce(Function.identity(), Function::andThen);
		
		System.out.println(mergedPriceProcessors.apply(unprocessedOrder));
	}

	
	public static List<Function<Order, Order>> getPriceProcessors(Order order){
		return Arrays.asList(new OrderLineAggregationPriceProcessor(), new TaxPriceProcessor(new BigDecimal("9.375")));
	}

}
