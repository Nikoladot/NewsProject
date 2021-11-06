package com.news.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestController {
	
	
	@RequestMapping(value = "/")
	public String getTestTest() {
		
		//DANIJEL
		
		return "TEST";
	}

}
