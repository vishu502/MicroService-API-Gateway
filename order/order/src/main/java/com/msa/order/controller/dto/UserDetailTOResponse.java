package com.msa.order.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailTOResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetailTO userDetailTO;
}
