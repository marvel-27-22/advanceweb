package com.example.BITA75.service;
import com.example.BITA75.model.Course;
import java.util.List;
import java.util.Optional;
public interface CourseService {
    Course saveCourse(Course course);
    Optional<Course> getCourseByCode(String courseCode);
    List<Course> getAllCourses();
    void deleteCourse(String courseCode);
    List<Course> searchCoursesByKeyword(String keyword);
}