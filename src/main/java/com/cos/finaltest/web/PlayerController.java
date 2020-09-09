package com.cos.finaltest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.finaltest.model.Player;
import com.cos.finaltest.model.Stadium;
import com.cos.finaltest.repository.PlayerRepository;
import com.cos.finaltest.repository.TeamRepository;
import com.cos.finaltest.web.dto.PlayerUpdateRespDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PlayerController {
	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;

	@GetMapping("/player")
	public String player(Model model) {
		System.out.println("실행테스트");
		model.addAttribute("players", playerRepository.findAllJoin());
		return "player/player";
	}
	
	@GetMapping("/playerSaveForm")
	public String playerSave(Model model) {
		model.addAttribute("teams", teamRepository.findAll());
		return "player/playerSaveForm";
	}
	
	@GetMapping("/playerUpdateForm/{id}/{name}")
	public String playerUpdate(@PathVariable int id,@PathVariable String name,Model model) {
		System.out.println(id+","+name);
		PlayerUpdateRespDto playerUpdateRespDto = PlayerUpdateRespDto.builder()
				.playerRespDto(playerRepository.findByIdAndName(id, name))
				.teams(teamRepository.findAll())
				.build();
		System.out.println(playerUpdateRespDto);
		model.addAttribute("respDto", playerUpdateRespDto);
		return "player/playerUpdateForm";
	}
	
	@PostMapping("/player")
	public @ResponseBody String playerSaveProc(Player player) {
		System.out.println("@PostMapping"+player);
		playerRepository.save(player);
		return "완료";
	}
	
	@PutMapping("/player")
	public @ResponseBody String stardiumUpdateProc(Player player) {
		System.out.println("@PutMapping"+player);
		playerRepository.update(player);
		return "완료";
	}
	
	@DeleteMapping("/player")
	public @ResponseBody String playerSaveProc(int id) {
		System.out.println("@DeleteMapping"+id);
		playerRepository.deleteById(id);
		return "완료";
	}
}
