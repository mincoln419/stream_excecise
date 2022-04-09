package com.mermer.ch10;

import java.util.Arrays;

import com.mermer.ch10.service.BasicPriceProcessor;
import com.mermer.ch10.service.DiscountProcessor;
import com.mermer.ch10.service.PriceProcessor;
import com.mermer.ch10.service.TaxPriceProcessor;

public class Chapter10Section2 {
	
	
	
	public static void main(String[] args) {
		
		Price unprocessedPrice = new Price("Original Price");
		
		PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
		PriceProcessor discountpricPriceProcessor = new DiscountProcessor();
		PriceProcessor taxpricePriceProcessor = new TaxPriceProcessor();
		
		PriceProcessor decoratedPriceProcessor = basicPriceProcessor
				.andThen(discountpricPriceProcessor)
				.andThen(taxpricePriceProcessor);

		Price processedpricePrice = decoratedPriceProcessor.process(unprocessedPrice);
		System.out.println(processedpricePrice.getPrice());

		PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
				.andThen(taxpricePriceProcessor)
				.andThen(price -> new Price(price.getPrice() + ", then apply anothor procedure"));
		Price processedpricePrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
		System.out.println(processedpricePrice2.getPrice());
	}
	


} 
