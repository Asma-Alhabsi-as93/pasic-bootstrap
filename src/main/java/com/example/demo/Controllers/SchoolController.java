package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.RequstObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.SchoolService;
import com.example.demo.Slack.SlackClient;
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

    @Autowired
    SlackClient slackClient;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<School> getAllSchool() {

        List<School> schools = schoolService.getAllSchooles();
        for (School s : schools) {
//            slackClient.sendMessage("school name:"+s.getName());
//            slackClient.sendMessage("school_id:"+s.getId());
//            slackClient.sendMessage("school_Active:"+s.getActive());
//            slackClient.sendMessage("school_CreateDate:"+s.getCreatedDate());
//            slackClient.sendMessage("school_UpdateDate:"+s.getUpdatedDate());

        }
        return schools;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
//        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public School getSchooltBySchoolName(@RequestParam String SchoolName) {
        School school = schoolService.getSchooltBySchoolName(SchoolName);
//        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;

    }

    @RequestMapping(value = "getByActive")
    public List<School> getByActive() {
        List<School> activeSchoolsList = schoolService.getByActive();
        for (School s : activeSchoolsList) {
//            slackClient.sendMessage("is Active:"+s.getActive());


        }
        return activeSchoolsList;

    }

    @RequestMapping(value = "getByInActive")
    public List<School> getByInActive() {
        List<School> inActiveSchoolsList = schoolService.getByInActive();
        for (School s : inActiveSchoolsList) {
//            slackClient.sendMessage("in Active:"+s.getActive());

        }
        return inActiveSchoolsList;

    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public School getLatestRow() {
        School school = schoolService.getLatestRow();

//            slackClient.sendMessage("getLatestRow:"+school.getCreatedDate());

        return school;

    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public School getLatestUpdated() {
        School school = schoolService.getLatestUpdated();
//        slackClient.sendMessage("getLatestUpdated:"+school.getUpdatedDate());
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
        for (School s : schools) {
//            slackClient.sendMessage("getSchoolCreatedAfterDate:"+s.getCreatedDate());

        }
        return schools;
    }

    @RequestMapping(value = "getSchoolCreateddDate", method = RequestMethod.GET)
    public List<School> getSchoolCreateddDate(@RequestParam String createdDate) throws ParseException {
        List<School> schools = schoolService.getSchoolByCreatedDate(createdDate);
        for(School s :schools){
//            slackClient.sendMessage("getSchoolCreatedDate:"+s.getCreatedDate());
        }
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
//        for (School s :schoolList){
//            slackClient.sendMessage("getSchoolByNumberOfStudent:"+s.);
//
//        }
        return schoolList;
    }

}

