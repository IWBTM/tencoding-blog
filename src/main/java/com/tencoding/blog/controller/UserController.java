package com.tencoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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

	// Controller에서 데이터를 리턴하는 방법
	@GetMapping("/auth/kakao/callback")
	@ResponseBody
	public String kakaoCallbac(@RequestParam String code) {
		// 여기서 카카오 서버에서 보내준 인가코드 값을 받을 수 있다.

		// 토큰 발급 받기
		RestTemplate rt = new RestTemplate();

		// 헤더 만들기
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");

		// 바디 만들기
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "b6cb672f15bbfb750480119395e3ae87");
		params.add("redirect_uri", "http://localhost:9090/auth/kakao/callback");
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> requestKakaoToken = new HttpEntity<>(params, headers);
		// 헤더변조 해서 실행 시키는 메서드 : RestTemplate.exchange()
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST,
				requestKakaoToken, String.class);
		return "카카오 인가 코드 : /n " + response;
	}

	// https://kauth.kakao.com/oauth/token
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
