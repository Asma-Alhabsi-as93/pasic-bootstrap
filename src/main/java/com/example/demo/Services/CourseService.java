package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Repositories.CourseReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    @Autowired
    CourseReposotry courseReposotry;

    public List<course> getAllCourse() {
        return courseReposotry.getAllCourse();
    }

    public course getCourseById(Integer courseId) {
        course course = courseReposotry.getCourseById(courseId);
        return course;
    }
    public List<course> getByActive(){
        return courseReposotry.getByActive();

    }
    public List<course> getByInActive(){
        return courseReposotry.getByInActive();

    }
}
