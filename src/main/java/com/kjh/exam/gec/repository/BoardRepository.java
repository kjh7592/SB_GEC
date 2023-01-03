package com.kjh.exam.gec.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kjh.exam.gec.vo.Board;

@Mapper
public interface BoardRepository {

	@Select("""
			SELECT *
			FROM board
			WHERE id = #{id}
			AND delStatus = 0;
			""")
	Board getBoardById(int boardId);
}
