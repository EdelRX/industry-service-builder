package com.csim.industryservice.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsAdapterConfig {

	@Value("test-queue")
	private String integrationDestination;
	
	@Bean
	public DirectChannel jmsConsumingChannel() {
		return new DirectChannel();
	}

	@Bean
	public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint(ConnectionFactory connectionFactory) {
		JmsMessageDrivenEndpoint endpoint = new JmsMessageDrivenEndpoint(
				simpleMessageListenerContainer(connectionFactory), channelPublishingJmsMessageListener());
		endpoint.setOutputChannel(jmsConsumingChannel());

		return endpoint;
	}

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName(integrationDestination);
		return container;
	}

	@Bean
	public ChannelPublishingJmsMessageListener channelPublishingJmsMessageListener() {
		ChannelPublishingJmsMessageListener listener = new ChannelPublishingJmsMessageListener();
		return listener;
	}
}
