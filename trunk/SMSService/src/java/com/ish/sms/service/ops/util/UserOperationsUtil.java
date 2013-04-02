package com.ish.sms.service.ops.util;

import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.UserDetailsDTO;
import com.ish.sms.service.dto.UserRoleDTO;
import com.ish.sms.service.entity.User;

/**
 * Utility class for performing DTO/Entity conversions for User related entities
 * 
 * @author enselv
 *
 */
public class UserOperationsUtil {

	/**
	 * Utility method to convert user entity to user DTO
	 * 
	 * @param user {@link User}
	 * @return userDetailsDTO {@link UserDetailsDTO}
	 * @throws Exception
	 */
	public UserDetailsDTO convertUserEntitytoDTO(User user) throws Exception {

		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		PropertyUtils.copyProperties(userRoleDTO, user.getUserRole());
		PropertyUtils.copyProperties(userDetailsDTO, user);
		userDetailsDTO.setUserRoleDTO(userRoleDTO);
		return userDetailsDTO;

	}
}
