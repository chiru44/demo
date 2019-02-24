package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
		
	}
	
	public Optional<Student> getStudentData(int studentId) {
		return Optional.of(studentRepo.findByStudentId(studentId));
	}

}
