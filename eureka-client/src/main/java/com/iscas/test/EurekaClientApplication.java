package com.iscas.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableAutoConfiguration
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableZuulProxy
public class EurekaClientApplication {
//	@Bean(name="restTemplate")
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        RestTemplate template = new RestTemplate();
//        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
//        factory.setConnectTimeout(3000);
//        factory.setReadTimeout(3000);
//        return template;
//    }
	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
