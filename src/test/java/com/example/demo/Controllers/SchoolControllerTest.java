package com.example.demo.Controllers;

import com.example.demo.Models.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SchoolControllerTest {
@Autowired
SchoolController schoolController;
    @Test
    void getAllSchool() {
        List<School> schoolToTest = schoolController.getAllSchool();
        assertNotNull(schoolToTest);
    }
    @Test
    void getSchoolById(){
        School schoolToTest = schoolController.getSchoolById(1);
        String schoolName=schoolToTest.getName();
        assertNotNull(schoolToTest);
        assertEquals("almaaref",schoolName);
        assertNotEquals("almmaaref",schoolName);
    }

    @Test
    void getSchoolById6() {
        String SchoolId = schoolController.getSchoolById(2).getName();
        assertNotEquals("wedaad",SchoolId);
    }
    @Test
    void getSchooltBySchoolName() {
       School SchoolNameTest=schoolController.getSchooltBySchoolName("NTI");
       int schoolId=SchoolNameTest.getId();
       assertEquals(3,schoolId);
       assertNotNull(SchoolNameTest);
       assertNotEquals(6,schoolId);
    }
    @Test
    void getByActive() {
List<School>activeTest=schoolController.getByActive();
assertNotNull(activeTest);

    }
    @Test
    void getByInActive() {
        List<School>inActiveTest=schoolController.getByInActive();
        assertNotNull(inActiveTest);
    }

}