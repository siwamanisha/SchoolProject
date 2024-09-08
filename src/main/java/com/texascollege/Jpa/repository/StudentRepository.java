package com.texascollege.Jpa.repository;

import com.texascollege.Jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstname(String firstname);


}
