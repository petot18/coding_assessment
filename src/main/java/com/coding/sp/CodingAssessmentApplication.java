package com.coding.sp;

import com.coding.sp.student.Student;
import com.coding.sp.student.StudentDTO;
import com.coding.sp.student.StudentRepository;
import com.coding.sp.subject.Subject;
import com.coding.sp.subject.SubjectDTO;
import com.coding.sp.subject.SubjectStudentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@EnableJpaRepositories(basePackages = {"com.coding.sp.subject", "com.coding.sp.student"})
@SpringBootApplication
public class CodingAssessmentApplication implements CommandLineRunner {

    @Autowired
    SubjectStudentRepository subjectStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(CodingAssessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<StudentDTO>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/output.json");

        try {
            List<StudentDTO> students = mapper.readValue(inputStream, typeReference);


            Set<String> subjNames = new HashSet<>();

            for (StudentDTO student : students) {
                System.out.println("Student code: " + student.getStudent_id());
                for (SubjectDTO subject : student.getClass_details()) {
                    Subject subject1 = new Subject();
                    if (!subjNames.contains(subject.getSubjectCode())) {
                        subjNames.add(subject.getSubjectCode());
                        subject1.setSubjectCode(subject.getSubjectCode());
                        subject1.setSubjectDesc(subject.getSubjectDesc());
                        subject1.setWeekStartDate(subject.getWeekStartDate());
                        subject1.setWeekEndDate(subject.getWeekEndDate());
                        subject1.setExactClassDate(subject.getExactClassDate());
                        subject1.setDayOfWeek(subject.getDayOfWeek());
                        subject1.setRoomNumber(subject.getRoomNumber());
                        subject1.setRoom(subject.getRoom());
                        subject1.setStartTime(subject.getStartTime());
                        subject1.setEndTime(subject.getEndTime());
                        subject1.setCampusCode(subject.getCampusCode());
                        subject1.setHasStandardRoomDescription(subject.isHasStandardRoomDescription());
                        subject1.setDuration(subject.getDuration());
                        subject1.setDurationCode(subject.getDurationCode());
                        subject1.setGpsCoordinates(subject.getGpsCoordinates());
                        subject1.setHoliday(subject.isHoliday());

                        subject1 = subjectStudentRepository.save(subject1);
                    }
                }
            }
            System.out.println("Class Saved!");


            for (StudentDTO studentDTO : students) {
                Student stud = new Student();
                List<Subject> st = new ArrayList<>();
                List<String> str = new ArrayList<>();

                for (SubjectDTO dto : studentDTO.getClass_details()) {
                    if (!str.contains(dto.getSubjectCode())) {
                        System.out.println("Subject ID: " + dto.getSubjectCode());
                        Subject isFound = subjectStudentRepository.findBySubjectCode(dto.getSubjectCode());

                        System.out.println(isFound);
                        if (isFound != null) {
                            st.add(isFound);
                            str.add(isFound.getSubjectCode());
                        }
                    }
                }
                stud.setStudentId(studentDTO.getStudent_id());
                stud.setClass_details(st);
                stud = studentRepository.save(stud);
                }


            } catch(IOException e){
                System.out.println("Unable to save Class: " + e.getMessage());
            }
        }
    }
