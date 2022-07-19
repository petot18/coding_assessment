package com.coding.sp;

import com.coding.sp.student.Student;
import com.coding.sp.student.StudentDTO;
import com.coding.sp.student.StudentRepository;
import com.coding.sp.subject.Subject;
import com.coding.sp.subject.SubjectDTO;
import com.coding.sp.subject.SubjectRepository;
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
    SubjectRepository subjectRepository;

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
                    if (!subjNames.contains(subject.getSubject_code())) {
                        subjNames.add(subject.getSubject_code());

                        subject1.setSubjectCode(subject.getSubject_code());
                        subject1.setSubject_desc(subject.getSubject_desc());
                        subject1.setWeek_start_date(subject.getWeek_start_date());
                        subject1.setWeek_end_date(subject.getWeek_end_date());
                        subject1.setExact_class_date(subject.getExact_class_date());
                        subject1.setDay_of_week(subject.getDay_of_week());
                        subject1.setRoom_number(subject.getRoom_number());
                        subject1.setRoom(subject.getRoom());
                        subject1.setStart_time(subject.getStart_time());
                        subject1.setEnd_time(subject.getEnd_time());
                        subject1.setCampus_code(subject.getCampus_code());
                        subject1.setHasStandardRoomDescription(subject.isHasStandardRoomDescription());
                        subject1.setDuration(subject.getDuration());
                        subject1.setDuration_code(subject.getDuration_code());
                        subject1.setGps_coordinates(subject.getGps_coordinates());
                        subject1.setHoliday(subject.isHoliday());
                        subject1 = subjectRepository.save(subject1);
                    }
                }
            }
            System.out.println("Class Saved!");


            for (StudentDTO studentDTO : students) {
                Student stud = new Student();
                List<Subject> st = new ArrayList<>();
                List<String> str = new ArrayList<>();

                for (SubjectDTO dto : studentDTO.getClass_details()) {
                    if (!str.contains(dto.getSubject_code())) {
                        System.out.println("Subject ID: " + dto.getSubject_code());
                        Subject isFound = subjectRepository.findBySubjectCode(dto.getSubject_code());

                        System.out.println(isFound);
                        if (isFound != null) {
                            st.add(isFound);
                            str.add(isFound.getSubjectCode());
                        }
                    }
                }
                stud.setStudent_id(studentDTO.getStudent_id());
                stud.setClass_details(st);
                stud = studentRepository.save(stud);
                }


            } catch(IOException e){
                System.out.println("Unable to save Class: " + e.getMessage());
            }
        }
    }
