package com.narendar.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.narendar.restws.exceptions.StudentBusinessException;
@Provider
public class StudentExceptionMapper implements ExceptionMapper<StudentBusinessException>{

	

	@Override
	public Response toResponse(StudentBusinessException e) {
		StringBuilder sb= new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"try Again later\"");
		sb.append("}");
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
