package com.school.studentsrecordsdb.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_STUDENT")
public class Student implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    private Integer age;
    private Double firstSemesterGrade;
    private Double secondSemesterGrade;
    private String teacherName;
    private Integer classroomNumber;

    

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Integer return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return Double return the firstSemesterGrade
     */
    public Double getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    /**
     * @param firstSemesterGrade the firstSemesterGrade to set
     */
    public void setFirstSemesterGrade(Double firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    /**
     * @return Double return the secondSemesterGrade
     */
    public Double getSecondSemesterGrade() {
        return secondSemesterGrade;
    }

    /**
     * @param secondSemesterGrade the secondSemesterGrade to set
     */
    public void setSecondSemesterGrade(Double secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }

    /**
     * @return String return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return Integer return the classroomNumber
     */
    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    /**
     * @param classroomNumber the classroomNumber to set
     */
    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

}
