package com.coding.sp.Service;


import com.coding.sp.student.Student;
import com.coding.sp.subject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectStudentRepository subjectStudentRepository;



    @Override
    public SubjectStudentDTO getAllSubject(){
//        return null;
        List<Subject> listOfClassDTOS = (List<Subject>) subjectStudentRepository.findAll();
        List<SubjectDTO> sam = new ArrayList<>();
        SubjectStudentDTO studentDTO = new SubjectStudentDTO();
        for (Subject ff : listOfClassDTOS){
            SubjectDTO clsDTO = new SubjectDTO();
            clsDTO.setSubject_code(ff.getSubjectCode());
            clsDTO.setSubject_desc(ff.getSubject_desc());
            sam.add(clsDTO);
        }
        studentDTO.setSubjects(sam);

        return studentDTO;
    }

    @Override
    public SubjectDTO viewEnrolledStudents(String subject_code) throws Exception {
//        return null;
        System.out.print("Success");
        Optional<Subject> listOfUniqueStudentIds = subjectStudentRepository.findById(subject_code);
        Subject cls = new Subject();
        SubjectDTO subjectDTO = new SubjectDTO();
        List<SubjectStudentDTO> studentDTO = new ArrayList<>();

        if (listOfUniqueStudentIds.isPresent()) cls = listOfUniqueStudentIds.get();
        else throw new Exception("Class ID " + subject_code +" not found!");

        for (Student std : cls.getListOfStudents()){
            SubjectStudentDTO studentDTO1 = new SubjectStudentDTO();
            studentDTO1.setStudent_id(std.getStudent_id());
            studentDTO.add(studentDTO1);
        }

        subjectDTO.setSubject_code(cls.getSubjectCode());
        subjectDTO.setSubject_desc(cls.getSubject_desc());
        subjectDTO.setStudent_ids(studentDTO);

        return subjectDTO;
    }


}
