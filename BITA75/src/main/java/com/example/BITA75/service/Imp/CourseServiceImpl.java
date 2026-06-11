package com.example.BITA75.service.Imp; // 1. Fixed case sensitivity (service instead of Service)

import com.example.BITA75.model.Course;
import com.example.BITA75.repository.CourseRepository;
import com.example.BITA75.service.CourseService; // 2. Fixed case sensitivity here too

import org.springframework.stereotype.Service;
import java.util.List;     // 3. Added missing import
import java.util.Optional; // 4. Added missing import

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseByCode(String courseCode) {
        return courseRepository.findById(courseCode);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(String courseCode) {
        courseRepository.deleteById(courseCode);
    }

    @Override
    public List<Course> searchCoursesByKeyword(String keyword) {
        return courseRepository.findByCourseTitle(keyword);
    }
}