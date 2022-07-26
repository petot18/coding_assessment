package com.coding.sp.student;

import com.coding.sp.subject.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StudentDTO {
    private String studentId;

    private List<SubjectDTO> class_details;

    public String getStudentId() {
        return studentId;
    }

    public void setStudent_id(String student_id) {
        this.studentId = studentId;
    }

    public List<SubjectDTO> getClass_details() {
        return class_details;
    }

    public void setClass_details(List<SubjectDTO> class_details) {
        this.class_details = class_details;
    }
}
