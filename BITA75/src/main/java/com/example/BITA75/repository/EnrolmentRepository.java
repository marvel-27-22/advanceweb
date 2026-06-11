package com.example.BITA75.repository;


import com.example.BITA75.model.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    List<Enrolment> findByStudentStudID(Long studID);
    List<Enrolment> findByCourseCourseCode(String courseCode);
}