package com.example.week3day3hw.Model;

import com.example.week3day3hw.Student;
import com.example.week3day3hw.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    List<Teacher> findBySalaryGreaterThanEqual(Integer salary);


}