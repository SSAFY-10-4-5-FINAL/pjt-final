package com.ssafy.whereismyhome.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserDto {

	private String loginId;
	private String password;
	private String nickname;
	private String role;
	private String openAgreement;
	
}
