package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ClassStudentDTO;
import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ClassTimeTableListDTO;
import com.ish.sms.service.dto.GradeDetailsDTO;
import com.ish.sms.service.dto.GradeDetailsMap;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.ReportCardDTO;
import com.ish.sms.service.dto.ReportCardDetailsDTO;
import com.ish.sms.service.dto.ReportCardDetailsMap;
import com.ish.sms.service.dto.ReportCardListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassExamReferenceData;
import com.ish.sms.service.entity.ClassStudent;
import com.ish.sms.service.entity.ClassSubjectReferenceData;
import com.ish.sms.service.entity.ClassTimeTable;
import com.ish.sms.service.entity.ReferenceData;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.StudentGrade;
import com.ish.sms.service.entity.Teacher;

/**
 * Utility class for performing DTO/Entity conversions for Class related entities
 * 
 * @author enselv
 * 
 */
public class ClassOperationsUtil extends BaseCommonOperationsUtil {
	/**
	 * Utility method to convert the class JPA entity to classDTO object
	 * 
	 * @param classObj
	 * @return classDTO
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 */
	public ClassDTO convertClassEntityToDTO(Class classObj) throws Exception {
		ClassDTO classDTO = new ClassDTO();
		PropertyUtils.copyProperties(classDTO, classObj);
		TeacherDTO teacherDTO = null;
		if (classObj.getTeacher() != null)
			teacherDTO = convertTeacherEntityToDTO(classObj.getTeacher());
		Collection<ClassTimeTable> classTimeTables = classObj.getClassTimeTable();
		if (classTimeTables != null && classTimeTables.size() > 0) {
			List<ClassTimeTableDTO> classTimeTableDTOList = convertClassTimeTableListEntitytoDTO(classTimeTables).getClassTimeTableDTOList();
			classDTO.setClassTimeTableDTOList(classTimeTableDTOList);
		}
		Collection<ClassSubjectReferenceData> classSubjectReferenceDataList = classObj.getClassSubjectReferenceData();
		if (classSubjectReferenceDataList != null && classSubjectReferenceDataList.size() > 0) {
			List<ClassSubjectReferenceDataDTO> classSubjectClassReferenceDataDTOList = convertClassSubjectReferenceDataEntityToDTO(classSubjectReferenceDataList);
			classDTO.setClassSubjectReferenceDataDTOList(classSubjectClassReferenceDataDTOList);
		}
		Collection<ClassExamReferenceData> classExamReferenceDataList = classObj.getClassExamReferenceData();
		if (classExamReferenceDataList != null && classExamReferenceDataList.size() > 0) {
			List<ClassExamReferenceDataDTO> classExamClassReferenceDataDTOList = convertClassExamReferenceDataEntityToDTO(classExamReferenceDataList);
			classDTO.setClassExamReferenceDataDTOList(classExamClassReferenceDataDTOList);
		}
		classDTO.setTeacherDTO(teacherDTO);
		return classDTO;
	}

	/**
	 * Utility method to convert the class JPA entity to classDTO object
	 * 
	 * @param classDTO
	 * @return classObj
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Class convertClassDTOToEntity(ClassDTO classDTO) throws Exception {
		Class classObj = new Class();
		PropertyUtils.copyProperties(classObj, classDTO);
		Teacher teacher = null;
		if (classDTO.getTeacherDTO() != null)
			teacher = convertTeacherDTOToEntity(classDTO.getTeacherDTO());
		classObj.setTeacher(teacher);
		List<ClassTimeTableDTO> classTimeTableDTOList = classDTO.getClassTimeTableDTOList();
		List<ClassTimeTable> classTimeTableList = null;
		if (classTimeTableDTOList != null && classTimeTableDTOList.size() > 0) {
			classTimeTableList = convertClassTimeTableListDTOToEntity(classDTO.getClassTimeTableDTOList(), classObj);
		}
		List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = classDTO.getClassExamReferenceDataDTOList();
		List<ClassExamReferenceData> classExamReferenceDataList = null;
		if (classExamReferenceDataDTOList != null && classExamReferenceDataDTOList.size() > 0) {
			classExamReferenceDataList = convertClassExamReferenceDataDTOtoEntity(classExamReferenceDataDTOList, classObj);
		}
		List<ClassSubjectReferenceDataDTO> classSubjectReferenceDataDTOList = classDTO.getClassSubjectReferenceDataDTOList();
		List<ClassSubjectReferenceData> classSubjectReferenceDataList = null;
		if (classSubjectReferenceDataDTOList != null && classSubjectReferenceDataDTOList.size() > 0) {
			classSubjectReferenceDataList = convertClassSubjectReferenceDataDTOtoEntity(classSubjectReferenceDataDTOList, classObj);
		}

		classObj.setClassExamReferenceData(classExamReferenceDataList);
		classObj.setClassSubjectReferenceData(classSubjectReferenceDataList);
		classObj.setClassTimeTable(classTimeTableList);

		return classObj;
	}

	/**
	 * Utility method to convert classTimetablelist entity to DTO
	 * 
	 * @param classTimeTableListDTO
	 *            {@link ClassTimeTableListDTO}
	 * @return classTimeTable
	 * @throws Exception
	 */
	public ClassTimeTableListDTO convertClassTimeTableListEntitytoDTO(Collection<ClassTimeTable> classTimeTableList) throws Exception {

		ClassTimeTableListDTO classTimeTableListDTO = new ClassTimeTableListDTO();
		for (ClassTimeTable classTimeTable : classTimeTableList) {

			ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
			ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = convertClassSubjectReferenceDataEntitytoDTO(classTimeTable
					.getClassSubjectReferenceData());
			classTimeTableDTO.setClassSubjectReferenceDataDTO(classSubjectReferenceDataDTO);
			ReferenceDataDTO dayOfWeekDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(dayOfWeekDTO, classTimeTable.getDayofWeek());
			classTimeTableDTO.setDayOfWeekDTO(dayOfWeekDTO);
			PropertyUtils.copyProperties(classTimeTableDTO, classTimeTable);
			classTimeTableListDTO.getClassTimeTableDTOList().add(classTimeTableDTO);
		}
		return classTimeTableListDTO;
	}

	/**
	 * Utility method to convert ClassTimeTablelist DTO to entity
	 * 
	 * @param classTimeTableDTOList
	 * @param classObj
	 * @return classTimeTableList
	 * @throws Exception
	 */
	public List<ClassTimeTable> convertClassTimeTableListDTOToEntity(List<ClassTimeTableDTO> classTimeTableDTOList, Class classObj) throws Exception {

		List<ClassTimeTable> classTimeTableList = new ArrayList<ClassTimeTable>();

		for (ClassTimeTableDTO classTimeTableDTO : classTimeTableDTOList) {

			ClassTimeTable classTimeTable = new ClassTimeTable();
			classTimeTable.setClassRef(classObj);
			ClassSubjectReferenceData classSubjectReferenceData = convertClassSubjectReferenceDataDTOtoEntity(classObj,
					classTimeTableDTO.getClassSubjectReferenceDataDTO());
			classTimeTable.setClassSubjectReferenceData(classSubjectReferenceData);
			ReferenceData dayOfWeek = new ReferenceData();
			PropertyUtils.copyProperties(dayOfWeek, classTimeTableDTO.getDayOfWeekDTO());
			classTimeTable.setDayofWeek(dayOfWeek);
			PropertyUtils.copyProperties(classTimeTable, classTimeTableDTO);
			if (classTimeTable.getId() != null && classTimeTable.getId().equals(0)) {
				classTimeTable.setId(null);
			}
			classTimeTableList.add(classTimeTable);
		}
		return classTimeTableList;
	}

	/**
	 * Utility method to convert classExamReferenceDataDTOList to Entity List
	 * 
	 * @param classExamReferenceDataDTOList
	 * @param classObj
	 * @return classExamReferenceDataList
	 * @throws Exception
	 */
	public List<ClassExamReferenceData> convertClassExamReferenceDataDTOtoEntity(List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList, Class classObj)
			throws Exception {

		List<ClassExamReferenceData> classExamReferenceDataList = new ArrayList<ClassExamReferenceData>();

		for (ClassExamReferenceDataDTO classExamReferenceDataDTO : classExamReferenceDataDTOList) {
			ClassExamReferenceData classExamReferenceData = convertClassExamReferenceDataDTOtoEntity(classObj, classExamReferenceDataDTO);
			classExamReferenceDataList.add(classExamReferenceData);
		}
		return classExamReferenceDataList;
	}

	/**
	 * Utility method to convert ClassExamReferenceDataDTO to Entity
	 * 
	 * @param classObj
	 * @param classExamReferenceDataDTO
	 * @return ClassExamReferenceData
	 * @throws Exception
	 */
	public ClassExamReferenceData convertClassExamReferenceDataDTOtoEntity(Class classObj, ClassExamReferenceDataDTO classExamReferenceDataDTO)
			throws Exception {
		ClassExamReferenceData classExamReferenceData = new ClassExamReferenceData();
		classExamReferenceData.setClassRef(classObj);
		classExamReferenceData.setId(classExamReferenceDataDTO.getId());
		ReferenceData examReferenceData = new ReferenceData();
		PropertyUtils.copyProperties(examReferenceData, classExamReferenceDataDTO.getReferenceDataDTO());
		classExamReferenceData.setExamReferenceData(examReferenceData);
		return classExamReferenceData;
	}

	/**
	 * Utility method to convert classSubjectReferenceDataDTOList to Entity List
	 * 
	 * @param classSubjectReferenceDataDTOList
	 * @param classObj
	 * @return classSubjectReferenceDataList
	 * @throws Exception
	 */
	public List<ClassSubjectReferenceData> convertClassSubjectReferenceDataDTOtoEntity(List<ClassSubjectReferenceDataDTO> classSubjectReferenceDataDTOList,
			Class classObj) throws Exception {

		List<ClassSubjectReferenceData> classSubjectReferenceDataList = new ArrayList<ClassSubjectReferenceData>();

		for (ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO : classSubjectReferenceDataDTOList) {
			ClassSubjectReferenceData classSubjectReferenceData = convertClassSubjectReferenceDataDTOtoEntity(classObj, classSubjectReferenceDataDTO);
			classSubjectReferenceDataList.add(classSubjectReferenceData);
		}
		return classSubjectReferenceDataList;
	}

	/**
	 * @param classObj
	 * @param classSubjectReferenceDataDTO
	 * @return ClassSubjectReferenceData
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public ClassSubjectReferenceData convertClassSubjectReferenceDataDTOtoEntity(Class classObj, ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO)
			throws Exception {

		ClassSubjectReferenceData classSubjectReferenceData = new ClassSubjectReferenceData();
		classSubjectReferenceData.setClassRef(classObj);
		Teacher teacher = convertTeacherDTOToEntity(classSubjectReferenceDataDTO.getTeacherDTO());
		ReferenceData subjectReferenceData = new ReferenceData();
		PropertyUtils.copyProperties(subjectReferenceData, classSubjectReferenceDataDTO.getReferenceDataDTO());
		classSubjectReferenceData.setSubjectReferenceData(subjectReferenceData);
		classSubjectReferenceData.setId(classSubjectReferenceDataDTO.getId());
		classSubjectReferenceData.setTeacherRef(teacher);
		return classSubjectReferenceData;
	}

	/**
	 * Utility method to convert classSubjectReferenceDataEntity List to DTO List
	 * 
	 * @param classSubjectReferenceDataList
	 * @param classObj
	 * @return classReferenceDataDTOList
	 * @throws Exception
	 */
	public List<ClassSubjectReferenceDataDTO> convertClassSubjectReferenceDataEntityToDTO(Collection<ClassSubjectReferenceData> classSubjectReferenceDataList)
			throws Exception {

		List<ClassSubjectReferenceDataDTO> classReferenceDataDTOList = new ArrayList<ClassSubjectReferenceDataDTO>();

		for (ClassSubjectReferenceData classSubjectReferenceData : classSubjectReferenceDataList) {
			ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = convertClassSubjectReferenceDataEntitytoDTO(classSubjectReferenceData);
			classReferenceDataDTOList.add(classSubjectReferenceDataDTO);
		}
		return classReferenceDataDTOList;
	}

	/**
	 * Utility method to convert class subject reference data Entity to DTO
	 * 
	 * @param classSubjectReferenceData
	 * @return ClassSubjectReferenceDataDTO
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws Exception
	 */
	private ClassSubjectReferenceDataDTO convertClassSubjectReferenceDataEntitytoDTO(ClassSubjectReferenceData classSubjectReferenceData) throws Exception {
		ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = new ClassSubjectReferenceDataDTO();
		ReferenceDataDTO subjectReferenceDataDTO = new ReferenceDataDTO();
		PropertyUtils.copyProperties(subjectReferenceDataDTO, classSubjectReferenceData.getSubjectReferenceData());
		TeacherDTO teacherDTO = convertTeacherEntityToDTO(classSubjectReferenceData.getTeacherRef());
		classSubjectReferenceDataDTO.setTeacherDTO(teacherDTO);
		classSubjectReferenceDataDTO.setReferenceDataDTO(subjectReferenceDataDTO);
		classSubjectReferenceDataDTO.setId(classSubjectReferenceData.getId());
		return classSubjectReferenceDataDTO;
	}

	/**
	 * Utility method to convert classExamReferenceDataEntity List to DTO List
	 * 
	 * @param classExamReferenceDataList
	 * @param classObj
	 * @return classReferenceDataDTOList
	 * @throws Exception
	 */
	public List<ClassExamReferenceDataDTO> convertClassExamReferenceDataEntityToDTO(Collection<ClassExamReferenceData> classExamReferenceDataList)
			throws Exception {

		List<ClassExamReferenceDataDTO> classReferenceDataDTOList = new ArrayList<ClassExamReferenceDataDTO>();

		for (ClassExamReferenceData classExamReferenceData : classExamReferenceDataList) {
			ClassExamReferenceDataDTO classExamReferenceDataDTO = convertClassExamReferenceDataEntitytoDTO(classExamReferenceData);
			classReferenceDataDTOList.add(classExamReferenceDataDTO);
		}
		return classReferenceDataDTOList;
	}

	/**
	 * Utility method to convert class exam reference data Entity to DTO
	 * 
	 * @param classExamReferenceData
	 * @return classExamReferenceDataDTO
	 * @throws Exception
	 */
	private ClassExamReferenceDataDTO convertClassExamReferenceDataEntitytoDTO(ClassExamReferenceData classExamReferenceData) throws Exception {
		ClassExamReferenceDataDTO classExamReferenceDataDTO = new ClassExamReferenceDataDTO();
		ReferenceDataDTO examReferenceDataDTO = new ReferenceDataDTO();
		PropertyUtils.copyProperties(examReferenceDataDTO, classExamReferenceData.getExamReferenceData());
		classExamReferenceDataDTO.setReferenceDataDTO(examReferenceDataDTO);
		classExamReferenceDataDTO.setId(classExamReferenceData.getId());
		return classExamReferenceDataDTO;
	}

	/**
	 * Method to convert to studentGradeList to ClassGradeDetailsDTO
	 * 
	 * @param studentGradeList
	 * @return studentGradeListDTO
	 */
	public StudentGradeListDTO convertStudentGradeListtoDTO(List<StudentGrade> studentGradeList) throws Exception {

		StudentGradeListDTO studentGradeListDTO = new StudentGradeListDTO();

		for (StudentGrade studentGrade : studentGradeList) {

			StudentDTO studentDTO = convertStudentEntitytoDTO(studentGrade.getStudent());
			StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
			studentGradeDTO.setStudentDTO(studentDTO);
			int index = studentGradeListDTO.getStudentGradeDTOList().indexOf(studentGradeDTO);
			if (index == -1) {
				populateGradeDetailsDTO(studentGradeDTO, studentGrade);
				studentGradeListDTO.getStudentGradeDTOList().add(studentGradeDTO);
			} else {
				studentGradeDTO = studentGradeListDTO.getStudentGradeDTOList().get(index);
				populateGradeDetailsDTO(studentGradeDTO, studentGrade);
			}
		}

		return studentGradeListDTO;
	}

	/**
	 * Method to convert the studentGradeList entity to reportcardDTO
	 * 
	 * @param studentGradeList
	 * @return reportCardListDTO
	 * @throws Exception
	 */
	public ReportCardListDTO convertStudentGradeListTODTO(List<StudentGrade> studentGradeList) throws Exception {

		ReportCardListDTO reportCardListDTO = new ReportCardListDTO();

		for (StudentGrade studentGrade : studentGradeList) {

			ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = convertClassSubjectReferenceDataEntitytoDTO(studentGrade.getClassSubjectReferenceData());
			ClassExamReferenceDataDTO classExamReferenceDataDTO = convertClassExamReferenceDataEntitytoDTO(studentGrade.getClassExamReferenceData());

			ReportCardDTO reportCardDTO = new ReportCardDTO();
			reportCardDTO.setClassSubjectReferenceDataDTO(classSubjectReferenceDataDTO);
			ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> reportCardDetailsMap = new ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO>();
			ReportCardDetailsDTO reportCardDetailsDTO = new ReportCardDetailsDTO();
			reportCardDetailsDTO.setGrade(studentGrade.getGrade());
			reportCardDetailsDTO.setMark(studentGrade.getMark());
			reportCardDetailsMap.put(classExamReferenceDataDTO, reportCardDetailsDTO);
			reportCardDTO.setReportCardDetailsMap(reportCardDetailsMap);
			reportCardListDTO.getReportCardDTOList().add(reportCardDTO);
		}

		return reportCardListDTO;
	}

	/**
	 * @param {@link StudentGradeDTO}
	 * @param {@link StudentGrade}
	 */
	private void populateGradeDetailsDTO(StudentGradeDTO studentGradeDTO, StudentGrade studentGrade) throws Exception {

		ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = convertClassSubjectReferenceDataEntitytoDTO(studentGrade.getClassSubjectReferenceData());
		GradeDetailsDTO gradeDetailsDTO = new GradeDetailsDTO();
		gradeDetailsDTO.setGrade(studentGrade.getGrade());
		gradeDetailsDTO.setMark(studentGrade.getMark());
		gradeDetailsDTO.setGradeDetailsId(studentGrade.getId());
		if (studentGradeDTO.getGradeDetailsMap() == null)
			studentGradeDTO.setGradeDetailsMap(new GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO>());
		studentGradeDTO.getGradeDetailsMap().put(classSubjectReferenceDataDTO, gradeDetailsDTO);
	}

	/**
	 * Method to convert ClassStudent to DTO
	 * 
	 * @param classStudent
	 * @return classStudentDTO
	 * @throws Exception
	 */
	public ClassStudentDTO convertClassStudentEntityToDTO(ClassStudent classStudent) throws Exception {

		ClassStudentDTO classStudentDTO = new ClassStudentDTO();
		StudentDTO studentDTO = convertStudentEntitytoDTO(classStudent.getStudent());
		ClassDTO classDTO = convertClassEntityToDTO(classStudent.getClassObj());
		PropertyUtils.copyProperties(classStudentDTO, classStudent);
		classStudentDTO.setStudentDTO(studentDTO);
		classStudentDTO.setClassDTO(classDTO);
		return classStudentDTO;

	}

	/**
	 * Method to convert ClassStudentDTO to Entity
	 * 
	 * @param classStudent
	 * @return classStudentDTO
	 * @throws Exception
	 */
	public ClassStudent convertClassStudentDTOToEntity(ClassStudentDTO classStudentDTO) throws Exception {

		ClassStudent classStudent = new ClassStudent();
		PropertyUtils.copyProperties(classStudent, classStudentDTO);
		Class classObj = convertClassDTOToEntity(classStudentDTO.getClassDTO());
		Student student = convertStudentDTOToEntity(classStudentDTO.getStudentDTO());
		classStudent.setStudent(student);
		classStudent.setClassObj(classObj);
		return classStudent;

	}

}
