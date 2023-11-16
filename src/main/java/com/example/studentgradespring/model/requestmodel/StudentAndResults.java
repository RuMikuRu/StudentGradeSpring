package com.example.studentgradespring.model.requestmodel;

import com.example.studentgradespring.model.Results;
import com.example.studentgradespring.model.Student;
import lombok.Data;

@Data
public class StudentAndResults {
    Student student;
    Results results;
}
