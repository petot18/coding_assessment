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
        private String subjectCode;
        @Column
        private String subjectDesc;
        @Column
        private String weekStartDate;
        @Column
        private String weekEndDate;
        @Column
        private String exactClassDate;
        @Column
        private String dayOfWeek;
        @Column
        private String roomNumber;
        @Column
        private String room;
        @Column
        private String gpsCoordinates;
        @Column
        private String startTime;
        @Column
        private String endTime;
        @Column
        private String campusCode;
        @Column
        private boolean hasStandardRoomDescription;
        @Column
        private int duration;
        @Column
        private String durationCode;

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
            return subjectCode.equals(aClass.subjectCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(subjectCode);
        }

}
