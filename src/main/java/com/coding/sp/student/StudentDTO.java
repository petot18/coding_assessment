package com.coding.sp.student;

import com.coding.sp.subject.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {
    private String student_id;

    private List<SubjectDTO> class_details;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public List<SubjectDTO> getClass_details() {
        return class_details;
    }

    public void setClass_details(List<SubjectDTO> class_details) {
        this.class_details = class_details;
    }
}
