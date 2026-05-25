package com.example.BITA75;

import jakarta.persistence.*;

@Entity
public class Enrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studID", referencedColumnName = "studID")
    private Students student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseCode", referencedColumnName = "courseCode")
    private Course course;

    private int marks;

    public Enrolment() {
    }

    public Enrolment(Students student, Course course, int marks) {
        this.student = student;
        this.course = course;
        this.marks = marks;
    }


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