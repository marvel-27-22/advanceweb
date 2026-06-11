package com.example.BITA75.service.Imp;

import com.example.BITA75.model.Students;
import com.example.BITA75.repository.StudentRepository;
import com.example.BITA75.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Students saveStudent(Students student) {
        return studentRepository.save(student);
    }
    @Override
    public Optional<Students> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
