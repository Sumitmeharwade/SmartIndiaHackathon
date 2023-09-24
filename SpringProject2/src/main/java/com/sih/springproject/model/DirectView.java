package com.sih.springproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectView{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long directViewID;
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
    private String conclusion;

}
