package com.iscas.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iscas.test.service.HystrixService;

@RestController
public class TestController {
	@Autowired
	private HystrixService hystrixService;
	@RequestMapping("/testHystrix")
	public String testHystrix(){
		return hystrixService.test();
	}
}
