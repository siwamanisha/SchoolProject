package com.texascollege.Jpa.Controller;

import com.texascollege.Jpa.dto.StudentDto;
import com.texascollege.Jpa.dto.StudentResponseDto;
import com.texascollege.Jpa.model.School;
import com.texascollege.Jpa.model.Student;
import com.texascollege.Jpa.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    // return repository.save(student); //takes S of type entity, save method take entity as parameter
    //studentDto ko object pass garepaxi error aauxa repo ma tei kinavaney yesle student ko object expect gareko xa
    //tei vayera euta naya methos banauxam toStudent vanney



    }

    {

    }

    @GetMapping("/students/{student-id}") //update operation
    public Student findAllStudentById(   //method ko naam bhitra chai pathvar diney ani bahira chai id
                                         @PathVariable("student-id") Integer id
    ) {

    }
    public List<Student> findStudentsByName(   //ali search garda l contain vayeko sabai students haru ko list aauxa tesaile list use gareko
                                               @PathVariable("student-name") String name
    ) {

    }
    @ResponseStatus(HttpStatus.OK)
    ) {
    }
}


