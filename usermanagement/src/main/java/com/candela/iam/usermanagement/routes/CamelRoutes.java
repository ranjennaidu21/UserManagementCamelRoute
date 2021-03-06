package com.candela.iam.usermanagement.routes;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candela.iam.usermanagement.db.entity.User;
import com.candela.iam.usermanagement.db.repository.UserRepository;
import com.candela.iam.usermanagement.request.CreateCustomerRequest;
import com.candela.iam.usermanagement.response.CreateCustomerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CamelRoutes extends RouteBuilder {
	
 private final ObjectMapper objectMapper = new ObjectMapper();
	
 @Autowired
 UserRepository userRepository;
 
 @Override
 public void configure() throws Exception {
  
	  from("direct:createUser")
	  .routeId("createUser")
	  .to("log:INFO?showBody=true&showHeaders=true")
      .process(new Processor() {
          @Override
          public void process(Exchange exchange) throws Exception {
              final CreateCustomerResponse createCustomerResponse = (CreateCustomerResponse) exchange.getIn().getBody();
              User user = new User();
              user.setUserId(createCustomerResponse.getUserIdResponse());
              user.setChannelId(createCustomerResponse.getChannelIdResponse());
              user.setDistributorId(createCustomerResponse.getDistributorIdResponse());
              user.setRoles("Test");
              userRepository.save(user);
              
              exchange.getIn().setBody(objectMapper.writeValueAsString(createCustomerResponse));
          }
      })
      .log("Camel body: ${body}")
	  .convertBodyTo(String.class)
      .end();
	  //.log("Camel body: ${body}");
 }
}