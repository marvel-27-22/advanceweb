package com.example.BITA75.service;
import com.example.BITA75.model.Students;
import java.util.List;
import java.util.Optional;
public interface StudentService {
    Students saveStudent(Students student);
    Optional<Students> getStudentById(Long id);
    List<Students> getAllStudents();
    void deleteStudent(Long id);
}