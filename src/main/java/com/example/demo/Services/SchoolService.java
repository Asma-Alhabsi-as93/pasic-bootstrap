package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public  class SchoolService {


    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;
    public List<School> getAllSchooles() {
        return schoolRepository.getAllSchools();

    }


    public School getSchoolById(Integer schoolId) {
        School school = schoolRepository.getSchoolById(schoolId);
        return school;
    }

    public School getSchooltBySchoolName(String SchoolName) {
        School school = schoolRepository.getSchoolBySchoolName(SchoolName);
        return school;
    }

    public List<School> getByActive() {
        return schoolRepository.getAllActiveSchools();

    }

    public List<School> getByInActive() {
        return schoolRepository.getAllInActiveSchools();

    }

    public School getLatestRow() {
        School school = schoolRepository.getLatestRow();
        return school;
    }

    public School getLatestUpdated() {
        School school = schoolRepository.getLatestUpdated();
        return school;
    }

    public void deleteSchoolById(Integer id) {
        School schoolToDelete = schoolRepository.findById(id).get();
        schoolToDelete.setActive(false);
        schoolRepository.save(schoolToDelete);
    }

    public void setCreatedDateByUserInput(String stringdate, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(stringdate);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }

    public List<School> getSchoolCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> schools = schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return schools;
    }


    public List<School> getSchoolByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> schools = schoolRepository.getSchoolCreatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    public List<School> getSchoolUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> schools = schoolRepository.getSchoolUpdatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    public void deleteAll() {
        Iterable<School> school = schoolRepository.findAll();
        for (School school1 : school) {
            school1.setActive(false);
        }
        schoolRepository.saveAll(school);
    }


    public void findByUpdatedDate(Date updatedDate) {
        Iterable<School> school = schoolRepository.findByUpdatedDate(updatedDate);
        for (School school1 : school) {
            school1.setActive(false);
        }
        schoolRepository.saveAll(school);
    }

//    public void deleteBySchoolName(String name) {
//        School schoolToDelete = schoolRepository.deleteBySchoolName(name);
//        schoolToDelete.setActive(false);
//        schoolRepository.save(schoolToDelete);
//    }

    public void deleteAllSchoolsCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> school = schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        school.stream().forEach(s -> s.setActive(false));
        schoolRepository.saveAll(school);
    }

    public void deleteSchoolByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> schools = schoolRepository.getSchoolCreatedDate(convertedDateFromStringToDateFormat);
        schools.stream().forEach(s -> s.setActive(false));
        schoolRepository.saveAll(schools);
    }

    public void deleteSchoolByUpdateDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School> schools = (List<School>) schoolRepository.findByUpdatedDate(convertedDateFromStringToDateFormat);
        schools.stream().forEach(s -> s.setActive(false));
        schoolRepository.saveAll(schools);
    }

    public List<School> getSchoolByNumberOfStudent(Integer numberOfStudent  ) {
        List<Integer> typesOfSchoolIdsInStudent = studentRepository.getDistinctSchoolIdsFromStudent();

        List<Integer> schoolIdThatUserWants = new ArrayList<>();

        for (Integer idOfSchool : typesOfSchoolIdsInStudent) {
            Integer count = studentRepository.getCountOfStudentsBySchoolId(idOfSchool);
            if (numberOfStudent == count) {
                schoolIdThatUserWants.add(idOfSchool) ;
            }
        }

       List<School> schoolThatUserWasLookingFor = schoolRepository.findAllById(schoolIdThatUserWants);
        return schoolThatUserWasLookingFor;
    }
    public StringBuilder formatSchoolObjectForSlack(School school){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + school.getId() + "*\n");
        sb.append("School Name: *" + school.getName() + "*\n");
        sb.append("Is Active: *" + school.getActive() + "*\n");
        return sb;
    }

    public StringBuilder formatSchoolListForSlack(List<School> schools){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (School schoolFromListOfSchools: schools) {
            mainStringBuilder.append(formatSchoolObjectForSlack(schoolFromListOfSchools));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }
}
