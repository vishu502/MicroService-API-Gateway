package com.msa.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msa.user.entity.UserDetailEntity;

/**
 * The Interface BookingManagementRepo.
 */
/**
 * @author vishaltyagi
 *
 */
@Repository
public interface UserManagementRepo extends JpaRepository<UserDetailEntity, Integer> {

	/**
	 * Find by id and user id.
	 *
	 * @param bookingId
	 *            the booking id
	 * @param userId
	 *            the user id
	 * @return the optional
	 */
	public UserDetailEntity findByUserId(Integer userID);

	/**
	 * Find first 3 by user id order by created date desc.
	 *
	 * @param userId
	 *            the user id
	 * @return the optional
	 */

}
