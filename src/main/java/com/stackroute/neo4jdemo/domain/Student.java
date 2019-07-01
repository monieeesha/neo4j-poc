package com.stackroute.neo4jdemo.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Student {


     @Id
     @GeneratedValue
     private Long studentId;
     private  String studentName;
     private int age;

     public Student()
     {

     }

     @Relationship(type= "enrolls")
     private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public Student(Long studentId, String studentName, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age; }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}
