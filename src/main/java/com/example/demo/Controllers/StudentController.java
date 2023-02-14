package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)

    public List<Student> getAllStudents() {

        List<Student> students = studentService.getAllStudents();
        return students;
    }

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

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }
    @RequestMapping(value ="getByActive")
    public List<Student> getByActive() {
        List<Student> activeStudentList = studentService.getByActive();
        return  activeStudentList ;

    }
    @RequestMapping(value ="getByInActive")
    public List<Student> getByInActive() {
        List<Student> InActiveStudentList = studentService.getByInActive();
        return  InActiveStudentList ;

    }
}
