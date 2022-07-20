package com.coding.sp.Service;

import com.coding.sp.subject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public SubjectStudentDTO getAllSubject(){
//        return null;
        List<Subject> listOfClassDTOS = (List<Subject>) subjectRepository.findAll();
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
    public SubjectDTO viewEnrolledStudent(String subjectCode) throws Exception {
        return null;
    }

//    @Override
//    public SubjectDTO viewEnrolledStudent(String subjectCode) throws Exception {
//        return null;
//    }
}
