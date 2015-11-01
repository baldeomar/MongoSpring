package com.oumar.learn.controller;

import com.oumar.learn.Specifications.PersonSpecifications;
import com.oumar.learn.model.Person;
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
            String emailPattern = "^[_A-Za-z0-9-+]+"
                    +"(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)"
                    +"*(.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(person.getEmail());
            if(!matcher.matches()){
                errors.rejectValue("Email", "Email is not valid");
            }else{
                PersonSpecifications personSpec = new PersonSpecifications();
                if(personSpec.getPersonByEmail(person.getEmail()) != null){
                    errors.rejectValue("Email", "Email is already used");
                }
            }
            if(person.getPassword().length() < 6){
                errors.rejectValue("Password", "Password too short");
            }else if(!person.getPassword().equals(person.getMatchingPassword())){
                errors.rejectValue("MatchingPassword", "Password does not match");
            }
        }
    }

}
