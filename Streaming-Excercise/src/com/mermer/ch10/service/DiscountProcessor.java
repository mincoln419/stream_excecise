package com.mermer.ch10.service;

import com.mermer.ch10.Price;

public class DiscountProcessor implements PriceProcessor{

	@Override
	public Price process(Price price) {
		return new Price(price.getPrice() + ", then applied discount");
	}

}
