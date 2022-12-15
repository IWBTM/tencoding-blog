package com.tencoding.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tencoding.blog.dto.User;
import com.tencoding.blog.model.RoleType;
import com.tencoding.blog.repository.IUserRepository;

// Spring이 Component scan을 통해서 bean으로 등록해준다. (IoC)
@Service
public class UserService {

	/**
	 * 굳이 서비스를 만드는 이유 1. transaction 관리를 하기 위해서이다. 2. 코드를 최대한 모듈화 시켜 관리해야 유지보수가
	 * 용이하다.
	 */

	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * Transactional : 하나의 기능 + 하나의 기능 을 묶어서 단위의 기능을 처리
	 * 
	 * DB 수정 시 롤백 처리도 가능
	 */
	@Transactional
	public int saveUser(User user) {
		try {
			// 비밀번호를 넣을 때 여기서 암호화 처리 하고 DB에 저장하기
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			System.out.println("암호화 된 비번" + encPassword);
			// $2a$10$.PMu4TVNv1GD4zClaf3ot.ARvpF3KTfiKj5sjzkiYCAq9JfdZg7S6
			// $2a$10$SajDQzk9.SXHhN.v9PvXKOeZCLLX9ASL39Z.OV1SYaVKuZ0SLMSZm
			// 같은 비밀번호라도 암호화는 매번 다르게 반환한다.

			user.setRole(RoleType.USER);
			iUserRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@org.springframework.transaction.annotation.Transactional
	public Integer updateUser(User reqUser) {
		User userEntity = iUserRepository.findById(reqUser.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("해당 사용자를 찾을 수 없습니다.");
		});

		String rawPassword = reqUser.getPassword();
		String encPassword = encoder.encode(rawPassword);

		userEntity.setUsername(reqUser.getUsername());
		userEntity.setPassword(encPassword);
		userEntity.setEmail(reqUser.getEmail());
		// 더티 체킹해서 업데이트 시킬 예정
		return 1;
	}
//	public User login(User user) {
//
//		// 기본 Repository에 필요한 함수가 존재하지 않을 경우 직접 생성하자.
//		User userEntity = iUserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//		System.out.println("userEntity : " + userEntity);
//		return userEntity;
//	}
//	public User login(User user) {
//
//		// 기본 Repository에 필요한 함수가 존재하지 않을 경우 직접 생성하자.
//		User userEntity = iUserRepository.login(user.getUsername(), user.getPassword());
//		System.out.println("userEntity : " + userEntity);
//		return userEntity;
//	}
}
