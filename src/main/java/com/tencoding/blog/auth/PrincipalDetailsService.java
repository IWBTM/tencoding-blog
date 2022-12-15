package com.tencoding.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tencoding.blog.dto.User;
import com.tencoding.blog.repository.IUserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService {
	/**
	 * Security가 username, password를 가로채서 처리하는데 여기서는 username을 확인해 줘야 한다.
	 */

	@Autowired
	private IUserRepository userRepository;

	// DB에 접근해서 사용자 username이 있는지 없는지에 대한 여부 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException(username + "님을 찾을 수 없습니다.");
		});
		System.out.println("principal : " + principal);
		return new PrincipalDetails(principal);
	}
}
