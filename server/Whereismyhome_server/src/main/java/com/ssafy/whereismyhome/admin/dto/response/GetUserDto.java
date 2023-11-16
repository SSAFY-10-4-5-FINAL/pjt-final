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

	private String userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String birthDate;
	private String userTel;
	private String joinDate;
	
}
