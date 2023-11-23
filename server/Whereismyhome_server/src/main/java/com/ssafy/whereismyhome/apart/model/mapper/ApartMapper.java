package com.ssafy.whereismyhome.apart.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.apart.dto.response.ApartDealDto;
import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.apart.dto.response.DealInfoDto;
import com.ssafy.whereismyhome.apart.dto.response.DongDto;
import com.ssafy.whereismyhome.apart.dto.response.StarredApartListDto;

@Mapper
public interface ApartMapper {

	List<ApartDto> getAparts() throws SQLException;
	//new
	List<ApartDto> getApartByDongCode(String dongCode) throws SQLException;
	List<ApartDto> getApartBySubname(String subName) throws SQLException;
	List<DongDto> getDongBySubDong(String subDong) throws SQLException;
	
	List<DealInfoDto> getDealListByCode(Long aptCode) throws SQLException;
	ApartDto getApartByCode(Long aptCode) throws SQLException;
	
	List<ApartDto> getApartByHit() throws SQLException;
	
	List<String> getStarredAparts(Long userId) throws SQLException;
	List<String> getStarredAreas(String userId) throws SQLException;
	
	//아직필요없
	ApartDto getDealByNo(Long dealNo) throws SQLException;
	//List<ApartDto> getApartByDong(String dong) throws SQLException;
}
