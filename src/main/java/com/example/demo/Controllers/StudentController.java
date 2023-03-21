package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.SchoolService;
import com.example.demo.Services.StudentService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    SlackClient slackClient;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Student> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        for (Student s : students) {
            slackClient.sendMessage("Student name:"+s.getName());
            slackClient.sendMessage("Student_id:"+s.getId());
            slackClient.sendMessage("Student_Active:"+s.getActive());
            slackClient.sendMessage("Student_RollNumber:"+s.getRollNumber());
            slackClient.sendMessage("Student_UpdateDate:"+s.getCreatedDate());
            slackClient.sendMessage("Student_UpdateDate:"+s.getUpdatedDate());

        }
        return students;

    }

    @GetMapping(value = "addStudent")
    public void addStudent() {
        studentService.addStudent();
        studentService.addStudent();
    }

    @GetMapping(value = "deleteById")
    public String deleteStudentById(@RequestParam Integer id) {

        studentService.deleteStudentById(id);
        return "Record Deleted Successfully :)";
    }

    @GetMapping(value = "student")
    public String helloStudent() {
        return "Hello Student";
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }



    @RequestMapping(value = "getByActive")
    public List<Student> getByActive() {
        List<Student> activeStudentList = studentService.getByActive();
        return activeStudentList;

    }

    @RequestMapping(value = "getByInActive")
    public List<Student> getByInActive() {
        List<Student> InActiveStudentList = studentService.getByInActive();
        return InActiveStudentList;

    }

    @RequestMapping(value = "getByStudentName", method = RequestMethod.GET)
    public Student getStudenttByName(@RequestParam String StudentName) {
        Student student = studentService.getStudenttByName(StudentName);
        return student;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        return student;
    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public Student getLatestUpdated() {
        Student student = studentService.getLatestUpdated();
        return student;

    }

    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> students = studentService.getStudentCreatedAfterDate(createdDate);
        return students;

    }

    @RequestMapping(value = "getStudentCreateddDate", method = RequestMethod.GET)
    public List<Student> getStudentByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Student> students=studentService.getStudentCreateddDate(createdDate);
        return students;

    }
    @RequestMapping(value = "getStudentUpdatedDate" ,method = RequestMethod.GET)
    public List<Student> getStudentUpdatedDate(@RequestParam String updateDate ) throws ParseException {
        List<Student> students = studentService.getStudentUpdatedDate(updateDate);
        return students;

    }

    @GetMapping(value = "deleteAll")
    public void deleteAll() {
        studentService.deleteAll();

    }

    @RequestMapping(value = "deleteAllStudentUpdatedDate", method = RequestMethod.GET)
    public void findByUpdatedDate(Date updatedDate) {

        studentService.findByUpdatedDate(updatedDate);
    }

    @RequestMapping(value = "deleteAllStudentCreatedAfterDate", method = RequestMethod.GET)
    public void deleteAllStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        studentService.deleteAllStudentCreatedAfterDate(createdDate);

    }

    @RequestMapping(value = "deleteStudentlByCreatedDate", method = RequestMethod.POST)
    public void deleteStudentlByCreatedDate(@RequestParam String createdDate) throws ParseException {
        studentService.deleteStudentlByCreatedDate(createdDate);
    }

    @RequestMapping(value = "deleteStudentByUpdateDate", method = RequestMethod.POST)
    public void deleteStudentByUpdateDate(@RequestParam String updatedDate) throws ParseException {
        studentService.deleteStudentByUpdateDate(updatedDate);
    }

//    @RequestMapping(value = "getStudentsBySchoolId", method = RequestMethod.GET)
//    public List<Student> getStudentBySchoolId(@RequestParam Integer schoolId) {
//        List<Student> studentList = studentService.getStudentBySchoolId(schoolId);
//        return studentList;
//    }

    @RequestMapping(value = "Student/getBySchoolName", method = RequestMethod.GET)
    public List <Student> getStudentBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentBySchoolName(schoolName);
    }

}