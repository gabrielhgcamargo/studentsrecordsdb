package com.school.studentsrecordsdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.studentsrecordsdb.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    
    Optional<Student> findById(Integer id);
}
