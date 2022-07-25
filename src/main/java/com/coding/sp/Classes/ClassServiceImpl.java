package com.coding.sp.Classes;

import com.coding.sp.subject.SubjectDTO;
import com.coding.sp.subject.SubjectService;
import com.coding.sp.subject.SubjectStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    SubjectStudentRepository subjectStudentRepository;

    @Override
    public SubjectDTO view(String id) throws Exception {
        var cls = subjectStudentRepository.findById(id)
                .orElseThrow(() -> new Exception("Class does not exist!"));

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setSubject_code(cls.getSubjectCode());
        subjectDTO.setSubject_desc(cls.getSubject_desc());
        subjectDTO.setWeek_start_date(cls.getWeek_start_date());
        subjectDTO.setWeek_end_date(cls.getWeek_end_date());
        subjectDTO.setExact_class_date(cls.getExact_class_date());
        subjectDTO.setDay_of_week(cls.getDay_of_week());
        subjectDTO.setRoom_number(cls.getRoom_number());
        subjectDTO.setRoom(cls.getRoom());
        subjectDTO.setGps_coordinates(cls.getGps_coordinates());
        subjectDTO.setStart_time(cls.getStart_time());
        subjectDTO.setEnd_time(cls.getEnd_time());
        subjectDTO.setCampus_code(cls.getCampus_code());
        subjectDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
        subjectDTO.setDuration(cls.getDuration());
        subjectDTO.setDuration_code(cls.getDuration_code());

        return subjectDTO;
    }


    @Override
    public List<SubjectDTO> list() {
        return subjectStudentRepository.findAll().stream().map(cls ->{
            var subjectDTO = new SubjectDTO();
            subjectDTO.setSubject_code(cls.getSubject_code());
            subjectDTO.setSubject_desc(cls.getSubject_desc());
            subjectDTO.setWeek_start_date(cls.getWeek_start_date());
            subjectDTO.setWeek_end_date(cls.getWeek_end_date());
            subjectDTO.setExact_class_date(cls.getExact_class_date());
            subjectDTO.setDay_of_week(cls.getDay_of_week());
            subjectDTO.setRoom_number(cls.getRoom_number());
            subjectDTO.setRoom(cls.getRoom());
            subjectDTO.setGps_coordinates(cls.getGps_coordinates());
            subjectDTO.setStart_time(cls.getStart_time());
            subjectDTO.setEnd_time(cls.getEnd_time());
            subjectDTO.setCampus_code(cls.getCampus_code());
            subjectDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
            subjectDTO.setDuration(cls.getDuration());
            subjectDTO.setDuration_code(cls.getDuration_code());
            return subjectDTO;
        }).collect(Collectors.toList());
        return null;
    }

    @Override
    public SubjectDTO create(SubjectDTO classDTO) throws Exception {
        return null;
    }

    @Override
    public SubjectDTO update(SubjectDTO classDTO) throws Exception {
        return null;
    }

    @Override
    public void delete(String id) throws Exception {
        var cls = subjectStudentRepository.findById(id);

        if (cls.isPresent()) subjectStudentRepository.delete(cls.get());
        else throw new Exception("Class not found!");
    }

}
