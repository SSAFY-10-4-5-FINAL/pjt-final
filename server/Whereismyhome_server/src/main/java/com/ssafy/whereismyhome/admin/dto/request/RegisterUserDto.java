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
public class RegisterUserDto {

	private String userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String birthDate;
	private String userTel;
	
}
