package com.ssafy.whereismyhome.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDto {

	private String id;
	private String loginId;
	private String password;
	private String nickname;
	private String role;
	private String openAgreement;
	
}
