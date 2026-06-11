package com.example.BITA75.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studID;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String stuAddress;
    private int stuYear;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Enrolment> enrolments;
    public Students() {
    }
    public Students(Long studID, String firstName, String lastName,
                   LocalDate birthDate, String stuAddress,
                   int stuYear, Set<Enrolment> enrolments) {
        this.studID = studID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.stuAddress = stuAddress;
        this.stuYear = stuYear;
        this.enrolments = enrolments;
    }
    public Long getStudID() {
        return studID;
    }
    public void setStudID(Long studID) {
        this.studID = studID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getStuAddress() {
        return stuAddress;
    }
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
    public int getStuYear() {
        return stuYear;
    }
    public void setStuYear(int stuYear) {
        this.stuYear = stuYear;
    }
    public Set<Enrolment> getEnrolments() {
        return enrolments;
    }
    public void setEnrolments(Set<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
}