package com.coding.sp.student;

import com.coding.sp.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Student {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private long id;

    @Id
    private String studentId;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="subject_student",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_code")
    )
    private List<Subject> class_details = new ArrayList<>();


    public List<Subject> getClass_details() {
        return class_details;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
//    public String getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(String student_id) {
//        this.student_id = student_id;
//    }

    public void setClass_details(List<Subject> class_details) {
        this.class_details = class_details;
    }
}
