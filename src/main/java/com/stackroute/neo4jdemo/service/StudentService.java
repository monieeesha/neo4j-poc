package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface StudentService {


    public Student saveStudent(Student student);

    public Collection<Student> getAll();

    public void deleteStudent(Long id);

    public Student updateStudent(Student student,Long id);

    public Student getByName(String name);

    public Student saveRelation(String sname,String cname);

}

