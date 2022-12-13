package com.tencoding.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tencoding.blog.dto.User;

// DAO
// 여기서는 굳이 Bean으로 등록하지 않더라도 JpaRepository가 내부적으로 등록시켜 준다.
public interface IUserRepository extends JpaRepository<User, Integer> {

	// 없는 함수는 직접 함수를 만들거나 Spring JPA에서 제공하는 네이밍 전략이 존재한다.
	// SELECT * FROM user WHERE username = ? and password = ?

//	User findByUsernameAndPassword(String username, String password);

	// native 쿼리 만들기
//	@Query(value = " SELECT * " + " FROM user " + " WHERE username = ?1 "
//			+ " and password = ?2 ", nativeQuery = true)
//	User login(String username, String password);

//	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
	Optional<User> findByUsername(String username);
}
