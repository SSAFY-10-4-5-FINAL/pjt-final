package com.ssafy.whereismyhome.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		List<FileInfoDto> fileInfos = boardDto.getFileInfos();
	}

	public BoardListDto listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "b.user_id");
		List<BoardDto> list = boardMapper.listArticle(param);

		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "user_id");
		int totalArticleCount = boardMapper.getTotalArticleCount(param);
		int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

		BoardListDto boardListDto = new BoardListDto();
		boardListDto.setArticles(list);
		boardListDto.setCurrentPage(currentPage);
		boardListDto.setTotalPageCount(totalPageCount);

		return boardListDto;
	}
	
	public BoardDto getArticle(int articleNo) throws Exception {
		return boardMapper.getArticle(articleNo);
	}

	public void updateHit(int articleNo) throws Exception {
		boardMapper.updateHit(articleNo);
	}

	public void modifyArticle(BoardDto boardDto) throws Exception {
		// TODO : BoardDaoImpl의 modifyArticle 호출
		boardMapper.modifyArticle(boardDto);
	}

	public void deleteArticle(int articleNo) throws Exception {
		// TODO : BoardDaoImpl의 deleteArticle 호출
		boardMapper.deleteArticle(articleNo);
	}
}
