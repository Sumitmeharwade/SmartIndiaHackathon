package com.sih.springproject.model;

import jakarta.persistence.*;

import java.util.List;

public class University extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long universityId;

    @OneToMany
    private List<Student> students;

}
