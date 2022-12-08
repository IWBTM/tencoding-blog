package com.tencoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tencoding.blog.dto.User;

// DAO
// 여기서는 굳이 Bean으로 등록하지 않더라도 JpaRepository가 내부적으로 등록시켜 준다.
public interface IUserRepository extends JpaRepository<User, Integer> {

}
