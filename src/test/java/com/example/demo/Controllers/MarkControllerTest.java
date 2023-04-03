package com.example.demo.Controllers;

import com.example.demo.Models.Mark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarkControllerTest {
    @Autowired
    MarkController markController;

    @Test
    void getAllMark() {
        List<Mark> allMarkTest = markController.getAllMark();
        assertNotNull(allMarkTest);
    }

    @Test
    void getMarkById() {
        Mark markIdTest = markController.getMarkById(1);
        String markName = markIdTest.getGrade();
        assertNotNull(markIdTest);
        assertNotEquals("20", markName);
        assertEquals("4", markName);
    }

    @Test
    void getByInActive() {
        List<Mark> inActineTest = markController.getByInActive();
        assertNotNull(inActineTest);
    }

    @Test
    void getLatestRow() {
        Mark latesRowTest = markController.getLatestRow();
        assertNotNull(latesRowTest);
    }

    @Test
    void getLatestUpdated() {
        Mark leatesUpdateTest = markController.getLatestUpdated();
        assertNull(leatesUpdateTest);
    }
}

