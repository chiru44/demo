package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean 
	private StudentRepository studentRepo;
	@MockBean
	private StudentService studentService;

	Student mockCourse = new Student(110, "raju", "Class 9", "Hyderabad");

	String exampleStudentJson = "{\"studentId\":111,\"studentName\":\"ramesh\",\"className\":\"Class 9\",\"address\":\"Hyderabad\"}";

	@Test
	public void retrieveDetailsOfStudent() throws Exception {
		

		Mockito.when(studentService.getStudentData(Mockito.anyInt())).thenReturn(Optional.of(mockCourse));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getId/110").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "{'studentId':110,'studentName':'raju','className':'Class 9', 'address': 'Hyderabad'}";

		

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void createStudent() throws Exception {
		Student mockCourse = new Student(111, "ramesh", "Class 9", "Hyderabad");

		
		Mockito.when(
				studentService.saveStudent(Mockito.any(Student.class))).thenReturn(mockCourse);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/saveStudent")
				.accept(MediaType.APPLICATION_JSON).content(exampleStudentJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
}

