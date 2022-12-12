package com.tencoding.blog.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.ResponseDto;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {

	// @Autowired는 옛날 방식이긴 하나 쓰는 곳이 있긴 하다.
	@Autowired
	private UserService userService;

	// 로그인 성공 시 session 저장
	@Autowired
	private HttpSession session;

	@PostMapping("/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("user : " + user);

		// 1 or -1 을 리턴 받는다.
		int result = userService.saveUser(user);

		// java object에서 JSon 형식으로 알아서 변환 된다.
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}

	@PostMapping("/user/login")
	public ResponseDto<Integer> login(@RequestBody User user) {
		System.out.println("user login : " + user);

		// principal : 원리, 접근 주체
		User principal = userService.login(user);
		if (principal != null) {
			session.setAttribute("principal", principal);
		}
		System.out.println("login : " + session.hashCode());
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
}
