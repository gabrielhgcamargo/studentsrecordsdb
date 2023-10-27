package com.school.studentsrecordsdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.studentsrecordsdb.models.Student;
import com.school.studentsrecordsdb.repository.StudentRepository;

@RestController
@RequestMapping(value = "/school")
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable(value = "id") Integer id){
        return studentRepository.findById(id);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}