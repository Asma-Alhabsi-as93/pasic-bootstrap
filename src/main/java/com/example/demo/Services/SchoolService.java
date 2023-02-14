package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class SchoolService {


      @Autowired
      SchoolRepository schoolRepository;

      public  List<School> getAllSchooles(){
      return schoolRepository.getAllSchooles();

  }


    public School getSchoolById(Integer schoolId){
        School school=  schoolRepository.getSchoolById(schoolId);
        return school;
    }

    public School getSchooltBySchoolName(String SchoolName){
        School school=  schoolRepository.getSchooltBySchoolName(SchoolName);
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

//    public School getLatestUpdated(){
//        School school=  schoolRepository.getLatestUpdated();
//        return school;
//    }
public void deleteSchoolById(Integer id) {
    School schoolToDelete = schoolRepository.findById(id).get();
    schoolRepository.delete(schoolToDelete);
}
}
