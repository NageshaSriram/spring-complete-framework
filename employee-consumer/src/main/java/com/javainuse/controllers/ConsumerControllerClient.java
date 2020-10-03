/**
 * 
 */
package com.javainuse.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.javainuse.model.Employee;
import com.javainuse.services.RemoteCallService;

/**
 * @author nageshasriramappa
 *
 */
public class ConsumerControllerClient {
	
	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */
	
//	@Autowired
//	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RemoteCallService loadBalancer;
	
	public void getEmployee() throws RestClientException, IOException {

//		List<ServiceInstance> instances=discoveryClient.getInstances("employee-producer");
//		ServiceInstance serviceInstance=instances.get(0);
//		
//		String baseUrl=serviceInstance.getUri().toString();
		
		/*
		 * ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");
		 * 
		 * System.out.println(serviceInstance.getUri());
		 * 
		 * String baseUrl=serviceInstance.getUri().toString();
		 * 
		 * baseUrl=baseUrl+"/employee";
		 * 
		 * //String baseUrl = "http://localhost:8080/employee"; RestTemplate
		 * restTemplate = new RestTemplate(); ResponseEntity<String> response = null;
		 * try { response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(),
		 * String.class); } catch (Exception ex) { System.out.println(ex); }
		 * System.out.println(response.getBody());
		 */
		
		Employee emp = loadBalancer.getData();
		System.out.println(emp.getEmpId());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
