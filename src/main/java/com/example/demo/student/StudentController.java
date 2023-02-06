package com.example.demo.student;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student studentInfo) {
        studentService.updateStudent(studentId, studentInfo);
    }

    @DeleteMapping(path ="{studentId}")
    public void removeStudent(@PathVariable("studentId") Long studentId) {
        studentService.removeStudent(studentId);
    }

}
