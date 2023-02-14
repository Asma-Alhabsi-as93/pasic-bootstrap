package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<School> getAllSchool() {

        List<School> schools = schoolService.getAllSchooles();
        return schools;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
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

    } @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
//    public School  getLatestUpdated() {
//        School school = schoolService. getLatestUpdated();
//        return school;
//
//    }
//

    @GetMapping(value = "deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record Deleted Successfully :)";
    }
}
