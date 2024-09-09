package com.texascollege.Jpa.Controller;

import com.texascollege.Jpa.dto.StudentDto;
import com.texascollege.Jpa.dto.StudentResponseDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.model.Student;
import com.texascollege.Jpa.repository.StudentRepository;
import com.texascollege.Jpa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

 @PostMapping("/students")
 public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }


@GetMapping("/students")
public List<Student> findAllStudent()
{
   return studentService.findAllStudent();
}

@GetMapping("/students/{student-id}")
public Student findStudentById(@PathVariable ("student-id") Integer id)
{
    return studentService. findAllStudentById(id);
}
@DeleteMapping("/students/{student-id}")
@ResponseStatus(HttpStatus.OK)
public void delete(
        @PathVariable ("student-id") Integer id
)
{
    studentService.delete(id);
}
    }