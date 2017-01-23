package com.iscas.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {
	@Autowired
	private TestService testService;
	public String test(){
		return testService.test();
	}
}
