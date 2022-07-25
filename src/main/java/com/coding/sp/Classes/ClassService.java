package com.coding.sp.Classes;

import com.coding.sp.subject.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassService {
    SubjectDTO view (String id) throws Exception;

    List<SubjectDTO> list();

    SubjectDTO create(SubjectDTO classDTO) throws Exception;

    SubjectDTO update(SubjectDTO classDTO) throws Exception;

    void delete(String id) throws Exception;
}
