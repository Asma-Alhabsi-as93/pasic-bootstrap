package com.example.demo.Controllers;

import com.example.demo.Models.course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseControllerTest {
@Autowired
CourseController courseController;
    @Test
    void getAllCourse() {
        List<course>allCourseTest=courseController.getAllCourse();
        assertNotNull(allCourseTest);
    }

    @Test
    void getCourseById() {
        course courseByIdTest=courseController.getCourseById(3);
        String courseName=courseByIdTest.getName();
        assertNotNull(courseByIdTest);
        assertEquals("gava",courseName);
        assertNotEquals("since",courseName);

    }

    @Test
    void getByActive() {
       List <course> activeTest=courseController.getByActive();
        assertNotNull(activeTest);
    }

    @Test
    void getByInActive() {
        List <course> inActiveTest=courseController.getByInActive();
        assertNotNull(inActiveTest);
    }

    @Test
    void getByCourselName() {
        course courseNameTest = courseController.getByCourselName("math");
        int courseId = courseNameTest.getId();
        assertNotNull(courseNameTest);
        assertEquals(1, courseId);
        assertNotEquals(4, courseId);
    }

    @Test
    void getLatestRow() {
        course latesRoWTest=courseController.getLatestRow();
        assertNotNull(latesRoWTest);
    }
    @Test
    void getLatestUpdated() {
        course latesUpdateTest=courseController.getLatestUpdated();
        assertNull(latesUpdateTest);
    }

}