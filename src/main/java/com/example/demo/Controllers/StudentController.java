package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

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

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }

    @RequestMapping(value = "getByActive")
    public List<Student> getByActive() {
        List<Student> activeStudentList = studentService.getByActive();
        return activeStudentList;

    }

    @RequestMapping(value = "getByInActive")
    public List<Student> getByInActive() {
        List<Student> InActiveStudentList = studentService.getByInActive();
        return InActiveStudentList;

    }

    @RequestMapping(value = "getByStudentName", method = RequestMethod.GET)
    public Student getStudenttByName(@RequestParam String StudentName) {
        Student student = studentService.getStudenttByName(StudentName);
        return student;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        return student;
    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public Student  getLatestUpdated() {
        Student student = studentService. getLatestUpdated();
        return student;

    }
    @RequestMapping(value = "getStudentCreatedAfterDate" ,method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate ) throws ParseException {
        List<Student> students = studentService.getStudentCreatedAfterDate(createdDate);
        return students;



    }
}