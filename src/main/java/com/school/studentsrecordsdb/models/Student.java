package com.school.studentsrecordsdb.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_STUDENT")
@ApiModel("Student")
public class Student implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(example = "0", position = 1)
    private Integer id;
    
    @ApiModelProperty(example = "Jonas Hutcherson", position = 2)
    private String name;

    @ApiModelProperty(example = "16", position = 3)
    private Integer age;

    @ApiModelProperty(example = "9.2", position = 4)
    private Double firstSemesterGrade;

    @ApiModelProperty(example = "7.45", position = 5)
    private Double secondSemesterGrade;

     @ApiModelProperty(example = "Maria Dias", position = 6)
    private String teacherName;

    @ApiModelProperty(example = "27", position = 7)
    private Integer classroomNumber;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setFirstSemesterGrade(Double firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    public Double getSecondSemesterGrade() {
        return secondSemesterGrade;
    }

    public void setSecondSemesterGrade(Double secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

}