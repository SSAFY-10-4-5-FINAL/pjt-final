package com.ssafy.whereismyhome.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.board.dto.BoardDto;

@Mapper
public interface NoticeBoardMapper {
	//int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	//글 쓰기
	void writeNoticeArticle(BoardDto boardDto) throws SQLException;
	
	//글 수정
	void modifyNoticeArticle(BoardDto boardDto) throws SQLException;
	
	//글 삭제
	void deleteNoticeArticle(int no) throws SQLException;
	
	//글목록 불러오기..
	List<BoardDto> getNoticeArticleList() throws SQLException;
	//글 제목 검색
	List<BoardDto> getNoticeArticleByTitle(String subtitle) throws SQLException;
	//글 번호 검색해 가져오기
	BoardDto getNoticeArticleByNo(int no) throws SQLException;
	
	//조회수 업데이트
	void updateNoticeHit(int no) throws SQLException;

}
