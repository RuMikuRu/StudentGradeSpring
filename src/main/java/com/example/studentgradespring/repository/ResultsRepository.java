package com.example.studentgradespring.repository;

import com.example.studentgradespring.model.Results;
import com.example.studentgradespring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultsRepository extends JpaRepository<Results, Long> {
    List<Results> findByStudent(Student student);
}
