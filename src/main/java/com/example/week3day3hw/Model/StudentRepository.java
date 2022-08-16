package com.example.week3day3hw.Model;

import com.example.week3day3hw.Student;
import com.example.week3day3hw.Teacher;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    List<Student> findAllByMajor(String major);
    List<Student> findByAgeGreaterThanEqual(Integer age);

}