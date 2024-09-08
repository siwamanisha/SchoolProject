package com.texascollege.Jpa.service;

import com.texascollege.Jpa.dto.StudentDto;
import com.texascollege.Jpa.dto.StudentResponseDto;
import com.texascollege.Jpa.model.Student;
import com.texascollege.Jpa.repository.SchoolRepository;
import com.texascollege.Jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto)
    {
        var student=studentMapper.toStudent(studentDto);
        var savedStudent=repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public List<Student> findAllStudent()
    {
        return repository.findAll();
    }
    public Student findAllStudentById ( Integer id)  //method ko naam bhitra chai pathvar diney ani bahira chai idInteger id
    {
        return repository.findById(id)
                .orElse(new Student());  //id  baata student ko list niskiney vayeko le chai id parameter pass gareko ho

    }
    public List<Student>findStudentsByName  (String name)
    {
        return repository.findAllByFirstname(name ); //findAllByFirstname method list ko form ma  chai yesailo repository ma list banayera rakhiyeko xa

    }
    public void delete(Integer id)
    {
        repository.deleteById(id);
    }
}

