package com.stackroute.neo4jdemo.repository;

import com.stackroute.neo4jdemo.domain.Course;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface  CourseRepository  extends Neo4jRepository<Course,Long> {


    @Query("MATCH (c:Course) RETURN c")
    Collection<Course> getAllCourse();

    @Query("CREATE (c:Course) SET c.id={courseId},c.name={courseName},c.duration={duration} RETURN c")
    public Course createNode(Long courseId, String courseName,int duration);

    @Query("MATCH (c:Course) WHERE c.id={courseId} SET c.courseName={courseName},c.duration={duration} RETURN c")
    Course updateNode(@Param("courseId")Long courseId, @Param("courseName") String courseName,@Param("duration")int duration);

    @Query("MATCH (c:Course) WHERE c.courseName={courseName} RETURN c")
    public Course getNode(@Param("courseName") String courseName);

    @Query("MATCH (n:Course) WHERE id(n)={courseId} DETACH DELETE n RETURN 'node deleted' ")
     Course deleteNode(Long courseId);

}
