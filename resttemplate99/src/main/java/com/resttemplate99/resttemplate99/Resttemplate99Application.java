package com.resttemplate99.resttemplate99;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
//import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

/*
 * This project invokes REST APIS exposed by spring-boot-rest-mysql(hence import this project as well)
 */

@SpringBootApplication
public class Resttemplate99Application {

	public static void main(String[] args) {
		SpringApplication.run(Resttemplate99Application.class, args);
	}
}

@RestController
class Sample {
	@GetMapping("/rstget1")
	public String met1() {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:1350/api/customers";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		System.out.println("Status code: " + result.getStatusCodeValue());
		System.out.println("result: " + result.getBody());

		return "Status code: " + result.getStatusCodeValue() + "<br>result: " + result.getBody();
	}

	@GetMapping("/rstget2")
	public String postCheck() {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:1350/api/customers/create";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Customer cust = new Customer(966, "cust99999999999999", 299);

		ResponseEntity<Customer> result = restTemplate.postForEntity(uri, cust, Customer.class);
		Customer obj = restTemplate.postForObject(uri, cust, Customer.class);

		System.out.println("Status Code: " + result.getStatusCodeValue() + result);

		return "Status Code: " + result.getStatusCodeValue() + result;
	}

	@PutMapping("/customers/{id}")
	public String updateProduct(@PathVariable("id") String id, @RequestBody Customer cust) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);

		ResponseEntity<Customer> rcustomer = restTemplate.exchange("http://localhost:1350/api/customers/" + id,
				HttpMethod.PUT, entity, Customer.class);
		return rcustomer.toString();
	}
	
	
	
	 @DeleteMapping("/deletecustomer/{id}")
	 public String deleteProduct(@PathVariable("id") String id, @RequestBody Customer cust) {
		 RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);

			ResponseEntity<Customer> rcustomer = restTemplate.exchange("http://localhost:1350/api/deletecustomer/" + id,
					HttpMethod.DELETE, entity, Customer.class);
			return rcustomer.toString();
	 
	 }
	

}
