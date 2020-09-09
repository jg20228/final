package com.cos.finaltest.repository;

import java.util.List;

import com.cos.finaltest.model.Team;
import com.cos.finaltest.web.dto.TeamRespDto;

public interface TeamRepository {
	public void save(Team team);
	public List<Team> findAll();
	public void deleteById(int id);
	public TeamRespDto findByIdAndName(int id, String name);
	public void update(Team team);
}
