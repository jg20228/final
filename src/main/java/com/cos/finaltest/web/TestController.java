package com.cos.finaltest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.finaltest.model.Stadium;
import com.cos.finaltest.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final StadiumRepository stadiumRepository;

	@GetMapping({"","/"})
	public String test() {
		return "index";
	}
	
	@GetMapping("/stardium")
	public String stardiumTest() {
		return "stardium/stardium";
	}
	
	@PostMapping("/stardium")
	public @ResponseBody String stardiumSaveProcTest(Stadium stadium) {
		System.out.println("여긴 오나");
		System.out.println(stadium);
		stadiumRepository.save(stadium);
		return "완료";
	}
	
	@GetMapping("/stardiumSaveForm")
	public String stardiumSaveFormTest() {
		return "stardium/stardiumSaveForm";
	}
	
}
