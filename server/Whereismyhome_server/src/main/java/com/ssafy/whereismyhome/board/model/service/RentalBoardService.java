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
import com.ssafy.whereismyhome.board.model.mapper.RentalBoardMapper;

@Service
public class RentalBoardService {
	private RentalBoardMapper rentalBoardMapper;

	@Autowired
	public RentalBoardService(RentalBoardMapper rentalBoardMapper) {
		this.rentalBoardMapper = rentalBoardMapper;
	}

	@Transactional
	public void writeRentalArticle(BoardDto boardDto) throws Exception {
		rentalBoardMapper.writeRentalArticle(boardDto);
	}
	
	//글목록 불러오기..
	public List<BoardDto> getRentalArticleList() throws Exception {
		//System.out.println("in service..");
		List<BoardDto> boardDtoList = rentalBoardMapper.getRentalArticleList();
		System.out.println(":?"+boardDtoList); 
		return boardDtoList;
	}

	//글 수정
	public void modifyRentalArticle(BoardDto boardDto) throws Exception {
		rentalBoardMapper.modifyRentalArticle(boardDto);
	}
	
	//글 삭제
	public void deleteRentalArticle(int no) throws Exception {
		rentalBoardMapper.deleteRentalArticle(no);
	}
	
	//글 제목 검색
	public List<BoardDto> getRentalArticleByTitle(String subtitle) throws Exception {
		return rentalBoardMapper.getRentalArticleByTitle(subtitle);
	}
	//글 번호 검색
	public BoardDto getRentalArticleByNo(int no) throws Exception {
		return rentalBoardMapper.getRentalArticleByNo(no);
	}
		
	
	//조회수 업데이트
	public void updateRentalHit(int no) throws Exception {
		rentalBoardMapper.updateRentalHit(no);
	}	
		
}
