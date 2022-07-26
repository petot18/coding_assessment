package com.coding.sp.subject;

import com.coding.sp.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
@RequiredArgsConstructor
public class Subject {

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false)
//    private long id;

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

    @Column
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "class_details", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();
    @ManyToMany
    Set<Student> listOfStudents;

    public Set<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(Set<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }


    @Override
    public String toString() {
        return "Subject{" +
                " students=" + students +
                ", subject_code='" + subjectCode + '\'' +
                ", subject_desc='" + subjectDesc + '\'' +
                ", week_start_date='" + weekStartDate + '\'' +
                ", week_end_date='" + weekEndDate + '\'' +
                ", exact_class_date='" + exactClassDate + '\'' +
                ", day_of_week='" + dayOfWeek + '\'' +
                ", room_number='" + roomNumber + '\'' +
                ", room='" + room + '\'' +
                ", gps_coordinates='" + gpsCoordinates + '\'' +
                ", start_time='" + startTime + '\'' +
                ", end_time='" + endTime + '\'' +
                ", campus_code='" + campusCode + '\'' +
                ", hasStandardRoomDescription=" + hasStandardRoomDescription +
                ", duration=" + duration +
                ", duration_code='" + durationCode + '\'' +
                '}';
    }
}
