package com.tencoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tencoding.blog.dto.Board;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.repository.IBoardRepository;

@Service
public class BoardService {

	@Autowired
	private IBoardRepository boardRepository;

	public void write(Board board, User user) {

//		board.setCount(0);
		// !?!??!?!?!?!!!!!!!!?!?!?!?!?!?!?!?!?!??!
		board.setUserId(user);
		boardRepository.save(board);
	}
}
