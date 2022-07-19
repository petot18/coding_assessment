package com.coding.sp.subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    Subject findBySubjectCode(String subject_code);
}
