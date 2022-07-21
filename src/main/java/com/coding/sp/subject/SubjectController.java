package com.coding.sp.subject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

//    @Autowired
//    ClassService classService;

//    @GetMapping(value = "/subjects")
//    public String getSubjects(){
//
//        return "All Subjects!";
//    }
    @GetMapping(value = "/all-subjects",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectStudentDTO> getAllSubjects() throws Exception {
        return new ResponseEntity(subjectService.getAllSubject(), HttpStatus.OK);
    }
    @GetMapping(value = "/{subjectCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectDTO> getStudentsEnrolledInASubject(
            @PathVariable("subjectCode") String subjectCode) throws Exception {
        return new ResponseEntity(subjectService.viewEnrolledStudents(subjectCode), HttpStatus.OK);
    }
}
