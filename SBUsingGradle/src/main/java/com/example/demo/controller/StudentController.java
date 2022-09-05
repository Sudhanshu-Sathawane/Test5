package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
	@PostMapping(path="/customer",consumes= {"application/json"})

	 public Student addCustomer(@RequestBody Student student)

	 {

	 repo.save(student);

	 return student;

	 }

	 @GetMapping(path="/students")

	 public List<Student> getStudents()

	 {

	 return repo.findAll();

	 }

	 @RequestMapping("/student/{studentid}")

	 public Optional<Student> getCustomer(@PathVariable("studentid")int studentid)

	 {

	 return repo.findById(studentid);

	 }

	 @DeleteMapping("/student/{studentid}")

	 public String deleteCustomer(@PathVariable int studentid)

	 {

		Student a = repo.getOne(studentid);

	 repo.delete(a);

	 return "deleted";

	 }

	 @PutMapping(path="/student",consumes= {"application/json"})

	 public Student saveOrUpdateStudent(@RequestBody Student student)

	 {

	 repo.save(student);

	 return student;

	 }
	
}
