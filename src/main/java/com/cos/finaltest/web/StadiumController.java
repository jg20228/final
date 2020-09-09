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
import com.cos.finaltest.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StadiumController {
	
	private final StadiumRepository stadiumRepository;

	
	@GetMapping("/stardium")
	public String stardium(Model model) {
		model.addAttribute("stardiums", stadiumRepository.findAll());
		return "stardium/stardium";
	}
	
	@GetMapping("/stardiumSaveForm")
	public String stardiumSaveForm() {
		return "stardium/stardiumSaveForm";
	}
	
	@GetMapping("/stardiumUpdateForm/{id}/{name}")
	public String stardiumUpdateForm(@PathVariable int id,@PathVariable String name,Model model) {
		System.out.println(id+","+name);
		Stadium stadium = stadiumRepository.findByIdAndName(id, name);
		model.addAttribute("stadium", stadium);
		return "stardium/stardiumUpdateForm";
	}
	
	@PostMapping("/stardium")
	public @ResponseBody String stardiumSaveProc(Stadium stadium) {
		System.out.println("@PostMapping"+stadium);
		stadiumRepository.save(stadium);
		return "완료";
	}

	@PutMapping("/stardium")
	public @ResponseBody String stardiumUpdateProc(Stadium stadium) {
		System.out.println("@PutMapping"+stadium);
		stadiumRepository.update(stadium);
		return "완료";
	}
	
	@DeleteMapping("/stardium")
	public @ResponseBody String stardiumDeleteProc(int id) {
		System.out.println("@DeleteMapping"+id);
		stadiumRepository.deleteById(id);
		return "완료";
	}
}
