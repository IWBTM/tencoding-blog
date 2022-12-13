package com.tencoding.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// IoC 관리
@Configuration

// Security 필터로 등록 된다. - filter custom
@EnableWebSecurity

// 특정 주소로 접근하면 권한 및 인증 처리를 미리 체크하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// /auth/login_form, auth/join_form --> /auth/**
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 개발 완료 전 테스트 시 사용하고 실 서비스 시에는 사용하지 않는 것을 권장한다.
		http.csrf().disable();
		
		http
			.authorizeHttpRequests()
			// antMatchers("/auth/**") <-- 매개 변수 안의 주소는 모두 허용하라.
			.antMatchers("/auth/**", "/", "/js/**", "/image/**", "/css/**")
			// 모든 권한을 줘라.
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/login_form");
	}
}
