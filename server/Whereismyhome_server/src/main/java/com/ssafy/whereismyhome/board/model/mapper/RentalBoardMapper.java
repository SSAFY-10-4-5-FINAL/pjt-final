package com.ssafy.whereismyhome.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.board.dto.BoardDto;

@Mapper
public interface RentalBoardMapper {
	//int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	//글 쓰기
	void writeRentalArticle(BoardDto boardDto) throws SQLException;
	
	//글 수정
	void modifyRentalArticle(BoardDto boardDto) throws SQLException;
	
	//글 삭제
	void deleteRentalArticle(int no) throws SQLException;
	
	//글목록 불러오기..
	List<BoardDto> getRentalArticleList() throws SQLException;
	//글 제목 검색
	List<BoardDto> getRentalArticleByTitle(String subtitle) throws SQLException;
	//글 번호 검색해 가져오기
	BoardDto getRentalArticleByNo(int no) throws SQLException;
	
	//조회수 업데이트
	void updateRentalHit(int no) throws SQLException;

}
