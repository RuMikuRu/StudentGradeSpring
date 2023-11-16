package com.example.studentgradespring.service;

import com.example.studentgradespring.model.Results;
import com.example.studentgradespring.model.Student;

import java.util.List;

public interface StudentService {
    List<Object[]> getAverageGradesOfStudents(Integer groupId);

    void saveStudent(Student student);

    void updateStudentGrades(Long resultId, Results results);
}
