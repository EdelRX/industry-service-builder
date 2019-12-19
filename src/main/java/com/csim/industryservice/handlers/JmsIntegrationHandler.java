package com.csim.industryservice.handlers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.csim.industryservice.model.IndustryModel;

@Component
public class JmsIntegrationHandler {
	
	RestTemplate restTemplate = new RestTemplate();

	public void handle(IndustryModel input) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8033/api/receive", 
	    		input, String.class);
	    
	    if (response.getStatusCode() == HttpStatus.OK) {
	        System.out.println("Sent HTTP request to admin");
	    } else {
	    	System.out.println("Failed sending HTTP request to admin");
	    }
	}
}
