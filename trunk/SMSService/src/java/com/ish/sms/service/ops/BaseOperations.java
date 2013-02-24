package com.ish.sms.service.ops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dao.ClassAttendanceOperationsDAO;
import com.ish.sms.service.dao.ClassOperationsDAO;
import com.ish.sms.service.dao.ReferenceOperationsDAO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.Teacher;
import com.ish.sms.service.ops.util.AssociateOperationsUtil;
import com.ish.sms.service.ops.util.ClassOperationsUtil;
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
	protected AssociateOperationsUtil associateOperationsUtil;

	@Autowired
	protected ClassOperationsUtil classOperationsUtil;

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

}

