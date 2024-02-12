package com.dizitive.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchRequest {
	private String planName;
	private String planStatus;
	private String gender;
	//@DateTimeFormat(pattern="dd-mm-YYYY")
	private String startDate;
	//@DateTimeFormat(pattern="dd-mm-YYYY")

	private String endDate;

}
