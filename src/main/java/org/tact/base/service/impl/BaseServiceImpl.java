package org.tact.base.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tact.base.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService {

	// https://httpbin.org/get
	@Override
	public <T> T getTest() {
		RestTemplate restTemplate = new RestTemplate();		
		 
		Object result = restTemplate.getForObject("http://localhost:1748/base", Object.class);
		
		System.out.println("result : "+result);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", result);
		
		return (T) map;
	}
	
	// http://reqres.in/api/users/2
	@Override
	public <T> T testRestClientWithSSL() {
		
		CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		 
		Object result = restTemplate.getForObject("http://reqres.in/api/users/2", Object.class);
		
		System.out.println("result : "+result);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", result);
		
		return (T) map;
	}
}


/*
 * ref:
 * 		https://stackoverflow.com/questions/44922261/why-do-i-always-get-403-when-fetching-data-with-resttemplate
 * 		https://stackoverflow.com/questions/44922261/why-do-i-always-get-403-when-fetching-data-with-resttemplate
 * 		https://stackoverflow.com/questions/44922261/why-do-i-always-get-403-when-fetching-data-with-resttemplate
 */

