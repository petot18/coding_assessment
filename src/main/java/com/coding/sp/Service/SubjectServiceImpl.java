package com.coding.sp.Service;

import com.coding.sp.subject.Subject;
import com.coding.sp.subject.SubjectRepository;

public class SubjectServiceImpl {
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findALlSubject(){
//        return subjectRepository.findBySubjectCode(subject_code);
    }

}
