package com.example.week3day3hw.Controller;

import com.example.week3day3hw.Model.Api;
import com.example.week3day3hw.Service.StudentService;
import com.example.week3day3hw.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List> getStudent(){
        List<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }
    @PostMapping
    public ResponseEntity<Api> setStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new Api("New student added !",201));
    }
    @PutMapping("/{idd}")
    public ResponseEntity<Api> putStudent(@RequestBody @Valid Student student,@PathVariable Integer idd){
        studentService.putStudent(idd,student);
        return ResponseEntity.status(201).body(new Api("New student updated !",201));

    }
    @DeleteMapping("/{idd}")
    public ResponseEntity<Api> deleteStudent(@PathVariable @Valid Integer idd){
        studentService.deleteStudent(idd);
        return ResponseEntity.status(201).body(new Api("New student deleted !",201));

    }
    @GetMapping("/id/{id}")
    public ResponseEntity getStudentByID(@PathVariable @Valid Integer id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity getStudentByName(@PathVariable @Valid String name){
        Student student=studentService.findStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("major/{major}")
    public ResponseEntity getStudentsByMajor(@PathVariable @Valid String major){
        Student student= (Student) studentService.getStudentsByMajor(major);
        return ResponseEntity.status(200).body(student);

    }
    @GetMapping("/agee")
    public ResponseEntity<List> getStudentsByAge(@RequestBody Integer agee){
        List<Student> students= studentService.getStudentsByAge(agee);
        return ResponseEntity.status(200).body(students);
    }


}