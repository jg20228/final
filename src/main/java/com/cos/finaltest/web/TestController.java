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

	@GetMapping({"","/"})
	public String test() {
		return "index";
	}
	
	@GetMapping("/stardium")
	public String stardiumTest(Model model) {
		model.addAttribute("stardiums", stadiumRepository.findAll());
		return "stardium/stardium";
	}
	
	//JSON으로 값오나 확인
	@GetMapping("test/stardium")
	public @ResponseBody List<Stadium> gstardiumTest() {
		return stadiumRepository.findAll();
	}
	
	@PostMapping("/stardium")
	public @ResponseBody String stardiumSaveProcTest(Stadium stadium) {
		System.out.println("@PostMapping"+stadium);
		stadiumRepository.save(stadium);
		return "완료";
	}
	
	@DeleteMapping("/stardium")
	public @ResponseBody String stardiumDeleteProcTest(int id) {
		System.out.println("@DeleteMapping"+id);
		stadiumRepository.deleteById(id);
		return "완료";
	}
	
	@PutMapping("/stardium")
	public @ResponseBody String stardiumUpdateProcTest(Stadium stadium) {
		System.out.println("@PutMapping"+stadium);
		stadiumRepository.update(stadium);
		return "완료";
	}
	
	@GetMapping("/stardiumSaveForm")
	public String stardiumSaveFormTest() {
		return "stardium/stardiumSaveForm";
	}
	
	@GetMapping("/stardiumUpdateForm/{id}/{name}")
	public String stardiumUpdateFormTest(@PathVariable int id,@PathVariable String name,Model model) {
		System.out.println(id+","+name);
		Stadium stadium = stadiumRepository.findByIdAndName(id, name);
		model.addAttribute("stadium", stadium);
		return "stardium/stardiumUpdateForm";
	}
	
}
