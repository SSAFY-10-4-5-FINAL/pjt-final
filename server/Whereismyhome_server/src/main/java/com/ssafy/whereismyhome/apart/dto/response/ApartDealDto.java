package com.ssafy.whereismyhome.apart.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApartDealDto {

	private ApartDto aptDto;
	private List<DealInfoDto> dealInfoList;
	
}
