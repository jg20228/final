package com.cos.finaltest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	@GetMapping({"","/"})
	public String test() {
		return "index";
	}
	
	@GetMapping("/stardium")
	public String stardiumTest() {
		return "stardium/stardium";
	}
	
	@GetMapping("/stardiumSaveForm")
	public String stardiumSaveFormTest() {
		return "stardium/stardiumSaveForm";
	}
	
}
