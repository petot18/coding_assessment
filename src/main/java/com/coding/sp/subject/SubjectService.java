package com.coding.sp.subject;


public interface SubjectService {

    SubjectStudentDTO getAllSubject() throws Exception;

//     ClassDTO viewEnrolledStudents(Long subjectCode) throws Exception;

    SubjectDTO viewEnrolledStudents(String subjectCode) throws Exception;


}
