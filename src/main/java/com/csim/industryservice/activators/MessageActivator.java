package com.csim.industryservice.activators;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class MessageActivator {
	@ServiceActivator(inputChannel = "consumingChannel")
	public void upperCase(String input) {
		System.out.println("Read message from JMS queue");
	}
}
