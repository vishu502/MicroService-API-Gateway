package com.msa.order.service;



import com.msa.order.controller.dto.OrderDetailTOResponse;
import com.msa.order.controller.dto.UserAndOrderDetailTOResponse;

public interface OrderDetailService {

	public OrderDetailTOResponse getOrderDetailById(Integer userID);
	

	public UserAndOrderDetailTOResponse getUserAndOrderDetails(Integer userId)  ;
}
  