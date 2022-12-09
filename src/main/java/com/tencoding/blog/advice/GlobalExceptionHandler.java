package com.tencoding.blog.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tencoding.blog.dto.CustomError;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {
		System.out.println("===== Exception 발생 =====");
		System.out.println(e.getClass());
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.println("===== Exception 종료 =====");
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public String illegalArgumentException(IllegalArgumentException e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		System.out.println("===== MethodArgumentNotValidException  발생 =====");
		List<CustomError> eList = new ArrayList<>();

		BindingResult bindingResult = ex.getBindingResult();
		bindingResult.getAllErrors().forEach((action) -> {
			FieldError fieldError = (FieldError) action;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();

			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);

			eList.add(customError);
		});

		// TODO!!
		// ErrorResponse는 추후 처리
		System.out.println("===== MethodArgumentNotValidException  종료 =====");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eList);
	}
}
