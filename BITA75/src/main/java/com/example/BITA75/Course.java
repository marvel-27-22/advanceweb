package com.example.BITA75;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private String courseCode;

    private String courseTitle;
    private String semester;
     @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrolment> enrolments = new HashSet<>();

    public Course() {
    }


    public Course(String courseCode, String courseTitle, String semester) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.semester = semester;
    }

    public void addEnrolment(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.setCourse(this);
    }

    public void removeEnrolment(Enrolment enrolment) {
        enrolments.remove(enrolment);
        enrolment.setCourse(null);
    }


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