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
import com.ssafy.whereismyhome.board.model.service.RentalBoardService;

import lombok.AllArgsConstructor;


@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
@RequestMapping("/rentalboard")
@AllArgsConstructor
public class RentalBoardController {

	private static final Logger logger = LoggerFactory.getLogger(RentalBoardController.class);
	private RentalBoardService rentalBoardService;

	//글작성
	@PostMapping("")
	public ResponseEntity writeRentalArticle(@RequestBody BoardDto boardDto) {
		logger.info("writeArticle boardDto - {}", boardDto);
		try {
			rentalBoardService.writeRentalArticle(boardDto);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
		
	//제목검색&전체검색
	@GetMapping("")
	public ResponseEntity getRentalArticleByTitle(@RequestParam(required = false) String title) throws Exception {
		logger.info("getRentalArticleByTitle - 호출 : " + title);
		if(title==null) {
			System.out.println("null condition");
			return new ResponseEntity(rentalBoardService.getRentalArticleList(), HttpStatus.OK);
		} else {
			return new ResponseEntity(rentalBoardService.getRentalArticleByTitle(title), HttpStatus.OK);
		}
		
	}
	
	//번호검색
	@GetMapping("/{no}")
	public ResponseEntity<BoardDto> getRentalArticleByNo(@PathVariable("no") int no) throws Exception {
		logger.info("getArticle - 호출 : " + no);
		rentalBoardService.updateRentalHit(no);
		return new ResponseEntity<BoardDto>(rentalBoardService.getRentalArticleByNo(no), HttpStatus.OK);
	}

	
	//해당번호글 수정
	@PutMapping("/{no}")
	public ResponseEntity<String> modifyRentalArticle(@RequestBody BoardDto boardDto) throws Exception {
		logger.info("modifyArticle - 호출 {}", boardDto);
		rentalBoardService.modifyRentalArticle(boardDto);
		return ResponseEntity.ok().build();
	}
	
	//해당번호글삭제
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteRentalArticle(@PathVariable("no") int no) throws Exception {
		logger.info("deleteArticle - 호출");
		rentalBoardService.deleteRentalArticle(no);
		return ResponseEntity.ok().build();
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}