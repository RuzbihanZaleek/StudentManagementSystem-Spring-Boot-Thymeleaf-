package com.ruz.sms.service;

import java.util.List;

import com.ruz.sms.entity.Student;

public interface StudentService {

	// get list of all student
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
}
