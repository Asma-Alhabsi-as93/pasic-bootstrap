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
    @ManyToOne
     @JoinColumn(name = "school_id",referencedColumnName="id")
//    List<course>courses;

School school;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
