package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional< Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long studentId, Student studentInfo) {
        studentRepository.findById(studentId).ifPresent(student -> {
            student.setEmail(studentInfo.getEmail());

            studentRepository.save(student);
        });
    }

    public void removeStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student not found");
        } else {
            studentRepository.deleteById(studentId);
        }
    }
}
