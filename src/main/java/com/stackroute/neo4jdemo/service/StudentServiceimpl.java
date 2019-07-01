package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.Student;
import com.stackroute.neo4jdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentServiceimpl implements  StudentService{

    @Autowired
    StudentRepository studentRepository;

    private  Student student;

    public StudentServiceimpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student)
    {
       Student  savedstudent=null;

       savedstudent=studentRepository.createNode(student.getStudentId(),student.getStudentName(),student.getAge());

        System.out.println(savedstudent);

       return  savedstudent;

    }

    @Override
    public Collection<Student> getAll()
    {

        return studentRepository.getAllStudents();

    }

    @Override
    public void deleteStudent(Long id)
    {

        studentRepository.deleteNode(id);
    }

    @Override
    public Student updateStudent(Student student,Long id)
    {

        return studentRepository.updateNode(id,student.getStudentName(),student.getAge());

    }

    @Override
    public Student getByName(String name) {
        return  studentRepository.getNode(name);
    }

    @Override
    public Student saveRelation(String sname,String cname) {
        return studentRepository.createRelation(sname,cname);
    }
}
