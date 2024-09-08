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
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students") //create operation
    public StudentResponseDto post(@RequestBody StudentDto studentDto) //student is object of type Student
    {   var student=toStudent(studentDto); //calling method toStudent()
         // return repository.save(student); //takes S of type entity, save method take entity as parameter
        //studentDto ko object pass garepaxi error aauxa repo ma tei kinavaney yesle student ko object expect gareko xa
        //tei vayera euta naya methos banauxam toStudent vanney

        var savedStudent=repository.save(student);
        return toStudentResponseDto(savedStudent);

    }
    private StudentResponseDto toStudentResponseDto(Student s1) //response dto should receive student object as parameter
    {   return new StudentResponseDto(

            s1.getFirstname(),       //here s1 is object of Student type
        s1.getLastname(), //these are the only information that should be  exposed to user
                                      //after doing this responsedto only the id isnot shown in postman
        s1.getEmail() );
    }

    private Student toStudent(StudentDto studentDto)
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

    @GetMapping("/students") //read operation
    public List<Student> findAllStudents() //student is object of type Student
    {
        return repository.findAll();

    }
    @GetMapping("/students/{student-id}") //update operation
    public Student findAllStudentById  (   //method ko naam bhitra chai pathvar diney ani bahira chai id
            @PathVariable("student-id") Integer id
    ){
        return repository.findById(id).orElse(new Student());  //id  baata student ko list niskiney vayeko le chai id parameter pass gareko ho

      }
    @GetMapping("/students/search/{student-name}") //update operation
    public List<Student> findStudentsByName  (   //ali search garda l contain vayeko sabai students haru ko list aauxa tesaile list use gareko
            @PathVariable("student-name") String name
    ){
        return repository.findAllByFirstname(name ); //findAllByFirstname method list ko form ma  chai yesailo repository ma list banayera rakhiyeko xa

    }
@DeleteMapping("/students/{student-id}") //path name is given, it deletes the student by id
@ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id   //path variable ko naam ra mathi ko path ko naam same xa
) {
        repository.deleteById(id);
}

}


