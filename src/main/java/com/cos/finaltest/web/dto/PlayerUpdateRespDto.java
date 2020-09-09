package com.cos.finaltest.web.dto;

import java.util.List;

import com.cos.finaltest.model.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerUpdateRespDto {
	private PlayerRespDto playerRespDto;
	private List<Team> teams;
}
