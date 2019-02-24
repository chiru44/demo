package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/allStudents", method=RequestMethod.GET, produces="application/json")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@RequestMapping(value="/getId/{studentId}", method=RequestMethod.GET, produces="application/json")
	public Student getStudentInfo(@PathVariable int studentId) {
		 Optional<Student> student = studentService.getStudentData(studentId);

		    if (!student.isPresent())
		      throw new StudentNotFoundException("id-" + studentId);

		  return student.get();
	}
	
	

}
