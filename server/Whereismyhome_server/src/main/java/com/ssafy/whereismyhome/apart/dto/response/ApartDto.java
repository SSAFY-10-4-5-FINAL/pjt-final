package com.ssafy.whereismyhome.apart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApartDto {

	private Long aptCode;
	private String apartmentName;
	private String dealAmount;
	
}
