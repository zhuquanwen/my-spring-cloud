package com.iscas.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient(name="service",fallback = FeignHystrixService.class)
public interface FeignService {
	@RequestMapping(method = RequestMethod.POST,value="/test1",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody  String myTest();
	
}
