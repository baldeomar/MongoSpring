package com.oumar.learn.Specifications;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PersonSpecifications {

    @PersistenceContext
    EntityManager entityManager;
}
