package com.texascollege.Jpa.service;

import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SchoolMapper {


    public School toSchool(SchoolDto schoolDto) {

        return new School(schoolDto.name()); //since name is the only attribute of SchoolDto record

    }

     public SchoolDto toSchoolDto(School school)
     {              //method is made public to use them outside of class
        return new SchoolDto(school.getName());
    }
}
