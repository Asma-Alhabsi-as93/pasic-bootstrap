package com.example.demo.Repositories;

import com.example.demo.Models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id =:schoolId")
    School getSchoolById(@Param("schoolId")Integer schoolId);

    @Query(value = "SELECT s from School s "+" where s.name =:schoolName")
    School getSchoolBySchoolName(@Param("schoolName")String schoolName);


    @Query(value = "SELECT s from School s where s.isActive = 1")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = 0")
    List<School> getAllInActiveSchools();
@Query(value ="SELECT s from School s where s.id=(SELECT max(s.id) from School s)")
    School getLatestRow();

    @Query(value ="SELECT s from School s where s.updatedDate = (SELECT max(s.updatedDate) from School s)")
    School getLatestUpdated();

    @Query(value ="SELECT s from School s where s.createdDate > :createdDate")
    List<School> getSchoolCreatedAfterDate(@Param("createdDate")Date createdDate);



    @Query(value ="SELECT s from School s where s.createdDate = :createdDate")
    List<School> getSchoolCreatedDate(@Param("createdDate")Date createdDate);

    @Query(value ="SELECT s from School s where s.updatedDate = :updatedDate")
    List<School> getSchoolUpdatedDate(@Param("updatedDate")Date updatedDate);

    @Query(value = "SELECT s from School s WHERE s.updatedDate > :updatedDate")
    Iterable<School> findByUpdatedDate(@Param("updatedDate")Date updatedDate);

//   @Query(value = "SELECT s from School s WHERE s.name = :name")
//   Iterable<School> deleteBySchoolName(@Param("name")String name);

    @Query(value = "SELECT distinct (id) from School" , nativeQuery = true )
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "SELECT COUNT (id) from Schiil where id =?1",nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);
}

    

