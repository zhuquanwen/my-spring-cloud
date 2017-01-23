package com.iscas.test.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class TestService {
//	@Autowired
//	//@Qualifier(value="restTemplate")
//	private RestTemplate client;
	
	@Autowired
	private FeignService feignService;
	Random r = new Random();
	@HystrixCommand(fallbackMethod="fallback")
	public String test(){
		if(r.nextBoolean() == true){
			throw new RuntimeException("出错啦!");
		}else{
			return "调用成功!";
		}
	}
	public String fallback(){
		return "调用出错啦!";
	}
//	@HystrixCommand(fallbackMethod="fallback1")
//	public String test1(){
//		if(r.nextBoolean() == true){
//			throw new RuntimeException("出错啦!");
//		}else{
//			return client.getForObject("http://service/test1", String.class);
//		}
//	}
//	public String fallback1(){
//		return "调用出错啦!";
//	}
	
	@HystrixCommand(fallbackMethod="fallback2")
	public String testFeign(){
		return feignService.myTest();
	}
	public String fallback2(){
		return "调用出错啦!";
	}
}
