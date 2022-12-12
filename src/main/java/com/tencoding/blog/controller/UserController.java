package com.tencoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login-form")
	public String loginForm() {
		System.out.println("로그인 거침");
		System.out.println("======");
		return "user/login_form";
	}

	@GetMapping("/join-form")
	public String joinForm() {
		System.out.println("회원가입 거침");
		System.out.println("======");
		return "user/join_form";
	}
}