package com.iscas.test.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class HttpClientConfig {
//	@Bean(destroyMethod="close")
//	public HttpClientConnectionManager poolingHttpClientConnectionManager(){
//		PoolingHttpClientConnectionManager phccm = new PoolingHttpClientConnectionManager();
//		phccm.setMaxTotal(200);
//		phccm.setDefaultMaxPerRoute(50);
//		return phccm;
//	}
//	@Bean
//	@Scope(value="prototype")
//	public HttpClient httpClient(){
//		HttpClient hc = HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager())
//			.build();
//		
//		return hc;
//	}
//	@Bean(destroyMethod="shutdown")
//	public IdleConnectionEvictor idleConnectionEvictor(){
//		
//		return new IdleConnectionEvictor(poolingHttpClientConnectionManager());
//		
//	}
//	@SuppressWarnings("static-access")
//	@Bean
//	public RequestConfig RequestConfig() throws InstantiationException, IllegalAccessException{
//		RequestConfig requestConfig = 
//				RequestConfig.DEFAULT;
//		Builder b = requestConfig.copy(requestConfig);
//		
//			requestConfig =	b.setConnectTimeout(1000)
//				.setConnectionRequestTimeout(500)
//					.setSocketTimeout(10000).
//					setStaleConnectionCheckEnabled(true).build();
//		return requestConfig;
//	}
}
