package com.oumar.learn.controller;

import com.oumar.learn.model.Person;
import com.oumar.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonneValidator implements Validator{

    @Autowired
    private PersonService personService;

    @Override
    public boolean supports(Class<?> arg){
        return false;
    }

    @Override
    public void validate(Object object, Errors errors){
        if(object instanceof Person){
            Person person = (Person) object;
            if(StringUtils.isEmpty(person.getEmail())){
                errors.rejectValue("email", "email.not.valid");
            }else {
                String emailPattern = "^[_A-Za-z0-9-+]+"
                        + "(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)"
                        + "*(.[A-Za-z]{2,})$";
                Pattern pattern = Pattern.compile(emailPattern);
                Matcher matcher = pattern.matcher(person.getEmail());
                if (!matcher.matches()) {
                    errors.rejectValue("email", "email.not.valid");
                }else if(StringUtils.isEmpty(person.getPassword())){
                    errors.rejectValue("password", "password.not.correct");
                }else if(!person.getPassword().equals(person.getMatchingPassword())){
                    errors.rejectValue("matchingPassword", "password.not.match");
                }else if(personService.getByEmail(person.getEmail()) != null) {
                    errors.rejectValue("email", "email.already.used");
                }
            }
        }
    }
}
