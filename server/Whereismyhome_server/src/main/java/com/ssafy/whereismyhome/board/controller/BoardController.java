package com.ssafy.whereismyhome.board.controller;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.model.service.ApartService;
import com.ssafy.whereismyhome.board.dto.BoardDto;
import com.ssafy.whereismyhome.board.dto.response.BoardListDto;
import com.ssafy.whereismyhome.board.model.service.BoardService;

import lombok.AllArgsConstructor;


@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";

	private BoardService boardService;

	@PostMapping("")
	public ResponseEntity writeArticle(@RequestBody BoardDto boardDto) {
		logger.info("writeArticle boardDto - {}", boardDto);
		try {
			boardService.writeArticle(boardDto);
//			return ResponseEntity.ok().build();
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	
//	@GetMapping
//	public ResponseEntity getArticleList() throws Exception{
//		List<BoardDto> boardDtoList = null;
//		boardDtoList = boardService.getArticleList();
//		return new ResponseEntity(boardDtoList, HttpStatus.CREATED);
//	}
//	public ResponseEntity<?> getArticleList(			
//			@RequestParam Map<String, String> map) {
//		logger.info("listArticle map - {}", map);
//		try {
//			//BoardListDto boardListDto = boardService.getArticleList(map);
//			HttpHeaders header = new HttpHeaders();
//			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//			return ResponseEntity.ok().headers(header).body(boardListDto);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
		
	@GetMapping("")
	public ResponseEntity getArticleByTitle(@RequestParam(required = false) String title) throws Exception {
		logger.info("getArticle - 호출 : " + title);
		if(title==null) {
			return new ResponseEntity(boardService.getArticleList(), HttpStatus.OK);
		} else {
			return new ResponseEntity(boardService.getArticleByTitle(title), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<BoardDto> getArticleByNo(@PathVariable("no") int no) throws Exception {
		logger.info("getArticle - 호출 : " + no);
		boardService.updateHit(no);
		return new ResponseEntity<BoardDto>(boardService.getArticleByNo(no), HttpStatus.OK);
	}

	

	
	@PutMapping("/{no}")
	public ResponseEntity<String> modifyArticle(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);
		boardService.modifyArticle(boardDto);
		return ResponseEntity.ok().build();
	}
	

	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteArticle(@PathVariable("no") int no) throws Exception {
		logger.info("deleteArticle - 호출");
		boardService.deleteArticle(no);
		return ResponseEntity.ok().build();
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}