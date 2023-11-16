package com.ssafy.whereismyhome.apart.controller;


import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.model.service.ApartService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/apart")
@AllArgsConstructor
public class ApartController {
	
	private ApartService apartService;

	@GetMapping("")
	public List<ApartDto> getAparts(@RequestParam(required = false) String dong) throws SQLException {
		List<ApartDto> apartDtoList = null;
		if (dong == null) apartDtoList = apartService.getAparts();
		else apartDtoList = apartService.getApartByDong(dong);
		
		return apartDtoList;
	}
	
	@GetMapping("/{aptCode}")
	public List<ApartDto> getApartByCode(@PathVariable Long aptCode) throws SQLException {
		List<ApartDto> apartDtoList = apartService.getApartByCode(aptCode);
		
		return apartDtoList;
	}
	
	@GetMapping("/deal/{dealNo}")
	public ApartDto getDealByNo(@PathVariable Long dealNo) throws SQLException {
		ApartDto apartDto= apartService.getDealByNo(dealNo);
		
		return apartDto;
	}
	
}
