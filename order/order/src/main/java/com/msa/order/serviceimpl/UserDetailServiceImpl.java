package com.msa.order.serviceimpl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.order.controller.dto.OrderDetailTO;
import com.msa.order.controller.dto.OrderDetailTOResponse;
import com.msa.order.controller.dto.ResponseTO;
import com.msa.order.controller.dto.UserAndOrderDetailTOResponse;
import com.msa.order.controller.dto.UserDetailResponseTO;
import com.msa.order.controller.dto.UserDetailTO;
import com.msa.order.service.OrderDetailService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class UserDetailServiceImpl implements OrderDetailService {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public OrderDetailTOResponse getOrderDetailById(Integer orderNumber) {

		List<OrderDetailTO> orderList = new ArrayList<OrderDetailTO>();
		orderList.add(new OrderDetailTO(1, 250.0, "14-Apr-2020"));
		orderList.add(new OrderDetailTO(2, 450.0, "15-Apr-2020"));
		OrderDetailTOResponse userDetailResponseTO = new OrderDetailTOResponse(orderList);

		return userDetailResponseTO;

	}

	public static List<OrderDetailTO> getListOfProducts() {

		List<OrderDetailTO> orderList = new ArrayList<OrderDetailTO>();
		orderList.add(new OrderDetailTO(1, 250.0, "14-Apr-2020"));
		orderList.add(new OrderDetailTO(2, 450.0, "15-Apr-2020"));

		return orderList;

	}

	@Override
	public UserAndOrderDetailTOResponse getUserAndOrderDetails(Integer userId) {
		return new UserAndOrderDetailTOResponse(getUserById(userId), getListOfProducts());
	}

	private UserDetailTO getUserById(Integer userId) {
		URI uri = URI.create("user-api/user/" + userId);
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("user", false);
		ResponseEntity<ResponseTO<UserDetailResponseTO>> exchange = restTemplate.exchange(
				instance.getHomePageUrl() + uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<ResponseTO<UserDetailResponseTO>>() {
				});

		return exchange.getBody().getData().getUserDetailTo();
	}
}