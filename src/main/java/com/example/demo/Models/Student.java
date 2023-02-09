package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;


@Entity

public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
@Column(name = "student_name")
    String name;

    String rollNumber;
    List<course>courses;

    public List<course> getCourses() {
        return courses;
    }

    public void setCourses(List<course> courses) {
        this.courses = courses;
    }

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

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
