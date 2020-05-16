package com.msa.order.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailTO implements Serializable  {

	

		private static final long serialVersionUID = 1L;
		private Integer orderId;
		private Double orderAmount;
		private String orderDate;
		
}
