package com.ish.sms.service.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.ReferenceListDTO;

/**
 * Restful service class to handle all Reference data related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsReferenceService")
public class SMSReferenceService extends SMSBaseService{

	/**
	 * Method to get all the reference entities by wrapping them in the referenceListDTO.
	 * 
	 * @return referenceListDTOXML
	 */
	@POST
	@Path("/retrieveAllReferenceList/")
	@Produces("text/xml")
	public String retrieveAllReferenceList() {

		String referenceListDTOXML = null;
		try {
			ReferenceListDTO referenceListDTO = referenceOperations.retrieveAllReferenceList();
			referenceListDTOXML = serviceTransformer.transformToXML(referenceListDTO, "referenceListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return referenceListDTOXML;
	}

}
