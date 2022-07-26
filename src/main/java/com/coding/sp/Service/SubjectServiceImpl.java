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
            clsDTO.setSubjectCode(ff.getSubjectCode());
            clsDTO.setSubjectDesc(ff.getSubjectDesc());
            sam.add(clsDTO);
        }
        studentDTO.setSubjects(sam);

        return studentDTO;
    }

    @Override
    public SubjectDTO viewEnrolledStudents(String subjectCode) throws Exception {
//        return null;
        System.out.print("Success");
        Optional<Subject> listOfUniqueStudentIds = subjectStudentRepository.findById(subjectCode);
        Subject cls = new Subject();
        SubjectDTO subjectDTO = new SubjectDTO();
        List<SubjectStudentDTO> studentDTO = new ArrayList<>();

        if (listOfUniqueStudentIds.isPresent()) cls = listOfUniqueStudentIds.get();
        else throw new Exception("Class ID " + subjectCode +" not found!");

        for (Student std : cls.getListOfStudents()){
            SubjectStudentDTO studentDTO1 = new SubjectStudentDTO();
            studentDTO1.setStudent_id(std.getStudentId());
            studentDTO.add(studentDTO1);
        }

        subjectDTO.setSubjectCode(cls.getSubjectCode());
        subjectDTO.setSubjectDesc(cls.getSubjectDesc());
        subjectDTO.setStudent_ids(studentDTO);

        return subjectDTO;
    }


}
