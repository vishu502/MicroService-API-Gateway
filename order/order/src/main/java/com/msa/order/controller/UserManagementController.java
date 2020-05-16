package com.msa.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.msa.order.controller.dto.OrderDetailTOResponse;
import com.msa.order.controller.dto.ResponseTO;
import com.msa.order.controller.dto.UserAndOrderDetailTOResponse;
import com.msa.order.service.OrderDetailService;
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.discovery.EurekaClient;

import lombok.Data;

@RestController
@RequestMapping(value = "order-api")
@Data
public class UserManagementController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping(value = "/orders/{user-id}")
	public ResponseTO<OrderDetailTOResponse> geOrderDetails(
			@PathVariable(name = "user-id") Integer userId){
		LOGGER.info("Method getUserAndOrderDetail start for userID {}", userId);
		ResponseTO<OrderDetailTOResponse> response = new ResponseTO<>();
		response.setData(orderDetailService.getOrderDetailById(userId));
		return response;
	}

	@GetMapping(value = "/orderdetails/{user-id}")
	public ResponseTO<UserAndOrderDetailTOResponse> getUserAndOrderDetails(
			@PathVariable(name = "user-id") Integer userId){
		LOGGER.info("Method getUserAndOrderDetail start for userID {}", userId);
		ResponseTO<UserAndOrderDetailTOResponse> response = new ResponseTO<>();
		response.setData(orderDetailService.getUserAndOrderDetails(userId));
		return response;
	}
}
