package com.coding.sp.Classes;

import com.coding.sp.subject.SubjectDTO;
import com.coding.sp.subject.SubjectService;
import com.coding.sp.subject.SubjectStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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

        subjectDTO.setSubjectCode(cls.getSubjectCode());
        subjectDTO.setSubjectCode(cls.getSubjectCode());
        subjectDTO.setSubjectDesc(cls.getSubjectDesc());
        subjectDTO.setWeekStartDate(cls.getWeekStartDate());
        subjectDTO.setWeekEndDate(cls.getWeekEndDate());
        subjectDTO.setExactClassDate(cls.getExactClassDate());
        subjectDTO.setDayOfWeek(cls.getDayOfWeek());
        subjectDTO.setRoomNumber(cls.getRoomNumber());
        subjectDTO.setRoom(cls.getRoom());
        subjectDTO.setGpsCoordinates(cls.getGpsCoordinates());
        subjectDTO.setStartTime(cls.getStartTime());
        subjectDTO.setEndTime(cls.getEndTime());
        subjectDTO.setCampusCode(cls.getCampusCode());
        subjectDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
        subjectDTO.setDuration(cls.getDuration());
        subjectDTO.setDurationCode(cls.getDurationCode());
        return subjectDTO;
    }


    @Override
    public List<SubjectDTO> list() {
        List<SubjectDTO> lists = new ArrayList<>();

        subjectStudentRepository.findAll().forEach((cls) ->{
            var subjectDTO = new SubjectDTO();

        subjectDTO.setSubjectCode(cls.getSubjectCode());
        subjectDTO.setSubjectCode(cls.getSubjectCode());
        subjectDTO.setSubjectDesc(cls.getSubjectDesc());
        subjectDTO.setWeekStartDate(cls.getWeekStartDate());
        subjectDTO.setWeekEndDate(cls.getWeekEndDate());
        subjectDTO.setExactClassDate(cls.getExactClassDate());
        subjectDTO.setDayOfWeek(cls.getDayOfWeek());
        subjectDTO.setRoomNumber(cls.getRoomNumber());
        subjectDTO.setRoom(cls.getRoom());
        subjectDTO.setGpsCoordinates(cls.getGpsCoordinates());
        subjectDTO.setStartTime(cls.getStartTime());
        subjectDTO.setEndTime(cls.getEndTime());
        subjectDTO.setCampusCode(cls.getCampusCode());
        subjectDTO.setHasStandardRoomDescription(cls.isHasStandardRoomDescription());
        subjectDTO.setDuration(cls.getDuration());
        subjectDTO.setDurationCode(cls.getDurationCode());
            lists.add(subjectDTO);
        });

        return lists;
//        return null;
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
