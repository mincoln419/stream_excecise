package com.mermer.stream.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OnlineClass {

	private Integer id;
	
	private String title;
	
	private boolean closed;
	
}
