package com.cos.finaltest.web.dto;

import java.util.List;

import com.cos.finaltest.model.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpulsionRespDto {
	List<Team> Teams;
	List<ExpulsionDto> expulsionDtos;
}
