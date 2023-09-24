package com.sih.springproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long userId;

    @Column
    protected String name;

    @Column
    protected String email;
    @Column
    protected String username;

    @Column
    protected String phonenumber;

    @Column
    protected String password;

    @Column
    protected String bio;

    @Column
    private String role;
}
