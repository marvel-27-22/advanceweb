package com.example.BITA75.controller;

import com.example.BITA75.model.Course;
import com.example.BITA75.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }
    @GetMapping("/{courseCode}")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String courseCode) {
        Optional<Course> course = courseService.getCourseByCode(courseCode);
        return course.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(@RequestParam String keyword) {
        List<Course> courses = courseService.searchCoursesByKeyword(keyword);
        return ResponseEntity.ok(courses);
    }
    @PutMapping("/{courseCode}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable String courseCode,
            @RequestBody Course updatedCourse) {
        Optional<Course> existingCourse = courseService.getCourseByCode(courseCode);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setCourseTitle(updatedCourse.getCourseTitle());
            course.setSemester(updatedCourse.getSemester());
            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{courseCode}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseCode) {
        courseService.deleteCourse(courseCode);
        return ResponseEntity.noContent().build();
    }
}