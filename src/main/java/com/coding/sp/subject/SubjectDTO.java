package com.coding.sp.subject;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SubjectDTO {

    private String subjectCode;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    private String subjectDesc;

    private String weekStartDate;

    private String weekEndDate;

    private String exactClassDate;

    private String dayOfWeek;

    private String roomNumber;

    private String room;

    private String gpsCoordinates;

    private String startTime;

    private String endTime;

    private String campusCode;

    private boolean hasStandardRoomDescription;

    private int duration;
    private String durationCode;

    private boolean isHoliday;

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    public String getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(String weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public String getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(String weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public String getExactClassDate() {
        return exactClassDate;
    }

    public void setExactClassDate(String exactClassDate) {
        this.exactClassDate = exactClassDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode;
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

    public String getDurationCode() {
        return durationCode;
    }

    public void setDurationCode(String durationCode) {
        this.durationCode = durationCode;
    }


    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<SubjectStudentDTO> student_ids;
    public void setStudent_ids(List<SubjectStudentDTO> studentDTO) {
    }
}
