package com.stackroute.neo4jdemo.controller;


import com.stackroute.neo4jdemo.domain.Student;
import com.stackroute.neo4jdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/std")
public class StudentController {

    @Autowired
    StudentService  studentService;

    @GetMapping("students")
    public Collection<Student> getAll()
    {
          return  studentService.getAll();
    }

    @PostMapping("studentsave")
    public Student saveStudent(@RequestBody Student student) {
        Student student1=null;
        student1=studentService.saveStudent(student);
        System.out.println(student1.getStudentName());
        return student1;

    }

    @PutMapping("studentupdate/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id){
        return studentService.updateStudent(student,id);
    }

    @GetMapping("studentname/{studentName}")
    public  Student getStudent(@PathVariable String studentName){
        return studentService.getByName(studentName);
    }

    @DeleteMapping("studentdelete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "Deleted Student";
    }

    @PostMapping("graph/{studentname}/{coursename}")
    public Student saveRelation(@PathVariable String studentname,@PathVariable String coursename){

        return  studentService.saveRelation(studentname,coursename);
    }

}
