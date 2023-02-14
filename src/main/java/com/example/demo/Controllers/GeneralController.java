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
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "Student/getBySchoolName", method = RequestMethod.GET)
    public List <Student> getStudentBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentBySchoolName(schoolName);
    }

    }

