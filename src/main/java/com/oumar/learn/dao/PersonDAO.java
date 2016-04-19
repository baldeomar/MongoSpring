package com.oumar.learn.dao;

import com.oumar.learn.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, Integer>{

}
