package com.mermer.stream.vo;

import java.time.Duration;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Progress {

	private Duration studyDuration;
	
	private boolean finished;
	
}
