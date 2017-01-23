package com.iscas.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {
	
	@Autowired
	private TestService testService;
	public String test(){
		return testService.test();
	}
	
//	public String test1(){
//		return testService.test1();
//	}
	public String testFeign(){
		return testService.testFeign();
	}
	
}
