package com.candela.iam.usermanagement.services;

import javax.validation.Valid;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candela.iam.usermanagement.request.CreateCustomerRequest;
import com.candela.iam.usermanagement.response.CreateCustomerResponse;

@RestController
public class UserServices {
	private static final Logger logger = LoggerFactory.getLogger(UserServices.class);
 @Autowired
 ProducerTemplate template;
 
 @PostMapping(value="/createUser",headers = "Accept="+ MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public String createUser(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
     logger.debug("createUser: [{}]",createCustomerRequest);
     CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();
     createCustomerResponse.setUserIdResponse(createCustomerRequest.getUserId());
     createCustomerResponse.setChannelIdResponse(createCustomerRequest.getChannelId());
     createCustomerResponse.setDistributorIdResponse(createCustomerRequest.getDistributorId());
     return (String) template.sendBody("direct:createUser", ExchangePattern.InOut,createCustomerResponse);
 }
}
