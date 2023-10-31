package com.school.studentsrecordsdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/school")
@Tag(name = "student", description = "Operations about student")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    @Tag(name = "student")
    @ApiOperation(value = "List all students.")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    @Tag(name = "student")
    @ApiOperation(value = "Find student by ID.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Student found."),
        @ApiResponse(code = 404, message = "Student not found with this ID."),
    })
    public Student getStudentById(@PathVariable(value = "id") Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Student not found with this ID."));
    }

    @PostMapping("/student")
    @Tag(name = "student")
    @ApiOperation(value = "Add a new student.")
    @ResponseStatus(HttpStatus.CREATED)
        @ApiResponses({
            @ApiResponse(code = 201, message = "Student created."),
            @ApiResponse(code = 400, message = "Bad request error. One or more fields in the request contain incorrect data types. Check the example value.")
    })
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    @ApiOperation(value = "Delete a Student by ID.")
    @Tag(name = "student")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        @ApiResponses({
        @ApiResponse(code = 204, message = "Student deleted."),
        @ApiResponse(code = 404, message = "Student not found with this ID."),
    })
    public void deleteStudentById(@PathVariable(value = "id") Integer id){
         studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(id);
            return student;
         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found with this ID."));
    }

    
    @PutMapping("/student/{id}")
    @Tag(name = "student")
    @ApiOperation(value = "Update an existing Student by ID.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Student updated."),
        @ApiResponse(code = 404, message = "Student not found with this ID."),
        @ApiResponse(code = 400, message = "Bad request error. One or more fields in the request contain incorrect data types. Check the example value.")
    })
    public Student updateStudentById(@PathVariable(value = "id") Integer id, @RequestBody Student student){
         return studentRepository.findById(id).map(student1 -> {
            student.setId(student1.getId());
            studentRepository.save(student);
            return student1;
         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found with this ID."));
    }

}