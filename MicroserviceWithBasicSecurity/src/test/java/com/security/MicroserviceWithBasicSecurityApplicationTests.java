package com.security;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.security.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * 
 * @author skar
 *
 */
public class MicroserviceWithBasicSecurityApplicationTests {
	
	HttpEntity<String> request = null;
	
	@Before
	/*
	 * We have set the basic credentials in this method. This will be applicable for all the webservice calls.
	 */
	public void init(){
		final String HEADER_NAME_AUTHORIZATION = "Authorization";
		String plainCredtnails = "guest:guest123";
		byte[] encodedCredential = Base64.encode(plainCredtnails.getBytes());
		String authrorizationValue = new String(encodedCredential);
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HEADER_NAME_AUTHORIZATION, "Basic "+authrorizationValue);
		
		request = new HttpEntity<>(httpHeaders);
	}

	@Test
	public void testEmployeeService() {
		
		Assert.notNull(request);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:8080/employee", HttpMethod.GET, request, Employee.class);
		Employee e = responseEntity.getBody();
		Assert.notNull(e);
		assertEquals(e.getId(), 1);
		assertEquals(e.getName(), "Santosh");
	}

}
