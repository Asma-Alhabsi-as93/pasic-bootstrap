package com.example.demo.Repositories;

import com.example.demo.Models.School;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchoolRepository extends CrudRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchooles();

    @Query(value = "SELECT s from School s where s.id =:schoolId")
    School getSchoolById(@Param("schoolId")Integer schoolId);

    @Query(value = "SELECT s from School s "+" where s.name =:schoolName")
    School getSchooltBySchoolName(@Param("schoolName")String schoolName);


    @Query(value = "SELECT s from School s where s.isActive = 1")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = 0")
    List<School> getAllInActiveSchools();
@Query(value ="SELECT s from School s where s.id=(SELECT max(s.id) from School s)")
    School getLatestRow();
//    @Query(value ="UPDATE s from School s where s.id=(UPDATE max(s.id) from School s)")
//    School getLatestUpdated();

}
    

