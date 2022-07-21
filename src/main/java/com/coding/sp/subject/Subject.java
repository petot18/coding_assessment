package com.coding.sp.subject;

import com.coding.sp.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @ManyToMany(mappedBy = "class_details", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @Column
    private String subjectCode;
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

    public Set<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(Set<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubject_desc() {
        return subject_desc;
    }

    public void setSubject_desc(String subject_desc) {
        this.subject_desc = subject_desc;
    }

    public String getWeek_start_date() {
        return week_start_date;
    }

    public void setWeek_start_date(String week_start_date) {
        this.week_start_date = week_start_date;
    }

    public String getWeek_end_date() {
        return week_end_date;
    }

    public void setWeek_end_date(String week_end_date) {
        this.week_end_date = week_end_date;
    }

    public String getExact_class_date() {
        return exact_class_date;
    }

    public void setExact_class_date(String exact_class_date) {
        this.exact_class_date = exact_class_date;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getGps_coordinates() {
        return gps_coordinates;
    }

    public void setGps_coordinates(String gps_coordinates) {
        this.gps_coordinates = gps_coordinates;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCampus_code() {
        return campus_code;
    }

    public void setCampus_code(String campus_code) {
        this.campus_code = campus_code;
    }

    public boolean isHasStandardRoomDescription() {
        return hasStandardRoomDescription;
    }

    public void setHasStandardRoomDescription(boolean hasStandardRoomDescription) {
        this.hasStandardRoomDescription = hasStandardRoomDescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDuration_code() {
        return duration_code;
    }

    public void setDuration_code(String duration_code) {
        this.duration_code = duration_code;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", students=" + students +
                ", subjectcode='" + subjectCode + '\'' +
                ", subject_desc='" + subject_desc + '\'' +
                ", week_start_date='" + week_start_date + '\'' +
                ", week_end_date='" + week_end_date + '\'' +
                ", exact_class_date='" + exact_class_date + '\'' +
                ", day_of_week='" + day_of_week + '\'' +
                ", room_number='" + room_number + '\'' +
                ", room='" + room + '\'' +
                ", gps_coordinates='" + gps_coordinates + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", campus_code='" + campus_code + '\'' +
                ", hasStandardRoomDescription=" + hasStandardRoomDescription +
                ", duration=" + duration +
                ", duration_code='" + duration_code + '\'' +
                ", isHoliday=" + isHoliday +
                '}';
    }
}
