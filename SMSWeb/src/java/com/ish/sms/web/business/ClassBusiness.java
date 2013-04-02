package com.ish.sms.web.business;

import java.util.List;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassListDTO;

/**
 * Business class for all class related actions. This is called from the Action bean/class. The methods in the class also converts the DTO
 * to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class ClassBusiness extends BaseBusiness {

	/**
	 * Method to get the class corresponding to the given id
	 * 
	 * @return classDTO {@link ClassDTO}
	 * @throws Exception
	 */
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveClassForId(classId);
		ClassDTO classDTO = serviceTransformer.parseXml(classDTOXML);
		return classDTO;
	}

	/**
	 * Method to update/insert class.
	 * 
	 * @param classDTO
	 *            {@link classDTO}
	 * @return persistedClassDTO {@link classDTO}
	 * @throws Exception
	 */
	public ClassDTO saveClass(ClassDTO classDTO) throws Exception {

		String classXML = serviceTransformer.transformToXML(classDTO, CLASS_DTO);
		classXML = classBusinessDelegate.saveClass(classXML);
		return serviceTransformer.parseXml(classXML);
	}

	/**
	 * Method to return the list of all active classes
	 * 
	 * @return classDTOList {@link ClassDTO}
	 * @throws Exception
	 * 
	 */

	public List<ClassDTO> retrieveAllClasses() throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveAllClasses();
		ClassListDTO classListDTO = serviceTransformer.parseXml(classDTOXML);
		return classListDTO.getClassDTOList();
	}
}
