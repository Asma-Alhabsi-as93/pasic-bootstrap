package com.example.demo.Repositories;

import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s from Student s")
    List<Student> getAllStudents();

    @Query(value = "SELECT s from Student s where s.id =:studentId")
    Student getStudentById(@Param("studentId") Integer studentId);

    @Query(value = "SELECT st from Student st " + " WHERE st.school.id =id")
    List<Student> getStudentBySchoolId(@Param("id") Integer id);
    @Query(value = "SELECT s from Student s where s.isActive = 1")
    List<Student> getByActive();
    @Query(value = "SELECT s from Student s where s.isActive = 0")
    List<Student> getByInActive();

    @Query(value = "SELECT s from Student s "+" where s.name =:studentName")
    Student getStudenttByName(@Param("studentName")String studentName);

    @Query(value ="SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
    Student getLatestRow();

    @Query(value ="SELECT s from Student s where s.updatedDate = (SELECT max(s.updatedDate) from Student s)")
    Student getLatestUpdated();

    @Query(value ="SELECT s from Student s where s.createdDate > : createdDate")
    List<Student> getStudentCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value ="SELECT s from Student s where s.createdDate = :createdDate")
    List<Student> getStudentCreateddDate(@Param("createdDate")Date createdDate);

    @Query(value ="SELECT s from Student s where s.updatedDate = :updatedDate")
    List<Student> getStudentUpdatedDate(@Param("updatedDate")Date updatedDate);


    @Query(value = "SELECT distinct (id) from Student" , nativeQuery = true )
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "SELECT COUNT (id) from Student where id =?1",nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);

}