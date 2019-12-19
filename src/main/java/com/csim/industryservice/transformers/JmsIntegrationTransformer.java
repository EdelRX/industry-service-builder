package com.csim.industryservice.transformers;

import org.springframework.stereotype.Component;

import com.csim.industryservice.model.IndustryModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JmsIntegrationTransformer {
	
	public IndustryModel transform(String input) throws JsonMappingException, JsonProcessingException {
		System.out.println("Read message from JMS queue: " + input);
		ObjectMapper mapper = new ObjectMapper();
		IndustryModel industryModel = mapper.readValue(input, new IndustryModel().getClass());
		System.out.println("Parsed object values: " + industryModel.toString());
		return industryModel;
	}

}
