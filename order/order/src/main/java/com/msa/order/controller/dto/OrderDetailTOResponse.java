package com.msa.order.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailTOResponse {



	private List<OrderDetailTO> orderDetailTo;
}
