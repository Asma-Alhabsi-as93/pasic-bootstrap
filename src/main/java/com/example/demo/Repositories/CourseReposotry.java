package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface CourseReposotry extends CrudRepository<course, Integer> {
        @Query(value = "SELECT s from course s")
        List<course> getAllCourse();


        @Query(value = "SELECT s from course s where s.id =:courseId")
        course getCourseById(@Param("courseId")Integer courseId);
    }

