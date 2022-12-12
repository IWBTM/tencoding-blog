package com.tencoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	HttpSession session;

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

	@GetMapping("/logout")
	public String logout() {

		HttpSession httpSession = session;

		System.out.println("logout : " + session.hashCode());
		// session 삭제
		httpSession.invalidate();
		return "redirect:/";
	}
}
