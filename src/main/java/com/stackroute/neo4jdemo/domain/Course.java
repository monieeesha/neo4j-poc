package com.stackroute.neo4jdemo.domain;

import org.neo4j.ogm.annotation.GeneratedValue;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Course {

     @Id
     @GeneratedValue
    private  Long   courseId;
    private  String courseName;
    private   int   duration;
    public Course()
    {

    }
      public Course(Long courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
