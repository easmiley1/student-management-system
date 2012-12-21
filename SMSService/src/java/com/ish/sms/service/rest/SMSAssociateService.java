package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.ops.AssociateOperations;
import com.ish.sms.service.util.ServiceTransformer;

@Service
@Path("/smsAssociateService")
public class SMSAssociateService {

	@Autowired
	private ServiceTransformer serviceTransformer;
	
	@Autowired
	private AssociateOperations associateOperations;

	@POST
	@Path("/createStudent/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String createStudent(String xml) throws JAXBException {

		StudentDTO studentDTO = null;
		try {
			studentDTO = serviceTransformer.tryParseXml(xml);
			studentDTO = associateOperations.createOrUpdateStudent(studentDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceTransformer.transformToXML(studentDTO, "studentDTO");
	}

}
