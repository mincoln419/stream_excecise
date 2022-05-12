package com.mermer.stream.vo;

import java.util.Optional;

import lombok.Data;

@Data
public class OnlineClass {

	private Integer id;
	
	private String title;
	
	private boolean closed;

	public OnlineClass(Integer id,  String title, boolean closed) {
		this.id = id;
		this.title = title;
		this.closed = closed;
		
	}
	
	private Optional<Progress> progress;
	
}
