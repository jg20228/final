package com.cos.finaltest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.finaltest.model.Stadium;
import com.cos.finaltest.model.Team;
import com.cos.finaltest.repository.StadiumRepository;
import com.cos.finaltest.repository.TeamRepository;
import com.cos.finaltest.web.dto.TeamUpdateRespDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class TeamController {
	
	private final TeamRepository teamRepository;
	private final StadiumRepository stadiumRepository;

	@GetMapping("/team")
	public String team(Model model) {
		model.addAttribute("teams", teamRepository.findAllJoin());
		return "team/team";
	}
	
	@GetMapping("/teamSaveForm")
	public String teamSave(Model model) {
		model.addAttribute("stardiums", stadiumRepository.findAll());
		return "team/teamSaveForm";
	}
	
	@GetMapping("/teamUpdateForm/{id}/{name}")
	public String teamUpdate(@PathVariable int id,@PathVariable String name,Model model) {
		System.out.println(id+","+name);
		TeamUpdateRespDto teamUpdateRespDto = TeamUpdateRespDto.builder()
				.teamRespDto(teamRepository.findByIdAndName(id, name))
				.stadiums(stadiumRepository.findAll())
				.build();
		System.out.println(teamUpdateRespDto);
		model.addAttribute("respDto", teamUpdateRespDto);
		return "team/teamUpdateForm";
	}
	
	@PostMapping("/team")
	public @ResponseBody String stardiumSaveProc(Team team) {
		System.out.println("@PostMapping"+team);
		teamRepository.save(team);
		return "완료";
	}
	
	@PutMapping("/team")
	public @ResponseBody String stardiumUpdateProc(Team team) {
		System.out.println("@PutMapping"+team);
		teamRepository.update(team);
		return "완료";
	}
	
	@DeleteMapping("/team")
	public @ResponseBody String stardiumDeleteProc(int id) {
		System.out.println("@DeleteMapping"+id);
		teamRepository.deleteById(id);
		return "완료";
	}
	
}
