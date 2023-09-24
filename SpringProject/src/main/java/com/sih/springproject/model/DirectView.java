package com.sih.springproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long directviewId;

    @Column
    private String problemStatement;

    @Column
    private String abstractData;

    @Column
    private String blockDiagram;

    @Column
    private String solution;

    @Column
    private String implementation;

    @Column
    private String sampleIO;

    @Column
    private String references;

    @Column
    private String conclusion;
}
