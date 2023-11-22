package com.ssafy.whereismyhome.board.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.board.dto.BoardDto;
import com.ssafy.whereismyhome.board.dto.FileInfoDto;
import com.ssafy.whereismyhome.board.dto.response.BoardListDto;
import com.ssafy.whereismyhome.board.model.mapper.BoardMapper;
import com.ssafy.whereismyhome.board.model.mapper.NoticeBoardMapper;
import com.ssafy.whereismyhome.board.model.mapper.RentalBoardMapper;

@Service
public class NoticeBoardService {
	private NoticeBoardMapper noticeBoardMapper;

	@Autowired
	public NoticeBoardService(NoticeBoardMapper noticeBoardMapper) {
		this.noticeBoardMapper = noticeBoardMapper;
	}

	@Transactional
	public void writeNoticeArticle(BoardDto boardDto) throws Exception {
		noticeBoardMapper.writeNoticeArticle(boardDto);
	}
	
	//글목록 불러오기..
	public List<BoardDto> getNoticeArticleList() throws Exception {
		//System.out.println("in service..");
		List<BoardDto> boardDtoList = noticeBoardMapper.getNoticeArticleList();
		System.out.println(":?"+boardDtoList); 
		return boardDtoList;
	}

	//글 수정
	public void modifyNoticeArticle(BoardDto boardDto) throws Exception {
		noticeBoardMapper.modifyNoticeArticle(boardDto);
	}
	
	//글 삭제
	public void deleteNoticeArticle(int no) throws Exception {
		noticeBoardMapper.deleteNoticeArticle(no);
	}
	
	//글 제목 검색
	public List<BoardDto> getNoticeArticleByTitle(String subtitle) throws Exception {
		return noticeBoardMapper.getNoticeArticleByTitle(subtitle);
	}
	//글 번호 검색
	public BoardDto getNoticeArticleByNo(int no) throws Exception {
		return noticeBoardMapper.getNoticeArticleByNo(no);
	}
		
	
	//조회수 업데이트
	public void updateNoticeHit(int no) throws Exception {
		noticeBoardMapper.updateNoticeHit(no);
	}	
		
}
