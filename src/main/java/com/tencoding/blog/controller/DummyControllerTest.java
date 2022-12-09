package com.tencoding.blog.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// 회원가입
	// http://localhost:9090/blog/dummy/signup
	@PostMapping("/signup")
	public String signUp(@RequestBody User user) {
		log.info(">>> User : {}", user);

		// 보다 명확하게 값을 할당
		user.setRole(RoleType.USER);
		user.setUsername(user.getUsername() + user.getId());
		iUserRepository.save(user);
		System.out.println("회원 가입");
		return "회원가입이 완료 되었습니다.";
	}

	// 아이디로 회원 정보 가져오기
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

	// 모든 회원 정보 가져오기
	@GetMapping("/user")
	public List<User> list() {
		return iUserRepository.findAll();
	}

	// 지정된 수 만큼 회원 정보 가져오기
	@GetMapping("/users")
	public Page<User> pageList(@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<User> userPage = iUserRepository.findAll(pageable);
		List<User> users = iUserRepository.findAll(pageable).getContent();
		return userPage;
	}

	@Transactional // javax.transactional
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User reqUser) {
		log.info(">>> id : {}, >>> pw : {}, >>> email {}", id, reqUser.getPassword(), reqUser.getEmail());
		System.out.println("음?");
		// 해당 id의 사용자가 존재 하는지에 대한 여부 확인
		// 사용자가 존재한다면 넘겨 받은 데이터를 가공해서 저장처리
		// 사용자가 존재하지 않는다면 클라이언트에게 잘못된 요청을 알림
		User user = iUserRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("잘못된 요청입니다..");
		});

		user.setPassword(reqUser.getPassword());
		user.setEmail(reqUser.getEmail());
//		iUserRepository.save(user);
		return null;
	}

	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {

		try {
			iUserRepository.deleteById(id);
		} catch (Exception e) {
			return "해당 사용자를 찾을 수 없습니다.";
		}
		return id + "번 회원님의 정보가 삭제 되었습니다.";
	}
}
