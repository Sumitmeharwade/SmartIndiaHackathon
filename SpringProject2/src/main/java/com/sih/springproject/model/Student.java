package com.sih.springproject.model;

import jakarta.persistence.*;

public class Student extends User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long studentId;
    @ManyToOne
    private University university;
}
