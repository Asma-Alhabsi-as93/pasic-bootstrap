package com.example.demo.Repositories;

import com.example.demo.Models.course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


    @Repository
    public interface CourseReposotry extends CrudRepository<course, Integer> {
        @Query(value = "SELECT s from course s")
        List<course> getAllCourse();


        @Query(value = "SELECT s from course s where s.id =:courseId")
        course getCourseById(@Param("courseId")Integer courseId);

        @Query(value = "SELECT s from course s where s.isActive = 1")
        List<course> getByActive();

        @Query(value = "SELECT s from course s where s.isActive = 0")
        List<course> getByInActive();
        @Query(value = "SELECT s from course s "+" where s.name =:courseName")
        course getByCourselName(@Param("courseName")String courseName);

        @Query(value ="SELECT s from course s where s.id=(SELECT max(s.id) from course s)")
        course getLatestRow();

        @Query(value ="SELECT s from course s where s.updatedDate = (SELECT max(s.updatedDate) from course s)")
        course getLatestUpdated();

        @Query(value = "SELECT s from course s "+" where s.name =:courseName")
        course getByCourseName(@Param("courseName")String courseName);

        @Query(value ="SELECT s from course s where s.createdDate > : createdDate")
        List<course> getCourseCreatedAfterDate(@Param("createdDate") Date createdDate);

    }

