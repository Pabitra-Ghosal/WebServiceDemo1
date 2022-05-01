package com.example.servicess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repository;

	@Override
	public int saveStudent(Student student) {
		
		
		
		if(student!= null)
		{
			Student studentdb=this.repository.save(student);
			if(studentdb!=null)
				return studentdb.getId();
			else
				return 0;
		}
		else
			return 0;
	}

	@Override
	public boolean updateStudent(int id,Student student) {
		
		if( id!=0 && student!=null) {
			
			Student updateStudent=this.repository.getById(id);
		
			updateStudent.setName(student.getName());
			updateStudent.setEmail(student.getEmail());
			updateStudent.setMobile(student.getMobile());
			updateStudent.setPass(student.getPass());
			Student updatedSt=this.repository.save(updateStudent);
			if(updatedSt!=null)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		if(id!=0)
			this.repository.deleteById(id);
		return true;
	}

	@Override
	public List<Student> getAll() {
		
		return this.repository.findAll();
	}

	@Override
	public Student getStudent(int id) {
		
			return this.repository.findById(id).get();
		
	}

}
