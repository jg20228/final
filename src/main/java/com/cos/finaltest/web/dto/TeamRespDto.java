package com.cos.finaltest.web.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamRespDto {
	private int id;
	private String stadiumName;
	private String teamName; //팀이름
	private Timestamp createDate;
}
