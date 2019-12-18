package com.csim.industryservice.transformers;

import org.springframework.stereotype.Component;

import com.csim.industryservice.model.IndustryModel;

@Component
public class HttpIntegrationTransformer {
	
	public IndustryModel transform(IndustryModel input) {
		IndustryModel industryModelTransformed = new IndustryModel();
		industryModelTransformed.setDescription(input.getDescription()+ "_TRANSFORMED");
		industryModelTransformed.setName(input.getName()+"_TRANSFORMED");
		industryModelTransformed.setType(input.getType()+"_TRANSFORMED");
		industryModelTransformed.setSubType(input.getSubType()+"_TRANSFORMED");
		return industryModelTransformed;
	}
}
