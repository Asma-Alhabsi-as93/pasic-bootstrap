package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {
@Autowired
StudentController studentController;
    @Test
    void getAllStudents() {
        List<Student> studentToTest = studentController.getAllStudents();
        assertNotNull(studentToTest);
    }

    @Test
    void getStudentById() {
        Student studentIdTest=studentController.getStudentById(1);
        String studentName=studentIdTest.getName();
        assertNotEquals("lamiaa",studentName);
        assertEquals("saleem",studentName);
        assertNotNull(studentIdTest);
    }

    @Test
    void getByActive() {
        List<Student>activeTest=studentController.getByActive();
                assertNotNull(activeTest);
    }

    @Test
    void getByInActive() {
        List<Student>inactiveTest=studentController.getByInActive();
        assertNotNull(inactiveTest);
    }

    @Test
    void getStudenttByName() {
        Student studentNameTest=studentController.getStudenttByName("azaan");
        int studentName=studentNameTest.getId();
        assertNotNull(studentNameTest);
        assertEquals(4,studentName);
        assertNotEquals(9,studentName);
    }

    @Test
    void getLatestRow() {
        Student lastRoeTest=studentController.getLatestRow();
        assertNotNull(lastRoeTest);
    }

    @Test
    void getLatestUpdated() {
        Student latesUpdateTest=studentController.getLatestUpdated();
        assertNull(latesUpdateTest);
    }

}