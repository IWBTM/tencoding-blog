package com.tencoding.blog.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.ResponseDto;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserApiController {

	// @Autowired는 옛날 방식이긴 하나 쓰는 곳이 있긴 하다.
	@Autowired
	private UserService userService;

	// 로그인 성공 시 session 저장
	@Autowired
	private HttpSession session;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("user : " + user);

		// 1 or -1 을 리턴 받는다.
		int result = userService.saveUser(user);

		// java object에서 JSon 형식으로 알아서 변환 된다.
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}

	@PutMapping("/api/user")
	public ResponseDto<?> update(@RequestBody User user) {
		// validation 처리 .. 예외 잡아서 사용자한테 떨궈주면 돔
		userService.updateUser(user);

		// 목표 : Authentication 에 접근해서 담겨져 있는 Object 값을 수정하자.
		// 1. Authentication 객체 생성
		// 2. AuthenticationNanager를 매모리에 올려서 authenticate() 메서드에 Authentication을 저장한다.
		// 3. SecurityContextHolder.getContext().setAuthentication(우리가 만든
		// Authentication)

		// ﻿UsernamePasswordAuthenticationToken 생성
		// 1
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		// 2, 3
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseDto<>(HttpStatus.OK, 1);
	}

//	@PostMapping("/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user) {
//		System.out.println("user login : " + user);
//
//		// principal : 원리, 접근 주체
//		User principal = userService.login(user);
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		System.out.println("login : " + session.hashCode());
//		return new ResponseDto<Integer>(HttpStatus.OK, 1);
//	}
}
