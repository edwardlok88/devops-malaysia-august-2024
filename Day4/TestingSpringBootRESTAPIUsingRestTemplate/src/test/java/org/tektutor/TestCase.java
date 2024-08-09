package org.tektutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.List;

import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class TestCase {
	private RestTemplate restTemplate;

	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetEmployeeRestAPI() {
		ResponseEntity<List> response 
			= restTemplate.getForEntity( "http://localhost:8080/employees", List.class );	
		List<Employee> employees = response.getBody();

		System.out.println ( employees );
	}

	@Test
	public void testEmployeeCreateRestAPI() {
		Employee emp = new Employee("Michael Deehan", "CEO");
		ResponseEntity response 
			= restTemplate.postForEntity( "http://localhost:8080/employees", emp, Employee.class );

		System.out.println ( response.getBody() );
	}

	@After
	public void cleanUp() {
		restTemplate = null;
	}
}
