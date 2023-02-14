package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "ccourse/getAll", method = RequestMethod.GET)

    public List<course> getAllCourse() {

        List<course> course = courseService.getAllCourse();
        return course;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public course getCourseById(@RequestParam Integer courseId) {
        course course = courseService.getCourseById(courseId);
        return course;
    }

    @RequestMapping(value = "getByActive")
    public List<course> getByActive() {
        List<course> activeCourseList = courseService.getByActive();
        return activeCourseList;

    }

    @RequestMapping(value = "getByInActive")
    public List<course> getByInActive() {
        List<course> InActiveCourseList = courseService.getByInActive();
        return InActiveCourseList;

    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public course getByCourselName(@RequestParam String CourseName) {
        course course = courseService.getByCourselName(CourseName);
        return course;
    }
}
