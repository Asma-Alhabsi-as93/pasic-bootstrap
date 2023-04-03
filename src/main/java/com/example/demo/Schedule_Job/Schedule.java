package com.example.demo.Schedule_Job;


import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Models.course;
import com.example.demo.Services.CourseService;
import com.example.demo.Services.MarkService;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    MarkService markService;

        @Scheduled(cron = "0 0/15 * * * *")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<School> getAllSchool() {

        List<School> schools = schoolService.getAllSchooles();
        for (School s : schools) {
            slackClient.sendMessage("school name:"+s.getName());
            slackClient.sendMessage("school_id:"+s.getId());
            slackClient.sendMessage("school_Active:"+s.getActive());
            slackClient.sendMessage("school_CraeteDate:"+s.getCreatedDate());
            slackClient.sendMessage("school_UpdateDate:"+s.getUpdatedDate());

        }
        return schools;
    }

    @Scheduled(cron = "0 0/15 * * * *")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Student> getAllStudent() {

        List<Student> students = studentService.getAllStudents();
        for (Student s : students) {
            slackClient.sendMessage("Student name:" + s.getName());
            slackClient.sendMessage("Student_id:" + s.getId());
            slackClient.sendMessage("Student_Active:" + s.getActive());
            slackClient.sendMessage("Student_RollNumber:" + s.getRollNumber());
            slackClient.sendMessage("Student_CreateDate:" + s.getCreatedDate());
            slackClient.sendMessage("Student_UpdateDate:" + s.getUpdatedDate());

        }
        return students;
    }

    @Scheduled(cron = "0 0/15 * * * *")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<course> getAllCourse() {

        List<course> course = courseService.getAllCourse();
        for (course s : course) {
            slackClient.sendMessage("Course name:" + s.getName());
            slackClient.sendMessage("Course id:" + s.getId());
            slackClient.sendMessage("Course Active:" + s.getActive());
            slackClient.sendMessage("Student:" + s.getStudent());
            slackClient.sendMessage("Course CreateDate:" + s.getCreatedDate());
            slackClient.sendMessage("Course UpdateDate:" + s.getUpdatedDate());

        }
        return course;
    }
    @Scheduled(cron = "0 0/15 * * * *")
    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)

    public List<Mark> getAllMark() {

        List<Mark> marks = markService.gettAllMarks();
        for (Mark s : marks) {
            slackClient.sendMessage("Mark id:" + s.getId());
            slackClient.sendMessage("Mark Grade:" + s.getGrade());
            slackClient.sendMessage("Mark ObtainedMarks:" + s.getObtainedMarks());
            slackClient.sendMessage("Mark Active:" + s.getActive());
            slackClient.sendMessage("Mark CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("Mark UpdatedDate:" + s.getUpdatedDate());
        }
        return marks;
    }
//    @Scheduled(cron = "0 0/1 * * * *")
//    @RequestMapping(value = "getById", method = RequestMethod.GET)
//    public School getSchoolById(@RequestParam Integer schoolId) {
//        School school = schoolService.getSchoolById(schoolId);
//        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
//        return school;
//    }
}