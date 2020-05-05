package com.example.portfolio.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
public class Evaluations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String evaluation;

    @Column(nullable = false)
    private LocalDate createDate;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Templates templates;

    @ManyToOne
    private Coach coach;

    @ManyToOne
    private Classes classes;

}
