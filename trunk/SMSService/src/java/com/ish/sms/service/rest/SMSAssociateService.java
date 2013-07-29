package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.StringListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;

/**
 * Restful service class to handle all Associate related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsAssociateService")
public class SMSAssociateService extends SMSBaseService{

	/**
	 * Method to create or update a student and return the persisted studentXML.
	 * 
	 * @param studentXml
	 * @return studentXML
	 */
	@POST
	@Path("/saveStudent/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String saveStudent(String xml) {

		StudentDTO studentDTO = null;
		String studentXML = null;
		try {
			studentDTO = serviceTransformer.tryParseXml(xml);
			studentDTO = associateOperations.createOrUpdateStudent(studentDTO);
			studentXML = serviceTransformer.transformToXML(studentDTO, "studentDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentXML;
	}

	/**
	 * Method to create or update a teacher and return the persisted teacherXML.
	 * 
	 * @param teacherXml
	 * @return teacherXml
	 */
	@POST
	@Path("/saveTeacher/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String saveTeacher(String xml) {

		TeacherDTO teacherDTO = null;
		String teacherXml = null;
		try {
			teacherDTO = serviceTransformer.tryParseXml(xml);
			teacherDTO = associateOperations.createOrUpdateTeacher(teacherDTO);
			teacherXml = serviceTransformer.transformToXML(teacherDTO, "teacherDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherXml;
	}	
	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllStudents/")
	@Produces(MediaType.TEXT_XML)
	public String retrieveAllStudents() {

		String studentListXML = null;
		try {
			StudentListDTO studentList = associateOperations.retrieveAllStudents();
			studentListXML = serviceTransformer.transformToXML(studentList, "studentListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentListXML;
	}
	
	/**
	 * Method to return the student details for the given id.
	 * 
	 * @return studentDTOXML
	 */
	@POST
	@Path("/retrieveStudentDetails/{studentId}")
	@Produces(MediaType.TEXT_XML)
	public String retrieveStudentDetails(@PathParam("studentId") Integer studentId) {

		String studentDTOXML = null;
		try {
			StudentDTO studentDTO = associateOperations.retrieveStudentDetails(studentId);
			studentDTOXML = serviceTransformer.transformToXML(studentDTO, "studentDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDTOXML;
	}

	/**
	 * Method to return the list of all the students for the given classIds.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveStudentsForClass/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String retrieveStudentsForClass(String classIdXML) {

		String studentListXML = null;
		try {
			StringListDTO stringListDTO = serviceTransformer.tryParseXml(classIdXML);
			StudentListDTO studentList = associateOperations.retrieveStudentsForClass(stringListDTO.getStringListDTO());
			studentListXML = serviceTransformer.transformToXML(studentList, "studentListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentListXML;
	}

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherListXML
	 */
	@POST
	@Path("/retrieveAllTeachers/")
	@Produces(MediaType.TEXT_XML)
	public String retrieveAllTeachers() {

		String teacherListXML = null;
		try {
			TeacherListDTO teacherListDTO = associateOperations.retrieveAllTeachers();
			teacherListXML = serviceTransformer.transformToXML(teacherListDTO, "teacherListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherListXML;
	}
	
}
