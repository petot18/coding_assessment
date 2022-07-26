package com.coding.sp.subject;

import com.coding.sp.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectStudentRepository extends JpaRepository<Subject, String> {

    Subject findBySubjectCode(String subjectCode);

    Optional<Subject> findById(String subjectCode);
}
