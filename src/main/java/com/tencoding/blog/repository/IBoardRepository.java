package com.tencoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tencoding.blog.dto.Board;

public interface IBoardRepository extends JpaRepository<Board, Integer>{

}
