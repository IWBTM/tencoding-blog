package com.tencoding.blog.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

	private String statusCode;
	private String requsetUri;
	private int code;
	private String message;
	private String ResultCode;
	private List<CustomError> errorList;

}
