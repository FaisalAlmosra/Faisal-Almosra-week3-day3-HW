package com.example.week3day3hw.Controller;
import com.example.week3day3hw.Model.Api;
import com.example.week3day3hw.Service.TeacherService;
import com.example.week3day3hw.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<Teacher> teachers=teacherService.getStudent();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping
    public ResponseEntity<Api> setTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new Api("New teacher added !",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Api> putTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherService.putTeacher(id,teacher);
        return ResponseEntity.status(201).body(new Api("New teacher updated !",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Api> deleteTeacher(@PathVariable @Valid Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new Api("New teacher deleted !",201));

    }
    // get by teacher by id
    @GetMapping("/search/{id}")
    public ResponseEntity getTeacherByID(@PathVariable @Valid Integer id){
        Teacher teacher=teacherService.findTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/salary")
    public ResponseEntity<List> getTeachersBySalary(@RequestBody Integer salary){
        List<Teacher> teachers= teacherService.getTeachersBySalary(salary);
        return ResponseEntity.status(200).body(teachers);
    }
}
