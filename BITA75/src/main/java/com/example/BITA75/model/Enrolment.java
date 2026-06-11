package com.example.BITA75.model;
import jakarta.persistence.*;
@Entity
public class Enrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "studID", referencedColumnName = "studID")
    private Students student;
    @ManyToOne
    @JoinColumn(name = "courseCode", referencedColumnName = "courseCode")
    private Course course;
    private int marks;
    // Default Constructor
    public Enrolment() {
    }
    // Parameterized Constructor
    public Enrolment(Long id, Students student, Course course, int marks) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.marks = marks;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Students getStudent() {
        return student;
    }
    public void setStudent(Students student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}