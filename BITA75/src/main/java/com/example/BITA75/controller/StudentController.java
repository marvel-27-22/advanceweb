package com.example.BITA75.controller;

import com.example.BITA75.model.Students;
import com.example.BITA75.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Students> saveStudent(@RequestBody Students student) {
        Students savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(
            @PathVariable Long id) {
        Optional<Students> student =
                studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students =
                studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}