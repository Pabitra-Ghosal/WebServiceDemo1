package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
