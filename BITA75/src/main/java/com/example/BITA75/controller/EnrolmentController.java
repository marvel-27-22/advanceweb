package com.example.BITA75.controller;

import com.example.BITA75.model.Enrolment;
import com.example.BITA75.service.EnrolmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {
    private final EnrolmentService enrolmentService;
    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }
    @PostMapping
    public ResponseEntity<Enrolment> saveEnrolment(@RequestBody Enrolment enrolment) {
        Enrolment savedEnrolment = enrolmentService.saveEnrolment(enrolment);
        return ResponseEntity.ok(savedEnrolment);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Enrolment> getEnrolmentById(@PathVariable Long id) {
        Optional<Enrolment> enrolment = enrolmentService.getEnrolmentById(id);
        return enrolment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Enrolment>> getAllEnrolments() {
        List<Enrolment> enrolments = enrolmentService.getAllEnrolments();
        return ResponseEntity.ok(enrolments);
    }
    @GetMapping("/student/{studID}")
    public ResponseEntity<List<Enrolment>> getEnrolmentsByStudent(
            @PathVariable Long studID) {
        List<Enrolment> enrolments =
                enrolmentService.getEnrolmentsByStudent(studID);
        return ResponseEntity.ok(enrolments);
    }
    @GetMapping("/course/{courseCode}")
    public ResponseEntity<List<Enrolment>> getEnrolmentsByCourse(
            @PathVariable String courseCode) {
        List<Enrolment> enrolments =
                enrolmentService.getEnrolmentsByCourse(courseCode);
        return ResponseEntity.ok(enrolments);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Enrolment> updateEnrolment(
            @PathVariable Long id,
            @RequestBody Enrolment updatedEnrolment) {
        Optional<Enrolment> existingEnrolment =
                enrolmentService.getEnrolmentById(id);
        if (existingEnrolment.isPresent()) {
            Enrolment enrolment = existingEnrolment.get();
            enrolment.setMarks(updatedEnrolment.getMarks());
            if (updatedEnrolment.getStudent() != null) {
                enrolment.setStudent(updatedEnrolment.getStudent());
            }
            if (updatedEnrolment.getCourse() != null) {
                enrolment.setCourse(updatedEnrolment.getCourse());
            }
            Enrolment savedEnrolment =
                    enrolmentService.saveEnrolment(enrolment);
            return ResponseEntity.ok(savedEnrolment);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrolment(@PathVariable Long id) {
        enrolmentService.deleteEnrolment(id);
        return ResponseEntity.noContent().build();
    }
}