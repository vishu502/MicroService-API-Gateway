package com.msa.order.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndOrderDetailTOResponse {

	private UserDetailTO userDetails;
	private List<OrderDetailTO> orders;
}
