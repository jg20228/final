package com.cos.finaltest.web;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	@GetMapping({"","/"})
	public String test() {
		return "index";
	}
}
