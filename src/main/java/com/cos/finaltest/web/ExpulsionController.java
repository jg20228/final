package com.cos.finaltest.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.finaltest.model.Expulsion;
import com.cos.finaltest.repository.ExpulsionRepository;
import com.cos.finaltest.repository.PlayerRepository;
import com.cos.finaltest.repository.TeamRepository;
import com.cos.finaltest.web.dto.CommonRespDto;
import com.cos.finaltest.web.dto.ExpulsionRespDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ExpulsionController {

	private final ExpulsionRepository expulsionRepository;
	private final PlayerRepository playerRepository; 
	private final TeamRepository teamRepository;
	
	@GetMapping("/expulsion")
	public String expulsion(Model model) {
		ExpulsionRespDto respDto = ExpulsionRespDto.builder()
				.Teams(teamRepository.findAll())
				.expulsionDtos(expulsionRepository.findAll(1))
				.build();
		System.out.println(respDto);
		model.addAttribute("respDto", respDto);
		return "expulsion/expulsion";
	}
	
	//여기서 id는 teamId
	@GetMapping("/expulsion/{id}")
	public @ResponseBody CommonRespDto<?> expulsionGet(@PathVariable int id, Model model) {
		ExpulsionRespDto respDto = ExpulsionRespDto.builder()
				.Teams(teamRepository.findAll())
				.expulsionDtos(expulsionRepository.findAll(id))
				.build();
		System.out.println(respDto);
		return new CommonRespDto<ExpulsionRespDto>(1, respDto);
	}
	
	@GetMapping("/expulsionSaveForm")
	public String expulsionSave(Model model) {
		model.addAttribute("players", playerRepository.findAll());
		return "expulsion/expulsionSaveForm";
	}
	
	@PostMapping("/expulsion")
	public String expulsionSaveProc(Expulsion expulsion) {
		expulsionRepository.save(expulsion);
		return "expulsion/expulsionSaveForm";
	}
}
