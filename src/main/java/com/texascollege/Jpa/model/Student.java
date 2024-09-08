package com.texascollege.Jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
//@Table(name="T_student")

public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    //    @Column( name ="c_fname",//            length=25
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;
    private Integer age;

    @OneToOne
            ( mappedBy = "student",
            cascade=CascadeType.ALL)
    private StudentProfile studentProfile;
    @JsonBackReference //student object doesnot need to serialize the parent which is in school

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @ManyToOne
    @JoinColumn(
            name="school_id"
    )
    private School school;

    public Student(Integer id, String firstname, String lastname, String email, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Student() {
    }
}

