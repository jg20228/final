package com.cos.finaltest.repository;

import java.util.List;

import com.cos.finaltest.model.Stadium;
import com.cos.finaltest.web.dto.StadiumRespDto;

public interface StadiumRepository {
	public void save(Stadium stadium);
	public List<Stadium> findAll();
	public void deleteById(int id);
	public StadiumRespDto findByIdAndName(int id, String name);
	public void update(Stadium stadium);
}
