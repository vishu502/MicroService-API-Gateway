package com.msa.user.controller.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author vishaltyagi
 *
 */
@Data
public class UserDetailResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetailTO UserDetailTo;
}
