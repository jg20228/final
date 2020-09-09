package com.cos.finaltest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpulsionDto {
	private int id;
	private int no;
	private String teamName;
	private String playerName;
	private String position;
	private String reason;
	private String createDate;
}
