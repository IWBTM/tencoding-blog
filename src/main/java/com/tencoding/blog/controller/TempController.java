package com.tencoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

	@GetMapping("/temp/home")
	public String tempHome() {
		return "/home.html";
	}

	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpg";
	}

	@GetMapping("/temp/test")
	public String tempJsp() {

		// prefix : main 아래 -> /WEB_INF/views/
		// /test
		// subfix : .jsp
		// = 메인부터 /WEB_INF/views/test.jsp
		return "/test";
	}
}
