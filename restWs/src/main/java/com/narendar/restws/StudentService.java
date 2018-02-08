package com.narendar.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.narendar.restws.model.Student;
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/studentService")

public interface StudentService {
	@Path("/students")
	@GET
	List<Student> getStudents();
	@Path("/students/{id}")
	@GET
	Student getStudents(@PathParam(value="id")Long id);
	@Path("/students")
	@POST
	Response createStudent(Student student);
	@Path("/students")
	@PUT
	Response updateStudent(Student student);
	@Path("/students/{id}")
	@DELETE
	Response deleteStudent(@PathParam(value="id")Long id);
	

}
