package com.texascollege.Jpa.repository;

import com.texascollege.Jpa.model.School;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchoolRepository extends CrudRepository<School, Integer> {

}
