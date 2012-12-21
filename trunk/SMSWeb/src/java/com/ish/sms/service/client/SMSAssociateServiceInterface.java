package com.ish.sms.service.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface SMSAssociateServiceInterface {

    @POST
    @Path("/createStudent/")
    @Produces("text/xml")
    @Consumes( "text/xml" )
	public String createStudent(String xml) ;
    

}
