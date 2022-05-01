package com.example.servicess;

import java.util.List;

import com.example.entities.Student;

public interface StudentService {
	
	public int saveStudent(Student student);
	public boolean updateStudent(int id,Student student);
	public boolean deleteStudent(int id);
	public List<Student> getAll();
	public Student getStudent(int id);

}
