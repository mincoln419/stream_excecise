package com.mermer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor
public class Book {

	private String title;
	private String contents;

}