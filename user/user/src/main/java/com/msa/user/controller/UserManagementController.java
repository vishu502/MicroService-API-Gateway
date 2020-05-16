package com.msa.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.user.controller.dto.ResponseTO;
import com.msa.user.controller.dto.UserDetailResponseTO;
import com.msa.user.service.UserDetailService;

/**
 * @author vishaltyagi
 *
 */
@RestController
@RequestMapping(value = "user-api")
public class UserManagementController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	UserDetailService userDetailService;

	@GetMapping(value = "/home")
	public ResponseEntity<String> home() {
		LOGGER.info("Home method for health check of MS");
		return new ResponseEntity<>("Welcome User Management", HttpStatus.OK);
	}

	/**
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value = "user/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO<UserDetailResponseTO>> getUserDetail(
			@PathVariable(name = "user-id") Integer userId) throws Exception {
		LOGGER.info("Method getUserDetail start for userID {}", userId);

		ResponseTO<UserDetailResponseTO> responseTO = new ResponseTO<>();
		UserDetailResponseTO bookingStatusResponseTO = userDetailService.getUserDetailById(userId);
		responseTO.setData(bookingStatusResponseTO);
		LOGGER.info("Method getUserDetail end {}", bookingStatusResponseTO.getUserDetailTo());
		return new ResponseEntity<>(responseTO, HttpStatus.OK);
	}

}
