package com.cos.finaltest.web.dto;

import java.util.List;

import com.cos.finaltest.model.Stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamUpdateRespDto {
	private TeamRespDto teamRespDto;
	private List<Stadium> stadiums;
}
