package com.oumar.learn.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.oumar.learn.model.Person;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public void initialize(PasswordMatches passwordMatches) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		Person person = (Person) object;
		return person.getPassword().equals(person.getMatchingPassword());
	}

}
