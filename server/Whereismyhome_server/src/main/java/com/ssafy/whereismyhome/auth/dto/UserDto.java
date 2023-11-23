package com.ssafy.whereismyhome.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String id;
	private String loginId;
	private String password;
	private String role;
	private String nickname;
	private String openAgreement;
	
}
