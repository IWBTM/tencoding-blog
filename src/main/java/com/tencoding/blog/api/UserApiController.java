package com.tencoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.ResponseDto;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.service.UserService;

@RestController
public class UserApiController {

	// @Autowired 은 옛날 방식이긴 하나 쓰는 곳이 있긴 하다.
	@Autowired
	private UserService userService;

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("user : " + user);

		// 1 or -1 을 리턴 받는다.
		int result = userService.saveUser(user);

		// java object에서 JSon 형식으로 알아서 변환 된다.
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
}
