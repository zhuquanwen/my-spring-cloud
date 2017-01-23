package com.iscas.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iscas.test.service.FeignHystrixService;
import com.iscas.test.service.FeignService;
import com.iscas.test.service.HystrixService;

@RestController
public class TestController {
	
	@Autowired
	private HystrixService hystrixService;
	@Autowired
	private FeignService feignService;
	@RequestMapping("/testHystrix")
	public String testHystrix(){
		return hystrixService.test();
	}
//	@RequestMapping("/testRibbon")
//	public String testRibbon(){
//		//return client.getForObject("http://service/test1", String.class);
//		return hystrixService.test1();
//	}
	@RequestMapping("/testFegin")
	public String testFegin(){
		//return client.getForObject("http://service/test1", String.class);
		return hystrixService.testFeign();
	}
	@RequestMapping("/testFeginHystrix")
	public String testFeginHystrix(){
		//return client.getForObject("http://service/test1", String.class);
		return feignService.myTest();
	}
}
