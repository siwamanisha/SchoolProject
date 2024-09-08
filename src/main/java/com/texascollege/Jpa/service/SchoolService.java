package com.texascollege.Jpa.service;

import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SchoolService {


    private final  SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;


    public SchoolService(SchoolRepository schoolRepository,
                         SchoolMapper schoolMapper)
    {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }



    public SchoolDto create(SchoolDto schoolDto)

    {
        var school =schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;

    }

    public  List<SchoolDto> findAll()

    {
//        return schoolRepository.findAll()
//                .stream()

        return ((List<School>) schoolRepository.findAll()).stream()
               .map(schoolMapper::toSchoolDto)
               .collect(Collectors.toList());
    }

}

