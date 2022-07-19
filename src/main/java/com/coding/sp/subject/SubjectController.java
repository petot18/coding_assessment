package com.coding.sp.subject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @GetMapping(value = "/subjects")
    public String getSubjects(){

        return "All Subjects!";
    }
}
