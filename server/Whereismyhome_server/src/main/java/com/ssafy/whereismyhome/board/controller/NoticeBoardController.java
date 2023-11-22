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
import com.ssafy.whereismyhome.board.model.service.NoticeBoardService;
import com.ssafy.whereismyhome.board.model.service.RentalBoardService;

import lombok.AllArgsConstructor;


@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@RequestMapping("/noticeboard")
@AllArgsConstructor
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	private NoticeBoardService noticeBoardService;

	//글작성
	@PostMapping("")
	public ResponseEntity writeNoticeArticle(@RequestBody BoardDto boardDto) {
		logger.info("writeNoticeArticle boardDto - {}", boardDto);
		try {
			noticeBoardService.writeNoticeArticle(boardDto);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
		
	//제목검색&전체검색
	@GetMapping("")
	public ResponseEntity getNoticeArticleByTitle(@RequestParam(required = false) String title) throws Exception {
		logger.info("getnoticeArticleByTitle - 호출 : " + title);
		if(title==null) {
			System.out.println("null condition");
			return new ResponseEntity(noticeBoardService.getNoticeArticleList(), HttpStatus.OK);
		} else {
			return new ResponseEntity(noticeBoardService.getNoticeArticleByTitle(title), HttpStatus.OK);
		}
		
	}
	
	//번호검색
	@GetMapping("/{no}")
	public ResponseEntity<BoardDto> getNoticeArticleByNo(@PathVariable("no") int no) throws Exception {
		logger.info("getArticle - 호출 : " + no);
		noticeBoardService.updateNoticeHit(no);
		return new ResponseEntity<BoardDto>(noticeBoardService.getNoticeArticleByNo(no), HttpStatus.OK);
	}

	
	//해당번호글 수정
	@PutMapping("/{no}")
	public ResponseEntity<String> modifyRentalArticle(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("modifynoticeArticle - 호출 {}", boardDto);
		noticeBoardService.modifyRentalArticle(boardDto);
		return ResponseEntity.ok().build();
	}
	
	//해당번호글삭제
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteRentalArticle(@PathVariable("no") int no) throws Exception {
		logger.info("deleteArticle - 호출");
		noticeBoardService.deleteNoticeArticle(no);
		return ResponseEntity.ok().build();
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}