package com.ssafy.whereismyhome.board.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	private int articleNo;

	private String userId;

	private String subject;

	private String content;

	private int hit;

	private String registerTime;

}
