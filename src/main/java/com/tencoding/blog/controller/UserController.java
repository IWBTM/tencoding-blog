package com.tencoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@GetMapping("/auth/login_form")
	public String loginForm() {
		System.out.println("로그인 거침");
		System.out.println("======");
		return "user/login_form";
	}

	@GetMapping("/auth/join_form")
	public String joinForm() {
		System.out.println("회원가입 거침");
		System.out.println("======");
		return "user/join_form";
	}

	@GetMapping("/user/update_form")
	public String updateForm() {
		System.out.println("회원 정보 수정 거침");
		return "user/update_form";
	}
	// 기존 스프링에서 로그 아웃 처리는 따로 정리
//	@GetMapping("/logout")
//	public String logout() {
//		HttpSession httpSession = session;
//
//		System.out.println("logout : " + session.hashCode());
//		// session 삭제
//		httpSession.invalidate();
//		return "redirect:/";
//	}
}
