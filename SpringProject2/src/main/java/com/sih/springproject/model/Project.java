package com.sih.springproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long projectId;
    @Column
    private String title;

    @ManyToMany
    private List<User> collaborators;

    @OneToMany
    private List<Comment> commentList;

    @OneToMany
    private List<Rating> ratingList;

    @OneToMany
    private List<Links> links;

}

