package com.ish.sms.web.business;

import com.ish.sms.service.dto.ReferenceListDTO;

/**
 * Business class for all reference related actions. This is called from the Action bean/class. The methods in the class also converts the
 * DTO to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class ReferenceBusiness extends BaseBusiness {

	/**
	 * Method to get all the reference entities.
	 * 
	 * @return referenceListDTO
	 * @throws Exception
	 */
	public ReferenceListDTO retrieveAllReferenceList() throws Exception {
		String referenceListDTOXML = referenceBusinessDelegate.retrieveAllReferenceList();
		ReferenceListDTO referenceListDTO = serviceTransformer.parseXml(referenceListDTOXML);
		return referenceListDTO;
	}
}
