package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Course;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface CourseService {


    public Collection<Course> getAll();

    public Course saveCourse(Long courseId,String courseName,int duration);

    public Course updateCourse(Course course,Long id);

    public Course getByName(String name);

    public void deleteCourse(Long id);

}
