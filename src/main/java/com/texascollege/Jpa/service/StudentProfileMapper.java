package com.texascollege.Jpa.service;

import com.texascollege.Jpa.dto.SchoolDto;
import com.texascollege.Jpa.dto.StudentProfileDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.model.Student;
import com.texascollege.Jpa.model.StudentProfile;
import com.texascollege.Jpa.repository.SchoolRepository;
import com.texascollege.Jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentProfileMapper {
    public StudentProfile toStudentProfile(StudentProfileDto studentProfileDto)
    {

        return new StudentProfile(studentProfileDto.bio()); //since name is the only attribute of SchoolDto record

    }

    public StudentProfileDto toStudentProfileDto(StudentProfile studentProfile)
    {
        return new StudentProfileDto(studentProfile.getBio());
    }
}
