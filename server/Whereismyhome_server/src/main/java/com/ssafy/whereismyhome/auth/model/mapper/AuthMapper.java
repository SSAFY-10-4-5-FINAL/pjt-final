package com.ssafy.whereismyhome.auth.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.board.dto.BoardDto;
import com.ssafy.whereismyhome.board.dto.FileInfoDto;

@Mapper
public interface AuthMapper {
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	
	//글 목록 불러오기
	//List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
	
	
	
	//글 쓰기
	void writeArticle(BoardDto boardDto) throws SQLException;
	
	//글 수정
	void modifyArticle(BoardDto boardDto) throws SQLException;
	
	//글 삭제
	void deleteArticle(int no) throws SQLException;
	
	//글목록 불러오기..
	List<BoardDto> getArticleList() throws SQLException;
	//글 제목 검색
	List<BoardDto> getArticleByTitle(String subtitle) throws SQLException;
	//글 번호 검색해 가져오기
	BoardDto getArticleByNo(int no) throws SQLException;
	
	//조회수 업데이트
	void updateHit(int no) throws SQLException;

}
