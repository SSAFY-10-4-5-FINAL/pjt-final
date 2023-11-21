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

@Service
public class BoardService {
	private BoardMapper boardMapper;

	@Autowired
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Transactional
	public void writeArticle(BoardDto boardDto) throws Exception {
		boardMapper.writeArticle(boardDto);
		//List<FileInfoDto> fileInfos = boardDto.getFileInfos();
	}
//
//	public BoardListDto listArticle(Map<String, String> map) throws Exception {
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
//		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
//		int start = currentPage * sizePerPage - sizePerPage;
//		param.put("start", start);
//		param.put("listsize", sizePerPage);
//
//		String key = map.get("key");
//		param.put("key", key == null ? "" : key);
//		if ("user_id".equals(key))
//			param.put("key", key == null ? "" : "b.user_id");
//		List<BoardDto> list = boardMapper.listArticle(param);
//
//		if ("user_id".equals(key))
//			param.put("key", key == null ? "" : "user_id");
//		int totalArticleCount = boardMapper.getTotalArticleCount(param);
//		int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;
//
//		BoardListDto boardListDto = new BoardListDto();
//		boardListDto.setArticles(list);
//		boardListDto.setCurrentPage(currentPage);
//		boardListDto.setTotalPageCount(totalPageCount);
//
//		return boardListDto;
//	}
	
	
	//글목록 불러오기..
	public List<BoardDto> getArticleList() throws Exception {
		List<BoardDto> boardDtoList = boardMapper.getArticleList();
		return boardDtoList;
	}

	//글 수정
	public void modifyArticle(BoardDto boardDto) throws Exception {
		boardMapper.modifyArticle(boardDto);
	}
	
	//글 삭제
	public void deleteArticle(int no) throws Exception {
		boardMapper.deleteArticle(no);
	}
	
	//글 제목 검색
	public List<BoardDto> getArticleByTitle(String subtitle) throws Exception {
		return boardMapper.getArticleByTitle(subtitle);
	}
	//글 번호 검색
	public BoardDto getArticleByNo(int no) throws Exception {
		return boardMapper.getArticleByNo(no);
	}
		
	
	//조회수 업데이트
	public void updateHit(int no) throws Exception {
		boardMapper.updateHit(no);
	}	
		
}
