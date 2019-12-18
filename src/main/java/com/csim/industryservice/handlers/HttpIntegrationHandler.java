package com.csim.industryservice.handlers;

import org.springframework.stereotype.Component;

import com.csim.industryservice.model.IndustryModel;

@Component
public class HttpIntegrationHandler {

	public void handle(IndustryModel input) {
		System.out.println("Adding object to DB: "+input.toString());
	}
}
