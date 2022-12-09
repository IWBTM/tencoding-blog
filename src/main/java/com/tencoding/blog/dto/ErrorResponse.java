package com.tencoding.blog.dto;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponse {

	private String statusCode;
	private String requsetUri;
	private String code;
	private String message;
	private String ResultCode;
	private List<CustomError> errorList;
	
}
