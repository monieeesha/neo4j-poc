package com.stackroute.neo4jdemo.controller;

import com.stackroute.neo4jdemo.domain.Course;
import com.stackroute.neo4jdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public Collection<Course> getAll(){
        return courseService.getAll();
    }


    @PostMapping("coursesave")
    public Course saveCourse(@RequestBody Course course) {

        return  courseService.saveCourse(course.getCourseId(),course.getCourseName(),course.getDuration());
    }

    @PutMapping("courseupdate/{id}")
    public Course updateCourse(@RequestBody Course course,@PathVariable Long id){

        return courseService.updateCourse(course,id);
    }

    @GetMapping("coursename/{name}")
    public  Course getCourse(@PathVariable String name){
        return  courseService.getByName(name);
    }

    @DeleteMapping("coursedelete/{id}")
    public String deleteCourse1(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Deleted Course";
    }

}
