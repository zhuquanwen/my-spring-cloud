package com.iscas.test.service;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class TestService {
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
}
