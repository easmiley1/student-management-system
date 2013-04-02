package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.UserDetailsDTO;
import com.ish.sms.service.entity.User;

/**
 * Class to handle all business logic for class related database operations
 * 
 * @author Naren
 * 
 */
public class UserOperations extends BaseOperations {

	/**
	 * Method to return the user for a specific userName
	 * 
	 * @param userName
	 * @return userDetailsDTO {@link UserDetailsDTO}
	 */
	@Transactional(readOnly = true)
	public UserDetailsDTO retrieveUser(String name) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(NAME, name);
		User user = (User) userOperationsDAO.retrieveSingleResultForQueryWithParameters(FIND_USER_FOR_NAME, User.class, queryParametersMap);
		UserDetailsDTO userDetailsDTO = userOperationsUtil.convertUserEntitytoDTO(user);
		if (user.getUserRole().getRoleName().equals(ROLE_NAME.TEACHER_ROLE.name())) {

			String[] classIdArray = user.getAssociateAccess().split(SEMI_COLON);
			List<Integer> classIdList = new ArrayList<Integer>();
			for (String classStr : classIdArray) {
				classIdList.add(new Integer(classStr));
			}
			ClassListDTO classListDTO = retrieveClassesForIdList(classIdList);
			userDetailsDTO.setClassListDTO(classListDTO);
		}

		return userDetailsDTO;
	}

}
