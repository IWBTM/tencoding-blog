package com.tencoding.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.User;
import com.tencoding.blog.model.RoleType;
import com.tencoding.blog.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dummy")
public class DummyControllerTest {

	@Autowired // 순환 참조 조심 TODO!!
	private IUserRepository iUserRepository;

	// http://localhost:9090/blog/dummy/signup
	@PostMapping("/signup")
	public String signUp(@RequestBody User user) {
		log.info(">>> User : {}", user);

		// 보다 명확하게 값을 할당
		user.setRole(RoleType.USER);
		iUserRepository.save(user);
		return "회원가입이 완료 되었습니다.";
	}

	@GetMapping("/user/{id}")
	public User detail(@PathVariable int id) throws IllegalAccessException {
//		User user = iUserRepository.findById(id).orElseGet(() -> {
//			return new User();
//		});

		User user = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalAccessException();
		});
		
		return user;
	}
}
