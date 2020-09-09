package com.cos.finaltest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsRespDto {
	private String position;
	private String doosan;
	private String nc;
	private String lotte;
}
