package com.cos.finaltest.repository;

import java.util.List;

import com.cos.finaltest.model.Player;
import com.cos.finaltest.web.dto.PlayerRespDto;
import com.cos.finaltest.web.dto.TeamRespDto;

public interface PlayerRepository {
	public void save(Player player);
	public List<Player> findAll();
	public List<Player> findAllJoin();
	public void deleteById(int id);
	public PlayerRespDto findByIdAndName(int id, String name);
	public void update(Player player);
}
