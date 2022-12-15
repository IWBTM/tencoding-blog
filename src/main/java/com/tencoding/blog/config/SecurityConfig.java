package com.tencoding.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tencoding.blog.auth.PrincipalDetailsService;

// IoC 관리
@Configuration

// Security 필터로 등록 된다. - filter custom
@EnableWebSecurity

// 특정 주소로 접근하면 권한 및 인증 처리를 미리 체크하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailsService detailsService;

	// 비밀번호를 BCrypt 방식으로 Encode 해주는 데이터 타입이다.
	// IoC관리를 하기 위해 여기서 선언
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 1. userDetailsService에 들어갈 Object를 만들어줘야 한다.
		// 우리가 커스텀한 녀석을 넣어야 한다.
		// 2. 우리가 사용하는 hash 암호화 함수를(passwordEncoder) 알려줘야 한다.
		// BCryptPasswordEncoder를 사용해서 암호화 했다.
		
		System.out.println("auth : " + auth);
		auth.userDetailsService(detailsService).passwordEncoder(encodePWD());
	}

	// /auth/login_form, auth/join_form --> /auth/**
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 개발 완료 전 테스트 시 사용하고 실 서비스 시에는 사용하지 않는 것을 권장한다.
		http.csrf().disable();

		http.authorizeHttpRequests()
				// antMatchers("/auth/**") <-- 매개 변수 안의 주소는 모두 허용하라.
				.antMatchers("/auth/**", "/", "/js/**", "/image/**", "/css/**")
				// 모든 권한을 줘라.
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/login_form")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/");
	}
}
