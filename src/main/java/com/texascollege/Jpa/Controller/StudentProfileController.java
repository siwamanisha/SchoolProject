package com.texascollege.Jpa.Controller;


import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.dto.StudentProfileDto;
import com.texascollege.Jpa.model.StudentProfile;
import com.texascollege.Jpa.repository.StudentProfileRepository;
import com.texascollege.Jpa.service.SchoolService;
import com.texascollege.Jpa.service.StudentProfileService;
import com.texascollege.Jpa.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.RequestEntity.post;

@RestController

public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping("/student-profile")
    public StudentProfileDto create(
            @RequestBody StudentProfileDto studentProfileDto //school ko object same xa input ra output dubai ko lagi tei vayera use nagareko
    )

    {

        return studentProfileService.create(studentProfileDto);
    }


    @GetMapping("/students-profile") //to fecth list of schools in db, no need to expose school but return a school dto object
    public List<StudentProfileDto> findAll()  //first ma school thiyo aba schoolDto type return garney

    {
        return studentProfileService.findAll();

    }

}
