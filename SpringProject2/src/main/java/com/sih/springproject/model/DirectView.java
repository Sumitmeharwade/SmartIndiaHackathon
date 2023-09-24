package com.sih.springproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DirectView extends Details{

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
