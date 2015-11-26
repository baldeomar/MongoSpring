package com.oumar.learn.controller;

import com.oumar.learn.Specifications.PersonSpecifications;
import com.oumar.learn.model.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostumValidator implements Validator{

    @Override
    public boolean supports(Class<?> arg){
        return false;
    }

    @Override
    public void validate(Object object, Errors errors){
        if(object instanceof Person){
            Person person = (Person) object;
            if(person.getPrenom() == null || StringUtils.isEmpty(person.getPrenom())){
                errors.rejectValue("prenom", "empty.not.allowed");
            }
            if(person.getNom() == null || StringUtils.isEmpty(person.getNom())){
                errors.rejectValue("nom", "empty.not.allowed");
            }
            String emailPattern = "^[_A-Za-z0-9-+]+"
                    +"(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)"
                    +"*(.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(person.getEmail());
            if(!matcher.matches()){
                errors.rejectValue("email", "email.not.valid");
            }else{
                PersonSpecifications personSpec = new PersonSpecifications();
                if(personSpec.getPersonByEmail(person.getEmail()) != null){
                    errors.rejectValue("email", "email.already.used");
                }
            }
            if(person.getPassword() == null
                    || StringUtils.isEmpty(person.getPassword())){
                errors.rejectValue("password", "password.not.correct");
            }else if(person.getMatchingPassword() == null
                    || StringUtils.isEmpty(person.getMatchingPassword())
                    || !person.getPassword().equals(person.getMatchingPassword())){
                errors.rejectValue("matchingPassword", "password.not.match");
            }
        }
    }
}
