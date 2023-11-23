package com.ssafy.whereismyhome.auth.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.apart.dto.response.ApartDto;
import com.ssafy.whereismyhome.board.dto.BoardDto;
import com.ssafy.whereismyhome.board.dto.FileInfoDto;

@Mapper
public interface AuthMapper {
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	List<ApartDto> getAparts() throws SQLException;
	
	
}
