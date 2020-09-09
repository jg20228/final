package com.cos.finaltest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.finaltest.repository.StatRepository;
import com.cos.finaltest.web.dto.StatisticsRespDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	private final StatRepository statRepository;
	
	@GetMapping({"","/"})
	public String test() {
		return "index";
	}
	
	@GetMapping("/position")
	public String position(Model model) {
		List<StatisticsRespDto> respDto = statRepository.findAll();
		model.addAttribute("stats", respDto);
		System.out.println(respDto);
		return "stat/statistics";
	}
}
