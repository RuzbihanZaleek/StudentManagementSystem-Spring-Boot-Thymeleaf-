package com.ruz.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ruz.sms.entity.Student;
import com.ruz.sms.service.StudentService;

@Controller // make this class spring MVC to handle requests
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handle method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {

		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // return a view name as students
	}

	///////// CREATE STUDENT /////////////////////////
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create empty object to hold student from data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	//////////// UPDATE STUDENT ////////////////
	// handling edit button
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	// handling update button
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setContactNumber(student.getContactNumber());
		existingStudent.setGender(student.getGender());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	///////////////// DELETE STUDENT /////////////////
	// handling delete button

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
