package com.anvesh.spring.boot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnveshContoller {

	@GetMapping("/msg")
	public String getMsg() {
		return "Hello Anvesh!!!";
	}
}
