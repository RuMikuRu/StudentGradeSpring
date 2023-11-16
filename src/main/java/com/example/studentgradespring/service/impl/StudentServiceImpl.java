package com.example.studentgradespring.service.impl;

import com.example.studentgradespring.model.Results;
import com.example.studentgradespring.model.Student;
import com.example.studentgradespring.repository.ResultsRepository;
import com.example.studentgradespring.repository.StudentRepository;
import com.example.studentgradespring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ResultsRepository resultsRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ResultsRepository resultsRepository) {
        this.studentRepository = studentRepository;
        this.resultsRepository = resultsRepository;
    }

    @Override
    public List<Object[]> getAverageGradesOfStudents(Integer groupId) {
        return studentRepository.findAverageGradesByGroupId(groupId);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudentGrades(Long resultId, Results newResult) {
        resultsRepository.findById(resultId)
                .map(result -> {
                    if(newResult.getPhysics() != null) result.setPhysics(newResult.getPhysics());
                    if(newResult.getMathematics() != null) result.setMathematics(newResult.getMathematics());
                    if(newResult.getRus() != null) result.setRus(newResult.getRus());
                    if(newResult.getLiterature() != null) result.setLiterature(newResult.getLiterature());
                    if(newResult.getGeometry() != null) result.setGeometry(newResult.getGeometry());
                    if(newResult.getInformatics() != null) result.setInformatics(newResult.getInformatics());
                    return ResponseEntity.ok().body(resultsRepository.save(result));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
