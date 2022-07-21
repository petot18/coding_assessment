package com.coding.sp.Classes;

import com.coding.sp.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Class {

        @Id
        private long id;
        @Column
        private String subject_code;
        @Column
        private String subject_desc;
        @Column
        private String week_start_date;
        @Column
        private String week_end_date;
        @Column
        private String exact_class_date;
        @Column
        private String day_of_week;
        @Column
        private String room_number;
        @Column
        private String room;
        @Column
        private String gps_coordinates;
        @Column
        private String start_time;
        @Column
        private String end_time;
        @Column
        private String campus_code;
        @Column
        private boolean hasStandardRoomDescription;
        @Column
        private int duration;
        @Column
        private String duration_code;
        @Column
        private boolean isHoliday;

        @ManyToMany
        Set<Student> listOfStudents;

//        public Set<Student> getListOfStudents() {
//                return listOfStudents;
//        }
//
//        public void setListOfStudents(Set<Student> listOfStudents) {
//                this.listOfStudents = listOfStudents;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Class aClass = (Class) o;
            return subject_code.equals(aClass.subject_code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(subject_code);
        }

}
