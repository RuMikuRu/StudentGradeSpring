package com.example.studentgradespring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;
}
