package com.kjh.exam.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.exam.gec.repository.BoardRepository;
import com.kjh.exam.gec.vo.Board;

@Service
public class BoardService {

private BoardRepository boardRepository;

	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Board getBoardById(int boardId) {
		return boardRepository.getBoardById(boardId);
	}
}