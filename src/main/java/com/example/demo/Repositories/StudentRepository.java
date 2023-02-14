package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

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
}