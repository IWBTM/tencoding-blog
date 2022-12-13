package com.tencoding.blog.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tencoding.blog.dto.User;

/**
 * 시큐리티가 로그인 요청을 가로채서 로그인을 처리(DB접근)하고 완료 되면 UserDetails 타입에 Object를 시큐리티의 고유한 세션
 * 저장소에 저장한다. 즉, 우리가 새롭게 정의한 Object로 처리한다.
 */
public class PrincipalDetails implements UserDetails {

	private User user;

	public PrincipalDetails(User user) {
		this.user = user;
	}

	// 계정의 권한을 반환하는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();

//		collection.add(new GrantedAuthority() {
//
//			@Override
//			public String getAuthority() {
//				// "ROLE_" : 스프링 시큐리티 사용 시 프리픽스로 무조건 넣어야 한다.
//				return "ROLE_" + user.getRole();
//			}
//		});

		// GrantedAuthority의 함수가 하나뿐이기 때문에 람다식 ㅆ가능
		collection.add(() -> {
			return "ROLE_" + user.getRole();
		});
		return collection;
	}

	// 계정의 비밀번호를 반환하는 메서드
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// 계정의 아이디를 반환하는 메서드
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정 만료 확인
	@Override
	public boolean isAccountNonExpired() {
		// false면 만료 됐다는 의미 반드시 true를 반환
		return true;
	}

	// 계정 잠김 여부 확인
	@Override
	public boolean isAccountNonLocked() {
		// false면 잠겼다는 의미 반드시 true를 반환
		return true;
	}

	// 비밀번호 만료 여부
	@Override
	public boolean isCredentialsNonExpired() {
		// false면 만료
		return true;
	}

	// 계정 활성화 여부 확인
	@Override
	public boolean isEnabled() {
		// false면 비활성화
		return true;
	}
}
