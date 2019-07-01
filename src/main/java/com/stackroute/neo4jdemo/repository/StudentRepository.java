package com.stackroute.neo4jdemo.repository;

import com.stackroute.neo4jdemo.domain.Student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends Neo4jRepository<Student,Long> {

    @Query("MATCH (s:Student) RETURN s")
    Collection<Student> getAllStudents();

    @Query("CREATE (u:Student) SET u.id={studentId},u.name={studentName},u.age={age} RETURN u")
    public Student createNode(Long studentId, String studentName, int age);


    @Query("MATCH (n:Student) WHERE id(n)={studentId} DETACH DELETE n RETURN 'node deleted'")
    public Student deleteNode(Long studentId);

    @Query("MATCH (s:Student) WHERE s.name={studentName} RETURN s")
    public Student getNode(@Param("studentName") String studentName);


    @Query("MATCH (n:Student) WHERE n.id={studentId} SET n.name={studentName},n.age={age} RETURN n")
     public Student updateNode(@Param("studentId")Long studentId, @Param("studentName") String studentName, @Param("age") int age);



    @Query("MATCH (a:Student),(b:Course) WHERE a.name={studentname} and b.name={coursename} CREATE (a)-[r:ENROLLS]->(b) RETURN a")
     public Student createRelation(@Param("studentname")String studentName, @Param("coursename")String  courseName);

}
