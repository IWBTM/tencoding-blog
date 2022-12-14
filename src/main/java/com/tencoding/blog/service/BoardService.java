package com.tencoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.blog.dto.Board;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.repository.IBoardRepository;

@Service
public class BoardService {

	@Autowired
	private IBoardRepository boardRepository;

	public void write(Board board, User user) {

		board.setUser(user);
		boardRepository.save(board);
	}

	// select만 하는 녀석이야
	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board boardDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}

	@Transactional
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}

	// 더티 체킹
	@Transactional
	public int modifyBoard(int boardId, Board board) {
		// 영속화 되었다.

		Board boardEntity = boardRepository.findById(boardId).orElseThrow(() -> {
			return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
		});
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		// 해당 함수 종료 시점에 Transactional이 종료 되고 더티 체킹해서 commit 처리한다.
		return 1;
	}
}
