package com.ssafy.whereismyhome.apart.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.apart.dto.response.ApartDealDto;
import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.model.service.ApartService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/apart")
@AllArgsConstructor
public class ApartController {
	
	private final ApartService apartService;

//	@GetMapping("")
//	public List<ApartDto> getAparts(@RequestParam(required = false) String dong) throws SQLException {
//		List<ApartDto> apartDtoList = null;
//		if (dong == null) apartDtoList = apartService.getAparts();
//		else apartDtoList = apartService.getApartByDong(dong);
//		
//		return apartDtoList;
//	}
	
	
//	@GetMapping("/?")
//	public List<ApartDto> getApartByCode(@PathVariable Long aptCode) throws SQLException {
//		List<ApartDto> apartDtoList = apartService.getApartByCode(aptCode);
//		
//		return apartDtoList;
//	}
	
	
//	@GetMapping("/{aptCode}")
//	public List<ApartDto> getApartByCode(@PathVariable Long aptCode) throws SQLException {
//		List<ApartDto> apartDtoList = apartService.getApartByCode(aptCode);
//		
//		return apartDtoList;
//	}

	//동코드로 검색 - > 거기있는 아파트들 ApartDto list 로 리턴
	@GetMapping("")
	public List<ApartDto> getAparts(@RequestParam(required = true) String dongCode) throws SQLException {
		List<ApartDto> apartDtoList = null;
		//if (dong == null) apartDtoList = apartService.getAparts();
		//else apartDtoList = apartService.getApartByDong(dong);
		System.out.println("in controller");
		apartDtoList = apartService.getApartByDongCode(dongCode);
		System.out.println("end service call");
		return apartDtoList;
	}
	
	
	//아파트코드로 검색 : 거래내역도 반환돼야함 -> 해당하는 아파트 객체 하나 ApartDealDto로 리턴/ 그안에 한 col 은 거래내역list 
	@GetMapping("/{aptCode}")
	public ApartDealDto getApartByCode(@PathVariable Long aptCode) throws SQLException {
		ApartDealDto apartDealDto=null;
		System.out.println("in controller");
		apartDealDto.setAptDto(apartService.getApartByCode(aptCode));
		apartDealDto.dealInfoList = apartService.getDealListByCode(aptCode);
		
		return apartDealDto;
	}
	
	
	//아직필요없
	@GetMapping("/deal/{dealNo}")
	public ApartDto getDealByNo(@PathVariable Long dealNo) throws SQLException {
		ApartDto apartDto= apartService.getDealByNo(dealNo);
		return apartDto;
	}
	
}
