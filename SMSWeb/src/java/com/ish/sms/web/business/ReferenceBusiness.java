package com.ish.sms.web.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dto.ReferenceListDTO;
import com.ish.sms.web.businessdelegate.ReferenceBusinessDelegate;

/**
 * 
 * 
 * @author Naren
 *
 */
public class ReferenceBusiness extends BaseBusiness {

	@Autowired
	private ReferenceBusinessDelegate referenceBusinessDelegate;

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
