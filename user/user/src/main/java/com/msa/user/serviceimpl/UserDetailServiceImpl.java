package com.msa.user.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msa.user.controller.dto.UserDetailResponseTO;
import com.msa.user.controller.dto.UserDetailTO;
import com.msa.user.entity.UserDetailEntity;
import com.msa.user.exception.RecordNotFoundException;
import com.msa.user.repo.UserManagementRepo;
import com.msa.user.service.UserDetailService;

/**
 * @author vishaltyagi
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	@Autowired
	private UserManagementRepo userManagementRepo;

	@Override
	public UserDetailResponseTO getUserDetailById(Integer userID) throws Exception {
		UserDetailTO userDetailTO = new UserDetailTO();
		UserDetailResponseTO userDetailResponseTO = new UserDetailResponseTO();

		UserDetailEntity userDetailEntity = userManagementRepo.findByUserId(userID);
		try {
			if ((userDetailEntity == null)) {
				throw new RecordNotFoundException("Error in retrieving the data", UserDetailServiceImpl.class.getName(),
						userID.toString());
			}
			userDetailTO.setUserName(userDetailEntity.getName());
			userDetailTO.setEmail(userDetailEntity.getEmailId());
			userDetailTO.setAge(userDetailEntity.getAge());
			userDetailResponseTO.setUserDetailTo(userDetailTO);

			return userDetailResponseTO;
		} catch (Exception e) {
			LOGGER.error("Exception while fecthing value from DB {}", e);
			throw new RuntimeException("Error"+e);

		}

	}
}
