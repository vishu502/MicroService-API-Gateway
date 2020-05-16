package com.msa.user.service;

import com.msa.user.controller.dto.UserDetailResponseTO;

/**
 * @author vishaltyagi
 *
 */
public interface UserDetailService {

	public UserDetailResponseTO getUserDetailById(Integer userID) throws Exception;
}
