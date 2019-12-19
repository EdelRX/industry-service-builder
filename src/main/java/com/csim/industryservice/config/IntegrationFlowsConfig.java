package com.csim.industryservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import com.csim.industryservice.handlers.JmsIntegrationHandler;
import com.csim.industryservice.transformers.JmsIntegrationTransformer;

@Configuration
public class IntegrationFlowsConfig {
	
	@Autowired
	@Qualifier("jmsConsumingChannel")
	DirectChannel channel;
	
	@Autowired
	JmsIntegrationTransformer jmsIntegrationTransformer;
	
	@Autowired
	JmsIntegrationHandler jmsIntegrationHandler;
	
	@Bean
	public IntegrationFlow httpReader() {
		return IntegrationFlows.from(channel)
				.transform(jmsIntegrationTransformer,"transform")
				.handle(jmsIntegrationHandler, "handle")
				.get();
	}
}
