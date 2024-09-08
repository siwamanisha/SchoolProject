package com.texascollege.Jpa.repository;

import com.texascollege.Jpa.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

}
