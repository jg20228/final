package com.cos.finaltest.repository;

import java.util.List;

import com.cos.finaltest.web.dto.StatisticsRespDto;

public interface StatRepository {
	//각 팀별로 조인문
	public List<StatisticsRespDto> findAll();
	
}
