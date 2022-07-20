package com.coding.sp.subject;


public interface SubjectService {

    SubjectStudentDTO getAllSubject() throws Exception;
    SubjectDTO viewEnrolledStudent(String subjectCode) throws Exception;

}
