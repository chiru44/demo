package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

@SpringBootApplication
@CrossOrigin
public class DemoApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(DemoApplication.class);
	@Autowired
	private StudentRepository studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Student s1 = new Student(101, "Chiranjeevi", "Class 10", "Hyderabad");
		Student s2 = new Student(102, "Bharath", "Class 9", "chittoor");
		studentRepo.save(s1);
		studentRepo.save(s2);
		logger.info("two records saved successfully");
	}

	
}
