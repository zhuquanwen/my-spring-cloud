package com.iscas.test.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.feign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.netflix.feign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.ILoadBalancer;

import feign.Client;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import okhttp3.ConnectionPool;
@Configuration
@ConditionalOnProperty(value = "feign.okhttp.enabled", matchIfMissing = true)
@ConditionalOnClass({ ILoadBalancer.class, Feign.class,okhttp3.OkHttpClient.class })
@AutoConfigureBefore(FeignRibbonClientAutoConfiguration.class)
public class FeignConfig {
//	@Autowired(required = false)
	private okhttp3.OkHttpClient okHttpClient;
	@Bean
	public okhttp3.OkHttpClient okHttpClient(){
		if(okHttpClient != null){
			return okHttpClient;
		}else{
			okhttp3.OkHttpClient.Builder ClientBuilder=new okhttp3.OkHttpClient.Builder();  
	        ClientBuilder.readTimeout(30, TimeUnit.SECONDS);//读取超时  
	        ClientBuilder.connectTimeout(10, TimeUnit.SECONDS);//连接超时  
	        ClientBuilder.writeTimeout(60, TimeUnit.SECONDS);//写入超时  
	        ClientBuilder.connectionPool(new ConnectionPool(60, 3, java.util.concurrent.TimeUnit.SECONDS));
	        okHttpClient=ClientBuilder.build(); 
			
		}
		return okHttpClient;
	}
	
	
	@Bean
	public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
			SpringClientFactory clientFactory) {
		OkHttpClient delegate;
		if (okHttpClient() != null) {
			delegate = new OkHttpClient(this.okHttpClient);
		}
		else {
			delegate = new OkHttpClient();
		}
			return new LoadBalancerFeignClient(delegate, cachingFactory, clientFactory);
		}
		
	
}
