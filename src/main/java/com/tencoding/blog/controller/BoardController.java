package com.tencoding.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tencoding.blog.auth.PrincipalDetails;

@Controller
public class BoardController {
	/**
	 * 로그인이 인증되면 controller에서 어떻게 session을 찾을까?
	 */

	@GetMapping({ "", "/" })
	public String index(@AuthenticationPrincipal PrincipalDetails principal) {
		if (principal != null) {
			System.out.println(principal.getUsername());
			System.out.println(principal.getAuthorities());
		}
		return "index";
	}
	
	@GetMapping("/board/save_form")
	public String saveForm() {
		
		return "/board/save_form";
	}
}
