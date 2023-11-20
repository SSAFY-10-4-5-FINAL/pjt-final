package com.ssafy.whereismyhome.apart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealInfoDto {
	private String dealAmount;
	private int dealYear; 
	private int dealMonth;
	private String area;
	private String floor;
}
