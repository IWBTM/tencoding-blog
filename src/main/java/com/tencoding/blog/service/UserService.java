package com.tencoding.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	/**
	 * 
	 * Transactional : 하나의 기능 + 하나의 기능 을 묶어서 단위의 기능을 처리
	 * 
	 * DB 수정 시 롤백 처리도 가능
	 * 
	 */
	@Transactional
	public int saveUser(User user) {
		try {
			user.setRole(RoleType.USER);
			iUserRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
