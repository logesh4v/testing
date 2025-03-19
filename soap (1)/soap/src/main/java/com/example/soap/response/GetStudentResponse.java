package com.example.soap.response;

import com.example.soap.model.Student;

import jakarta.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "GetStudentResponse")
public class GetStudentResponse {
	private Student student;
 
	public Student getStudent() {
		return student;
	}
 
	public void setStudent(Student student) {
		this.student = student;
	}
 
}