package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.RequstObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public School getLatestUpdated() {
        School school = schoolService.getLatestUpdated();
        return school;

    }


    @GetMapping(value = "deleteById")
    public String deleteSchoolById(@RequestParam Integer id) {

        schoolService.deleteSchoolById(id);
        return "Record Deleted Successfully :)";
    }

    @GetMapping(value = "deleteAll")
    public void deleteAll() {
        schoolService.deleteAll();

    }

    @RequestMapping(value = "UpdateCreateDataByUserInput", method = RequestMethod.POST)
    public void setUpdateByUserInput(@RequestParam SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> schools = schoolService.getSchoolCreatedAfterDate(createdDate);
        return schools;
    }

    @RequestMapping(value = "getSchoolCreateddDate", method = RequestMethod.GET)
    public List<School> getSchoolCreateddDate(@RequestParam String createdDate) throws ParseException {
        List<School> schools = schoolService.getSchoolByCreatedDate(createdDate);
        return schools;

    }

    @RequestMapping(value = "getSchoolUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolUpdatedDate(@RequestParam String updateDate) throws ParseException {
        List<School> schools = schoolService.getSchoolUpdatedDate(updateDate);
        return schools;

    }

    @RequestMapping(value = "deleteAllSchoolsUpdatedDate", method = RequestMethod.GET)
    public void findByUpdatedDate(Date updatedDate) {

        schoolService.findByUpdatedDate(updatedDate);
    }

//    @GetMapping(value = "deleteBySchoolName")
//    public String deleteBySchoolName(@RequestParam String name) {
//
//        schoolService.deleteBySchoolName(name);
//        return "Record Deleted Successfully :)";
//    }


    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.GET)
    public void deleteAllSchoolsCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
       schoolService.deleteAllSchoolsCreatedAfterDate(createdDate);

    }


    @RequestMapping(value = "deleteSchoolByCreatedDate", method = RequestMethod.POST)
    public void deleteSchoolByCreatedDate(@RequestParam String createdDate) throws ParseException {
        schoolService.deleteSchoolByCreatedDate(createdDate);
    }

    @RequestMapping(value = "deleteSchoolByUpdateDate", method = RequestMethod.POST)
    public void deleteSchoolByUpdateDate(@RequestParam String updatedDate) throws ParseException {
        schoolService.deleteSchoolByUpdateDate(updatedDate);
    }

    @RequestMapping(value = "getSchoolByNumberOfStudent", method = RequestMethod.GET)
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
        List<School> schoolList = schoolService.getSchoolByNumberOfStudent(numberOfStudent);
        return schoolList;
    }

}

