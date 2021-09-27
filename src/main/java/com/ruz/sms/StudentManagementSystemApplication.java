package com.ruz.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ruz.sms.entity.Student;
import com.ruz.sms.repository.StudentRepository;

import antlr.TokenWithIndex;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// inject student object repository
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Student s1 = new Student("Ruzbihan", "Zaleek", "ruzbihan@gmail.com",
		 * "0774578946"); studentRepository.save(s1);
		 * 
		 * Student s2 = new Student("Tharangi", "Bandara", "tharangi@gmail.com",
		 * "0771245789"); studentRepository.save(s2);
		 * 
		 * Student s3 = new Student("Madhuka", "Harshana", "harshana@gmail.com",
		 * "0773355778"); studentRepository.save(s3);
		 */

	}
}
