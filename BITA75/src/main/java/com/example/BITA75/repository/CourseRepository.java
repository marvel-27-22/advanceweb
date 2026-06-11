package com.example.BITA75.repository;

import com.example.BITA75.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findByCourseTitle(String keyword);
}