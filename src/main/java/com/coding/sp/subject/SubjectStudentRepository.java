package com.coding.sp.subject;

import com.coding.sp.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectStudentRepository extends CrudRepository<Subject, Long> {

    Subject findBySubjectCode(String subject_code);

    Optional<Subject> findById(String subject_code);
//    Optional<Subject> findById(String subject_code);
}
