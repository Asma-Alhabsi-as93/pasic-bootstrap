package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public  class SchoolService {


      @Autowired
      SchoolRepository schoolRepository;

      public  List<School> getAllSchooles(){
      return schoolRepository.getAllSchools();

  }


    public School getSchoolById(Integer schoolId){
        School school=  schoolRepository.getSchoolById(schoolId);
        return school;
    }

    public School getSchooltBySchoolName(String SchoolName){
        School school=  schoolRepository.getSchoolBySchoolName(SchoolName);
        return school;
    }
    public List<School> getByActive(){
        return schoolRepository.getAllActiveSchools();

      }
    public List<School> getByInActive(){
        return schoolRepository.getAllInActiveSchools();

    }

    public School getLatestRow(){
        School school=  schoolRepository.getLatestRow();
        return school;
    }

    public School getLatestUpdated(){
       School school=  schoolRepository.getLatestUpdated();
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
        List<School>schools = schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return schools;
    }



    public List<School> getSchoolCreateddDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School>schools = schoolRepository.getSchoolCreatedDate(convertedDateFromStringToDateFormat);
        return schools;
      }
    public List<School> getSchoolUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<School>schools = schoolRepository.getSchoolUpdatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    public void deleteAll() {
     Iterable<School> school = schoolRepository.findAll();
       for (School school1:school){
           school1.setActive(false);
       }
       schoolRepository.saveAll(school);
    }

}
