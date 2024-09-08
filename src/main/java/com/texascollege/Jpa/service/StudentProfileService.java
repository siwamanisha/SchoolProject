package com.texascollege.Jpa.service;


import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.dto.StudentProfileDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.model.StudentProfile;
import com.texascollege.Jpa.repository.StudentProfileRepository;
import com.texascollege.Jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service

public class StudentProfileService {
    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileService(StudentProfileMapper studentProfileMapper, StudentProfileRepository studentProfileRepository) {
        this.studentProfileMapper = studentProfileMapper;
        this.studentProfileRepository = studentProfileRepository;
    }

    private final StudentProfileMapper studentProfileMapper;


    public StudentProfileDto create(StudentProfileDto studentProfileDto)

    {
        var studentprofile =studentProfileMapper.toStudentProfile(studentProfileDto);
        studentProfileRepository.save(studentprofile);
        return studentProfileDto;

    }

    public List<StudentProfileDto> findAll()

    {
        return studentProfileRepository.findAll()
                .stream()
                .map(studentProfileMapper::toStudentProfileDto)
                .collect(Collectors.toList());
    }

}
