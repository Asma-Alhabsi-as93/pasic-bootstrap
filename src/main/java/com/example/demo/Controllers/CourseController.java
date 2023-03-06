package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<course> getAllCourse() {

        List<course> course = courseService.getAllCourse();
        return course;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
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

    @RequestMapping(value = "getByCoursreName", method = RequestMethod.GET)
    public course getByCourselName(@RequestParam String CourseName) {
        course course = courseService.getByCourselName(CourseName);
        return course;
    }

    @GetMapping(value = "deleteById")
    public String deleteCoursrById(@RequestParam Integer courseId) {

        courseService.deleteCoursrById(courseId);
        return "Record Deleted Successfully :)";
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public course getLatestRow() {
        course course = courseService.getLatestRow();
        return course;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public course getLatestUpdated() {
        course course = courseService.getLatestUpdated();
        return course;
    }

    @RequestMapping(value = "getByCourseName", method = RequestMethod.GET)
    public course getByCourseName(@RequestParam String coursenName) {
        course course = courseService.getByCourseName(coursenName);
        return course;

    }

    @RequestMapping(value = "getCourseCreatedAfterDate" ,method = RequestMethod.GET)
    public List<course> getCourseCreatedAfterDate(@RequestParam String createdDate ) throws ParseException {
        List<course> courses = courseService.getCourseCreatedAfterDate(createdDate);
        return courses;

    }
}
