package com.example.soap.Services;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.soap.model.Student;
 

@Service
public class StudentService {
	private List<Student> students=new ArrayList<>();
	public StudentService() {
		students.add(new Student(1,"Tanuj", 22 ,"A"));
		students.add(new Student(1,"Ankita", 22 ,"A"));
		students.add(new Student(1,"Tarun", 22 ,"A"));
	}
	public Student getStudentById(int id) {
		return students.stream().filter(s->s.getId() == id).findFirst().orElse(null);
	}
	public String addStudent(int id, String name, int age, String grade) {
		students.add(new Student(id, name, age,grade));
		return "Student Added Successfully";
	}
	public List<Student> getAllStudents(){
		return students;
	}
}