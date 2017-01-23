package com.iscas.test.service;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrixService implements FeignService{

	@Override
	public String myTest() {
		
		return "出错了";
	}

}
