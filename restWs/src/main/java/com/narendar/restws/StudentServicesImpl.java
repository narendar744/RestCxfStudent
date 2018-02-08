package com.narendar.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.narendar.restws.model.Student;

@Service
public class StudentServicesImpl implements StudentService {
	Map<Long,Student> students= new HashMap<>();
	Long currentId=100L;
	public StudentServicesImpl() {
		init();
	}
	 void init() {
		 Student student= new Student();
		 student.setId(currentId);
student.setName("narendar");	
students.put(student.getId(),student);
	}
	@Override
	public List<Student> getStudents() {
Collection<Student> results = students.values();
ArrayList<Student> response = new ArrayList<>(results);
		return response;
	}
	@Override
	public Student getStudents(Long id) {
		return students.get(id);
	}
	@Override
	public Response createStudent(Student student) {
		student.setId(++currentId);
		students.put(student.getId(), student);

		return Response.ok(student).build();
	}
	@Override
	public Response updateStudent(Student student) {
		Student currentStudent = students.get(student.getId());
		Response response;
		if(currentStudent!=null) {
			students.put(student.getId(),student);
			response=Response.ok(student).build();
		}
		else {
			response=Response.notModified().build();
		}
		return response;
	}
	@Override
	public Response deleteStudent(Long id) {
Student student = students.get(id);
Response response;
if(student!=null) {
	students.remove(id);
	response= Response.ok().build();
}
else
	response=Response.notModified().build();
		return response;
	}

}
