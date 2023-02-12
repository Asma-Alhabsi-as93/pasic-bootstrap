package com.example.demo.Controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Models.course;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.MarkService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class GeneralController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "addStudent")
    public void addStudent() {
        studentService.addStudent();
        studentService.addStudent();
    }

    @GetMapping(value = "deleteById")
    public String deleteStudentById(@RequestParam Integer id) {

        studentService.deleteStudentById(id);
        return "Record Deleted Successfully :)";
    }


    @GetMapping(value = "student")
    public String helloStudent() {
        return "Hello Student";
    }


    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)

    public List<Student> getAllStudents() {

        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)

    public List<School> getAllSchool() {

        List<School> schools = schoolService.getAllSchooles();
        return schools;
    }


    @Autowired
    MarkService markService;

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)

    public List<Mark> getAllMark() {

        List<Mark> marks = markService.gettAllMarks();
        return marks;
    }


    @Autowired
    CourseService courseService;

    @RequestMapping(value = "ccourse/getAll", method = RequestMethod.GET)

    public List<course> getAllCourse() {

        List<course> course = courseService.getAllCourse();
        return course;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }


    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markService.getMarkById(markId);
        return mark;
    }


    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public course getCourseById(@RequestParam Integer courseId) {
        course course = courseService.getCourseById(courseId);
        return course;
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;
    }
        @RequestMapping(value = "School/getBySchoolName", method = RequestMethod.GET)
        public School getStudentBySchoolName(@RequestParam String SchoolName) {
            School school = schoolService.getStudentBySchoolName(SchoolName);
            return school;

        }
}
