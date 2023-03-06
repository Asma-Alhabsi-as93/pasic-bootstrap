package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Repositories.CourseReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public course getByCourselName(String CourseName){
        course course=courseReposotry.getByCourselName(CourseName);
        return course;
    }
    public void deleteCoursrById(Integer courseId) {
        course courseToDelete =courseReposotry.findById(courseId).get();
        courseReposotry.delete(courseToDelete);
    }
    public course getLatestRow(){
        course course= courseReposotry.getLatestRow();
        return course;
    }
    public course getLatestUpdated(){
        course course= courseReposotry.getLatestUpdated();
        return course;
    }

    public course getByCourseName(String coursenName){
        course course=  courseReposotry.getByCourseName(coursenName);
        return course;
    }

    public List<course> getCourseCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<course>courses = courseReposotry.getCourseCreatedAfterDate(convertedDateFromStringToDateFormat);
        return courses;
    }
}
