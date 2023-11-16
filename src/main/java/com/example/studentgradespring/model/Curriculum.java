package com.example.studentgradespring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curricula")
public class Curriculum {

    @Id
    @Column(name = "plan_id")
    private int planId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "subject_name")
    private String subjectName;

    // getters and setters
}