package com.csim.industryservice.activators;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.csim.industryservice.model.IndustryModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@MessageEndpoint
public class JmsConsumingChannelActivator {
	@ServiceActivator(inputChannel = "jmsConsumingChannel")
	public void upperCase(String input) throws JsonMappingException, JsonProcessingException {
		System.out.println("Read message from JMS queue: " + input);
		ObjectMapper mapper = new ObjectMapper();
		IndustryModel industryModel = mapper.readValue(input, new IndustryModel().getClass());
		System.out.println("Parsed object values: " + industryModel.toString());
	}
}

