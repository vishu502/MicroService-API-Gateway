package com.msa.user.controller.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author vishaltyagi
 *
 */
@Data
public class UserDetailTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String userName;
	private String age;
	private String email;

	@Override
	public String toString() {
		return "UserDetailTO [userName=" + userName + ", age=" + age + ", email=" + email + "]";
	}

}
