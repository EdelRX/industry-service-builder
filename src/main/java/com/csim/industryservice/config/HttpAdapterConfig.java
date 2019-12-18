package com.csim.industryservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;

import com.csim.industryservice.model.IndustryModel;

@Configuration
public class HttpAdapterConfig {
	
	@Bean
	public DirectChannel httpConsumingChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public HttpRequestHandlingMessagingGateway httpAdapterGateway() {
		HttpRequestHandlingMessagingGateway httpRequestHandlingMessagingGateway = new HttpRequestHandlingMessagingGateway(false);
		RequestMapping requestMapping = new RequestMapping();
		//requestMapping.setPathPatterns("/api/receive/{message}");
		requestMapping.setPathPatterns("/api/receive");
		//requestMapping.setMethods(HttpMethod.GET);
		requestMapping.setMethods(HttpMethod.POST);
		httpRequestHandlingMessagingGateway.setRequestMapping(requestMapping);
		
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		//converters.add(new StringHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
		
		httpRequestHandlingMessagingGateway.setMessageConverters(converters);
		httpRequestHandlingMessagingGateway.setRequestChannelName("httpConsumingChannel");
		
		//Expression payloadExpression = new SpelExpressionParser().parseExpression("#pathVariables.message");
		//httpRequestHandlingMessagingGateway.setPayloadExpression(payloadExpression);
		httpRequestHandlingMessagingGateway.setRequestPayloadTypeClass(new IndustryModel().getClass());
		return httpRequestHandlingMessagingGateway;
	}

}
