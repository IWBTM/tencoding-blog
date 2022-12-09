package com.tencoding.blog.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomError {

	private String field;
	private String message;
}
