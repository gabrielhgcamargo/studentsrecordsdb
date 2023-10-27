package com.school.studentsrecordsdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public Student getStudentById(@PathVariable(value = "id") Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Student not found with this ID."));
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable(value = "id") Integer id){
         studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(id);
            return student;
         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found with this ID."));
    }

    
    @PutMapping("/student/{id}")
    public Student updateStudentById(@PathVariable(value = "id") Integer id, @RequestBody Student student){
         return studentRepository.findById(id).map(student1 -> {
            student.setId(student1.getId());
            studentRepository.save(student);
            return student1;
         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found with this ID."));
    }

}