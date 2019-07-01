package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Course;
import com.stackroute.neo4jdemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Courseserviceimpl implements  CourseService {


    @Autowired
    CourseRepository courseRepository;

    public Courseserviceimpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Collection<Course> getAll() {
        return  courseRepository.getAllCourse();
    }

    @Override
    public Course saveCourse(Long courseId, String courseName, int duration) {
        Course savedcourse=null;
        savedcourse=courseRepository.createNode(courseId,courseName,duration);
        System.out.println(savedcourse);
        return savedcourse;

    }

    @Override
    public Course updateCourse(Course course,Long id)
    {
        return courseRepository.updateNode(id, course.getCourseName(), course.getDuration());
    }

    @Override
    public Course getByName(String name) {
        return courseRepository.getNode(name);
    }

    @Override
    public void deleteCourse(Long id) {
       courseRepository.deleteNode(id);
    }
}
