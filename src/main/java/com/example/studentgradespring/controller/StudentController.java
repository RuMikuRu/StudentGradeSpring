package com.example.studentgradespring.controller;

import com.example.studentgradespring.model.Results;
import com.example.studentgradespring.model.Student;
import com.example.studentgradespring.model.requestmodel.StudentAndResults;
import com.example.studentgradespring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final
    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("{group}")
    public ResponseEntity<List<Object[]>> getAverangeByIdGroup(@PathVariable("group") Integer group) {
        List<Object[]> averages = service.getAverageGradesOfStudents(group);
        return new ResponseEntity<>(averages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudentWithResults(@RequestBody Student newStudent) {
        service.saveStudent(newStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/results/{resultId}")
    public ResponseEntity<Results> updateResultGrades(@RequestBody Results results,
                                                      @PathVariable("resultId") Long resultId) {
        System.out.println(results.toString());
        service.updateStudentGrades(resultId, results);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
