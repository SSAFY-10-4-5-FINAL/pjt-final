package com.ssafy.whereismyhome.apart.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.model.mapper.ApartMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApartService {
	
	private ApartMapper apartMapper;

	public List<ApartDto> getAparts() throws SQLException {
		List<ApartDto> apartDtoList = apartMapper.getAparts();
		
		return apartDtoList;
	}

	public List<ApartDto> getApartByCode(Long aptCode) throws SQLException {
		List<ApartDto> apartDtoList = apartMapper.getApartByCode(aptCode);
		
		return apartDtoList;
	}

	public List<ApartDto> getApartByDong(String dong) throws SQLException {
		List<ApartDto> apartDtoList = apartMapper.getApartByDong(dong);
		
		return apartDtoList;
	}

	public ApartDto getDealByNo(Long dealNo) throws SQLException {
		ApartDto apartDto = apartMapper.getDealByNo(dealNo);
		return apartDto;
	}

	
	
}
