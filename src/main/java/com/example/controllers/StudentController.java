package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Student;
import com.example.responses.ApiResponse;
import com.example.servicess.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;

	@GetMapping("/")
	public String test()
	{
		return "check";
	}
	
	@PostMapping("/reg")
	public ResponseEntity<?> register(@RequestBody Student student)
	{
		try {
			int isSaved=this.service.saveStudent(student);
			if(isSaved!=0)
				return ResponseEntity.ok(new ApiResponse("Register complete", "success", 201, true));
			else
				return ResponseEntity.ok(new ApiResponse("Registration failed", "failed", 400, false));
			
		}catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad request", 502, false));
		}
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id)
	{
		try {
			boolean isDeleted=this.service.deleteStudent(id);
			if(isDeleted)
				return ResponseEntity.ok(new ApiResponse("Student Deleted", "Success", 203, true));
			else
				return ResponseEntity.ok(new ApiResponse("Student not delete", "failed", 400, false));
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad request", 502, false));
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		try {
			List<?> students= this.service.getAll();
			if(students!=null && students.size()>0)
				return ResponseEntity.ok(new ApiResponse("Students list", "success", 200, true, students));
			else
				return ResponseEntity.ok(new ApiResponse("Data not found", "Data not found", 404, false, students));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal server Error", "Bad request", 502, false));
		}
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> update(@RequestBody Student student,@PathVariable("id") int id)
	{
		try {
			boolean isUpdated=this.service.updateStudent(id, student);
			if(isUpdated)
				return ResponseEntity.ok(new ApiResponse("Student updated", "success", 204, true));
			else
				return ResponseEntity.ok(new ApiResponse("Not update", "failed", 400, false));
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal server Error", "Bad request", 502, false));
			
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") int id)
	{
		try {
			Student student=this.service.getStudent(id);
			System.out.println(student);
			if(student!=null)
			{
				List<Student> list=new ArrayList<Student>();
				list.add(student);
				return ResponseEntity.ok(new ApiResponse("Student info", "success", 201, true, list));
			}
			else
				return ResponseEntity.ok(new ApiResponse("not found", "failed", 400, false));
				
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal server Error", "Bad request", 502, false));
		}
	}
}
