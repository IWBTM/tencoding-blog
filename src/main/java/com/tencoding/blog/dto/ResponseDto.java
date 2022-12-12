package com.tencoding.blog.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 같은 변수 이름으로 데이터 타입을 다르게 사용해야 할 때
// 제네릭 프로그램을 생각하자 !!
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

	// 보낼 데이터의 타입을 선언해야 한다.
	HttpStatus status;

	// 받는 타입이 매번 달라진다.
	T body;
}
