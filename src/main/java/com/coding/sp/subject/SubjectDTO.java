package com.coding.sp.subject;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SubjectDTO {


    private String subject_code;
    private String subject_desc;
    private String week_start_date;
    private String week_end_date;
    private String exact_class_date;
    private String day_of_week;
    private String room_number;
    private String room;
    private String gps_coordinates;
    private String start_time;
    private String end_time;
    private String campus_code;
    private boolean hasStandardRoomDescription;
    private int duration;
    private String duration_code;
    private boolean isHoliday;

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
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
        this.isHoliday = holiday;
    }

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<SubjectStudentDTO> student_ids;


    public void setStudent_ids(List<SubjectStudentDTO> studentDTO) {
    }
}
