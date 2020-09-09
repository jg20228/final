package com.cos.finaltest.repository;

import java.util.List;

import com.cos.finaltest.model.Expulsion;
import com.cos.finaltest.web.dto.ExpulsionDto;


public interface ExpulsionRepository {
	public List<ExpulsionDto> findAll(int teamId); 
	public void save(Expulsion expulsion);
}
