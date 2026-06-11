package com.example.BITA75.service.Imp;

import com.example.BITA75.model.Enrolment;
import com.example.BITA75.repository.EnrolmentRepository;
import com.example.BITA75.service.EnrolmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {
    private final EnrolmentRepository enrolmentRepository;
    public EnrolmentServiceImpl(
            EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }
    @Override
    public Enrolment saveEnrolment(
            Enrolment enrolment) {
        return enrolmentRepository.save(enrolment);
    }
    @Override
    public Optional<Enrolment> getEnrolmentById(Long id) {
        return enrolmentRepository.findById(id);
    }
    @Override
    public List<Enrolment> getAllEnrolments() {
        return enrolmentRepository.findAll();
    }
    @Override
    public void deleteEnrolment(Long id) {
        enrolmentRepository.deleteById(id);
    }
    @Override
    public List<Enrolment> getEnrolmentsByStudent(Long studID) {
        return enrolmentRepository.findByStudentStudID(studID);
    }
    @Override
    public List<Enrolment> getEnrolmentsByCourse(String courseCode) {
        return enrolmentRepository.findByCourseCourseCode(courseCode);
    }
}