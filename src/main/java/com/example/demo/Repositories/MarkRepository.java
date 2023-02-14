package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query(value = "SELECT s from Mark s")
    List<Mark> getAllMarks();


    @Query(value = "SELECT s from Mark s where s.id =:markId")
    Mark getMarkById(@Param("markId")Integer markId);

    @Query(value = "SELECT s from Mark s where s.isActive = 1")
    List<Mark> getByActive();

    @Query(value = "SELECT s from Mark s where s.isActive = 0")
    List<Mark> getByInActive();

}
