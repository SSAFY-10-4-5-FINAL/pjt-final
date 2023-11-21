package com.ssafy.whereismyhome.apart.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.apart.dto.response.ApartDealDto;
import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.dto.response.DealInfoDto;
import com.ssafy.whereismyhome.apart.dto.response.DongDto;
import com.ssafy.whereismyhome.apart.dto.response.StarredApartListDto;
import com.ssafy.whereismyhome.apart.model.service.ApartService;
import com.ssafy.whereismyhome.board.dto.BoardDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
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
	public ResponseEntity getAparts(@RequestParam(required = true) String dongCode) throws SQLException {
		List<ApartDto> apartDtoList = null;
		apartDtoList = apartService.getApartByDongCode(dongCode);
		//if (dong == null) apartDtoList = apartService.getAparts();
		//else apartDtoList = apartService.getApartByDong(dong);
		//System.out.println("in controller");
		//System.out.println("end service call");
		return new ResponseEntity(apartDtoList,HttpStatus.OK);
	}
	
	//아파트 이름 일부로 검색 -> 이름이 해당 문자열 포함하는 아파트 리스트 리턴.
	@GetMapping("/searchname/{subName}")
	public ResponseEntity getApartBySubname(@PathVariable String subName) throws SQLException {
		List<ApartDto> apartDtoList = null;
		apartDtoList = apartService.getApartBySubname(subName);
		return new ResponseEntity(apartDtoList,HttpStatus.OK);
	}
	
	//아파트 이름 일부로 검색 -> 이름이 해당 문자열 포함하는 아파트 리스트 리턴.
	@GetMapping("/searchdong/{subDong}")
	public ResponseEntity getDongBySubDong(@PathVariable String subDong) throws SQLException {
		List<DongDto> DongDtoList = null;
		DongDtoList = apartService.getDongBySubDong(subDong);
		return new ResponseEntity(DongDtoList,HttpStatus.OK);
	}
	
	
	//아파트코드로 검색 : 거래내역도 반환돼야함 -> 해당하는 아파트 객체 하나 ApartDealDto로 리턴/ 그안에 한 col 은 거래내역list 
	@GetMapping("/{aptCode}")
	public ResponseEntity getApartByCode(@PathVariable Long aptCode) throws SQLException {
		System.out.println("in getAptbyCode");
		ApartDealDto apartDealDto=new ApartDealDto();
		ApartDto apartDto=null;
		List<DealInfoDto> dealInfoList = null;
		
		System.out.println("in controller-try service call");
		apartDto=apartService.getApartByCode(aptCode);
		System.out.println("service call-1-end");
		dealInfoList= apartService.getDealListByCode(aptCode);
		System.out.println("service call-2-end");
		//System.out.println(apartDto.getLng());
		//
		//apartDealDto.aptDto = apartDto;
		apartDealDto.setAptDto(apartDto);
		apartDealDto.setDealInfoList(dealInfoList);
		//apartDealDto.dealInfoList = dealInfoList;
		//
		System.out.println("end service call.-aptcode");
		return new ResponseEntity(apartDealDto,HttpStatus.OK);
	}
	
	//조회수 순 아파트 GET(상위 10개)
	@GetMapping("/aptlistbyhit")
	public ResponseEntity getApartByHit() throws SQLException {
		List<ApartDto> apartDtoList = null;
		apartDtoList = apartService.getApartByHit();
		return new ResponseEntity(apartDtoList,HttpStatus.OK);
	}
	
	
	@PostMapping("/starred/apart")
	public ResponseEntity getStarredAparts(@RequestBody String userId) throws SQLException {
		System.out.println(userId);
		List<String> starredApartList = apartService.getStarredAparts(userId);
		return new ResponseEntity(starredApartList, HttpStatus.OK);
	}
	
	
	@PostMapping("/starred/area")
	public ResponseEntity getStarredAreas(@RequestBody String userId) throws SQLException {
		System.out.println(userId);
		List<String> starredAreaList = apartService.getStarredAreas(userId);
		return new ResponseEntity(starredAreaList, HttpStatus.OK);
	}
	

	
	
	
	
	//아직필요없
	@GetMapping("/deal/{dealNo}")
	public ApartDto getDealByNo(@PathVariable Long dealNo) throws SQLException {
		ApartDto apartDto= apartService.getDealByNo(dealNo);
		return apartDto;
	}
	
}
