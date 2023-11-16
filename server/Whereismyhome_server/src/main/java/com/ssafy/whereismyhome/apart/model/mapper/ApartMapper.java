package com.ssafy.whereismyhome.apart.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;

@Mapper
public interface ApartMapper {

	List<ApartDto> getAparts() throws SQLException;

	List<ApartDto> getApartByCode(Long aptCode) throws SQLException;

	List<ApartDto> getApartByDong(String dong) throws SQLException;

	ApartDto getDealByNo(Long dealNo) throws SQLException;
	
}
