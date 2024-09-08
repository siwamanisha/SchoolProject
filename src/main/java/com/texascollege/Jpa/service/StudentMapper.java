package com.texascollege.Jpa.service;

import com.texascollege.Jpa.dto.StudentDto;
import com.texascollege.Jpa.dto.StudentResponseDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto studentDto)
    {
         var student = new Student(); //student euta object ho OF type Student
        student.setFirstname(studentDto.firstame());
                         //studentDto ma vayeko filed haru lai set/get gareko
        student.setLastname(studentDto.lastname());
        student.setEmail(studentDto.email());

         var school = new School();  //set an object of type school as SchoolId is in Dto and link it  to student object
        school.setId(studentDto.SchoolId());
        student.setSchool(school);
        return student;

    }


    public StudentResponseDto toStudentResponseDto(Student s1) //response dto should receive student object as parameter
    {   return new StudentResponseDto(

            s1.getFirstname(),
        s1.getLastname(),

        s1.getEmail() );
    }
}
