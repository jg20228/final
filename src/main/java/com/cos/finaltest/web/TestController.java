package com.cos.finaltest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.finaltest.model.Stadium;
import com.cos.finaltest.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final StadiumRepository stadiumRepository;
	
	//JSON으로 값오나 확인
	@GetMapping("test/stardium")
	public @ResponseBody List<Stadium> gstardiumTest() {
		return stadiumRepository.findAll();
	}
}
