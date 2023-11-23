package com.ssafy.whereismyhome.apart.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.apart.dto.response.ApartDealDto;
import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.dto.response.DealInfoDto;
import com.ssafy.whereismyhome.apart.dto.response.DongDto;
import com.ssafy.whereismyhome.apart.dto.response.StarredApartListDto;
import com.ssafy.whereismyhome.apart.model.mapper.ApartMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApartService {
	
	private final ApartMapper apartMapper;

	public List<ApartDto> getAparts() throws SQLException {
		List<ApartDto> apartDtoList = apartMapper.getAparts();	
		return apartDtoList;
	}

	////added
	
	//동 코드로 검색 -> 동 에 있는 모든 아파트 리스트로 리턴
	//ApartDto
	public List<ApartDto> getApartByDongCode(String dongCode) throws SQLException {
		System.out.println("in service, getAgyDongCode");
		List<ApartDto> apartDtoList = apartMapper.getApartByDongCode(dongCode);
		
		return apartDtoList;
	}
	
	//아파트 이름 일부로 검색 -> 이름이 해당 문자열 포함하는 아파트 리스트 리턴.
	public List<ApartDto> getApartBySubname(String subName) throws SQLException {
		System.out.println("in service, getAgyDongCode");
		List<ApartDto> apartDtoList = apartMapper.getApartBySubname(subName);
		
		return apartDtoList;
	}
	
	//아파트 이름 일부로 검색 -> 이름이 해당 문자열 포함하는 아파트 리스트 리턴.
	public List<DongDto> getDongBySubDong(String subDong) throws SQLException {
		System.out.println("in service, subDongsearch");
		List<DongDto> DongDtoList = apartMapper.getDongBySubDong(subDong);
		return DongDtoList;
	}
		
		
	
	
	//아파트 코드로 검색->해당객체 한개 리턴 //return type :ApartDealDto
	public ApartDto getApartByCode(Long aptCode) throws SQLException {
		System.out.println("in service-getApartByCode");
		ApartDto apartDto = apartMapper.getApartByCode(aptCode);
		return apartDto;
	}
	
	//아파트 코드로 검색-> 거래내역 리스트 리턴. //return type:DealInfoDto list
	public List<DealInfoDto> getDealListByCode(Long aptCode) throws SQLException {
		List<DealInfoDto> DealInfoDtoList = apartMapper.getDealListByCode(aptCode);
		return DealInfoDtoList;
	}
	
	
	//조회수 순 아파트 GET(상위 10개)
	public List<ApartDto> getApartByHit() throws SQLException {
		System.out.println("in service, getaptlist sorted by hit");
		List<ApartDto> apartDtoList = apartMapper.getApartByHit();
		return apartDtoList;
	}

	//찜한 아파트 목록 불러오기 -> 인풋 id 해당하는 멤버의 찜한목록
	public List<String> getStarredAparts(String userId) throws SQLException {
		System.out.println("in service, getAptDongCode");
		List<String> starredApartListDto = apartMapper.getStarredAparts(Long.valueOf(userId));
		return starredApartListDto;
	}
	
	//찜한 지역 목록 불러오기 -> 인풋 id 해당하는 멤버의 찜한목록
	public List<String> getStarredAreas(String userId) throws SQLException {
		System.out.println("아이디: " + userId.substring(1, userId.length()-1));
		List<String> starredAreaList = apartMapper.getStarredAreas(userId.substring(1, userId.length()-1));
		return starredAreaList;
	}
	
	
	

	//아직필요없
	public ApartDto getDealByNo(Long dealNo) throws SQLException {
		ApartDto apartDto = apartMapper.getDealByNo(dealNo);
		return apartDto;
	}
	
}
