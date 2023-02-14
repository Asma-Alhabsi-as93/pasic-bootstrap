package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)

    public List<School> getAllSchool() {

        List<School> schools = schoolService.getAllSchooles();
        return schools;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "School/getBySchoolName", method = RequestMethod.GET)
    public School getSchooltBySchoolName(@RequestParam String SchoolName) {
        School school = schoolService.getSchooltBySchoolName(SchoolName);
        return school;

    }

    @RequestMapping(value = "getByActive")
    public List<School> getByActive() {
        List<School> activeSchoolsList = schoolService.getByActive();
        return activeSchoolsList;

    }

    @RequestMapping(value = "getByInActive")
    public List<School> getByInActive() {
        List<School> inActiveSchoolsList = schoolService.getByInActive();
        return inActiveSchoolsList;

    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public School getLatestRow() {
        School school = schoolService.getLatestRow();
        return school;

    }
}
