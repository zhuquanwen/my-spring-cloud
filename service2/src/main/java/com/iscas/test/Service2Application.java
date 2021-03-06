package com.iscas.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class Service2Application {
	@Value("${test.msg}")
	private String msg;
	@RequestMapping("/test1")
	public String test1(){
		return "2222" + msg;
	}
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
}
