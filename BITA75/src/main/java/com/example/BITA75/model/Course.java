package com.example.BITA75.model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private String semester;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Enrolment> enrolments;
    // Default Constructor
    public Course() {
    }
    // Parameterized Constructor
    public Course(String courseCode, String courseTitle,
                  String semester, Set<Enrolment> enrolments) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.semester = semester;
        this.enrolments = enrolments;
    }
    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public Set<Enrolment> getEnrolments() {
        return enrolments;
    }
    public void setEnrolments(Set<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
}