package com.example.studentgradespring.repository;

import com.example.studentgradespring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s1_0.studentId, s1_0.family, s1_0.name, s1_0.age, avg(((((((r1_0.physics + r1_0.mathematics) + r1_0.rus) " +
            "+ r1_0.literature) + r1_0.geometry) + r1_0.informatics)/6.0)) " +
            "from Student s1_0 " +
            "join Results r1_0 on s1_0.studentId = r1_0.student.studentId " +
            "where s1_0.group.groupId = :groupId " +
            "group by s1_0.studentId")
    List<Object[]> findAverageGradesByGroupId(@Param("groupId") Integer groupId);

    @Query("select max('student_id') from Student")
    Long getMaxId();
}
