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
public class StadiumRespDto {
	private	int id;
	private	String name;
	private	Timestamp createDate;
	private int no;
}
