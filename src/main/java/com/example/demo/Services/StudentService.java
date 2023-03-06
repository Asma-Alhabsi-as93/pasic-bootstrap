package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolRepository schoolRepository;
    public void addStudent() {
        Student student = new Student();
        student.setName("Muzzamil Arif");
        student.setRollNumber("1");
        studentRepository.save(student);

    }

    public void deleteStudentById(Integer id) {
        Student studentToDelete = studentRepository.findById(id).get();
        studentRepository.delete(studentToDelete);
    }

    public List<Student>getAllStudents(){

        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Integer studentId){
        Student student=  studentRepository.getStudentById(studentId);
        return student;
    }
    public List<Student>getStudentBySchoolName(String schoolName){
    School school=schoolRepository.getSchoolBySchoolName(schoolName);
    Integer schoolId=school.getId();
    List<Student>studentList=studentRepository.getStudentBySchoolId(schoolId);
    return  studentList;
    }
    public List<Student> getByActive(){
    return studentRepository.getByActive();

    }
    public List<Student> getByInActive(){
        return studentRepository.getByInActive();

    }
    public Student getStudenttByName(String StudentName){
        Student student=  studentRepository.getStudenttByName(StudentName);
        return student;
    }

    public Student getLatestRow(){
        Student student=  studentRepository.getLatestRow();
        return student;
    }

    public Student getLatestUpdated(){
        Student student=  studentRepository.getLatestUpdated();
        return student;
    }

    public List<Student> getStudentCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<Student>students = studentRepository.getStudentCreatedAfterDate(convertedDateFromStringToDateFormat);
        return students;
    }

}
