package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

   @Column(name = "school_name")
    String name;
   
    List<Student>students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
