package com.oumar.learn.repository;

import com.oumar.learn.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
