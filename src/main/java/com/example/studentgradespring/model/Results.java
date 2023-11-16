package com.example.studentgradespring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "results")
public class Results implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "physics")
    private Integer physics;

    @Column(name = "mathematics")
    private Integer mathematics;

    @Column(name = "rus")
    private Integer rus;

    @Column(name = "literature")
    private Integer literature;

    @Column(name = "geometry")
    private Integer geometry;

    @Column(name = "informatics")
    private Integer informatics;

}
