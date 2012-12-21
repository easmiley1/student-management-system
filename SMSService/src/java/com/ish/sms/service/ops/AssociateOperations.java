package com.ish.sms.service.ops;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.entity.Student;

public class AssociateOperations extends EntityOperations{

	@Autowired
	private AssociateOperationsDAO associateOperationsDAO;
	
	@Transactional
	public StudentDTO createOrUpdateStudent(StudentDTO studentDTO) throws Exception{
		Student student = new Student();
		BeanUtils.copyProperties(student, studentDTO);
		student = associateOperationsDAO.createOrUpdateStudent(student);
		BeanUtils.copyProperties(studentDTO, student);
		return studentDTO;
	}
}
