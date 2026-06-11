package com.example.BITA75.service;

import com.example.BITA75.model.Enrolment;
import java.util.List;
import java.util.Optional;

public interface EnrolmentService {
    Enrolment saveEnrolment(Enrolment enrolment);
    Optional<Enrolment> getEnrolmentById(Long id);
    List<Enrolment> getAllEnrolments();
    void deleteEnrolment(Long id);
    List<Enrolment> getEnrolmentsByStudent(Long studID);
    List<Enrolment> getEnrolmentsByCourse(String courseCode);
}