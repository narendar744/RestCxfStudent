package com.narendar.restwsClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.narendar.restwsClient.model.Student;

public class StudentRestWsClient {

	private static final String student_URL = "http://localhost:8080/restws/services/studentService";

	public static void main(String[] args) {
Client client = ClientBuilder.newClient();
WebTarget target = client.target(student_URL).path("/students").path("{id}").resolveTemplate("id", 100);
	Builder request = target.request();
Student student=request.get(Student.class);

System.out.println("**************************************************************************");
	System.out.println(student.getName()+"   "+student.getId());
	
	/******************************************updating method******************************/
	student.setName("Srinish");
	WebTarget putTarget = client.target(student_URL).path("/students");//update student
	Response updateResponse = putTarget.request().put(Entity.entity(student, MediaType.APPLICATION_XML));
	System.out.println(updateResponse.getStatus());
	System.out.println(student.getName());
	System.out.println(student.getId());
	updateResponse.close();
	
	
	
	/*****************Creating Student*******************************/
	Student newStudent= new Student();
	newStudent.setName("nandu");
	WebTarget postTarget = client.target(student_URL).path("/students");
	Student CreatedStudent = postTarget.request().post(Entity.entity(student, MediaType.APPLICATION_XML),Student.class);
	System.out.println("**************************************************************************");
	System.out.println("Generated new id  ="+CreatedStudent.getId());
	
	
	
	/*************************Deleting Student*******************/
	WebTarget deleteTarget = client.target(student_URL).path("/students").path("{id}").resolveTemplate("id", 100);
	Response delteResponse = deleteTarget.request().delete();
	System.out.println("**************************************************************************");
	System.out.println("delte response    :"+delteResponse.getStatus());
	}

}
