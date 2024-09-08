package com.texascollege.Jpa.Controller;

import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.repository.SchoolRepository;
import com.texascollege.Jpa.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class     SchoolController {
    //private final SchoolRepository schoolRepository;

//    public SchoolController(SchoolRepository schoolRepository) {
//        this.schoolRepository = schoolRepository;
//    }
  private final SchoolService schoolService;


    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto schoolDto  //school ko object same xa input ra output dubai ko lagi tei vayera use nagareko
    )

    {
//        var school =toSchoolDto(schoolDto); //schooldto received
//        schoolRepository.save(school); //school is saved
//        return schoolDto; // object is returned back

    return schoolService.create(schoolDto);
     }

//    private School toSchool( SchoolDto  schoolDto )
//    {
//
//     return new School(schoolDto.name()); //since name is the only attribute of SchoolDto record
//
//    }

//    private SchoolDto toSchoolDto(School school) //this method will take school object as a parameter
//                                                 // and return a schoolDto
//    {
//        return new SchoolDto(school.getName());
//    }
    @GetMapping("/schools") //to fecth list of schools in db, no need to expose school but return a school dto object
    public  List<SchoolDto> findAll()  //first ma school thiyo aba schoolDto type return garney

    {
        return schoolService.findAll();  //after finding all students, it will return list of schools
//                .stream()       //transform our list to a stream of schools
//                .map(this::toSchoolDto)  //for each element of stream we will do transformation and it will
//                                         //call toSchoolDto() method which will return a stream of school dto object
//                .collect(Collectors.toList());
    }

}
