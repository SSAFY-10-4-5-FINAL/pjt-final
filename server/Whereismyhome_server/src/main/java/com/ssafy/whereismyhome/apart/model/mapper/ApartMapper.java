package com.ssafy.whereismyhome.apart.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.apart.dto.response.ApartDealDto;
import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.dto.response.DealInfoDto;

@Mapper
public interface ApartMapper {

	List<ApartDto> getAparts() throws SQLException;
	//new
	List<ApartDto> getApartByDongCode(String dongCode) throws SQLException;
	ApartDto getApartByCode(Long aptCode) throws SQLException;
	List<DealInfoDto> getDealInfoListByCode(Long aptCode) throws SQLException;
	
	
	//아직필요없
	ApartDto getDealByNo(Long dealNo) throws SQLException;
	//List<ApartDto> getApartByDong(String dong) throws SQLException;
}
