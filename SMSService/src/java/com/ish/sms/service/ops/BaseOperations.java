package com.ish.sms.service.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dao.ClassAttendanceOperationsDAO;
import com.ish.sms.service.dao.ClassOperationsDAO;
import com.ish.sms.service.dao.ReferenceOperationsDAO;
import com.ish.sms.service.dao.UserOperationsDAO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.Teacher;
import com.ish.sms.service.ops.util.AssociateOperationsUtil;
import com.ish.sms.service.ops.util.ClassAttendanceOperationsUtil;
import com.ish.sms.service.ops.util.ClassOperationsUtil;
import com.ish.sms.service.ops.util.UserOperationsUtil;
import com.ish.sms.service.util.EntityConstants;
import com.ish.sms.service.util.QueryConstants;

public class BaseOperations implements QueryConstants, EntityConstants {

	@Autowired
	protected ReferenceOperationsDAO referenceOperationsDAO;

	@Autowired
	protected AssociateOperationsDAO associateOperationsDAO;

	@Autowired
	protected ClassOperationsDAO classOperationsDAO;

	@Autowired
	protected ClassAttendanceOperationsDAO classAttendanceOperationsDAO;

	@Autowired
	protected UserOperationsDAO userOperationsDAO;

	@Autowired
	protected AssociateOperationsUtil associateOperationsUtil;

	@Autowired
	protected ClassOperationsUtil classOperationsUtil;

	@Autowired
	protected ClassAttendanceOperationsUtil classAttendanceOperationsUtil;
	
	@Autowired
	protected UserOperationsUtil userOperationsUtil;

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public TeacherListDTO retrieveAllTeachers() throws Exception {

		TeacherListDTO teacherListDTO = new TeacherListDTO();
		List<Teacher> teachersList = (List<Teacher>) associateOperationsDAO.retrieveResultsForquery(FIND_ALL_TEACHERS);
		for (Teacher teacher : teachersList) {
			TeacherDTO teacherDTO = associateOperationsUtil.convertTeacherEntityToDTO(teacher);
			teacherListDTO.getTeacherDTOList().add(teacherDTO);
		}
		return teacherListDTO;
	}

	/**
	 * Method to return the list of classes for a specified classid list
	 * 
	 * @param classIdList
	 * @return classList {@link ClassDTO}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ClassListDTO retrieveClassesForIdList(List<Integer> classIdList) throws Exception {

		ClassListDTO classListDTO = new ClassListDTO();
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID_LIST, classIdList);
		List<Class> classList = (List<Class>) classOperationsDAO.retrieveResultListForQueryWithParameters(FIND_ALL_CLASS_FOR_ID_LIST,
				queryParametersMap);
		for (Class classObj : classList) {
			ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
			classListDTO.getClassDTOList().add(classDTO);
		}
		return classListDTO;
	}

}
