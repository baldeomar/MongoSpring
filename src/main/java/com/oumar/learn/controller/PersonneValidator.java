package com.oumar.learn.controller;

import com.oumar.learn.model.Vto.PersonneVto;
import com.oumar.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
        if(object instanceof PersonneVto){
            PersonneVto personneVto = (PersonneVto) object;
            if(StringUtils.isEmpty(personneVto.getEmail())){
                errors.rejectValue("email", "email.not.valid");
            }else {
                String emailPattern = "^[_A-Za-z0-9-+]+"
                        + "(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)"
                        + "*(.[A-Za-z]{2,})$";
                Pattern pattern = Pattern.compile(emailPattern);
                Matcher matcher = pattern.matcher(personneVto.getEmail());
                if (!matcher.matches()) {
                    errors.rejectValue("email", "email.not.valid");
                }else if(StringUtils.isEmpty(personneVto.getPassword())){
                    errors.rejectValue("password", "password.not.correct");
                }else if(!personneVto.getPassword().equals(personneVto.getMatchingPassword())){
                    errors.rejectValue("matchingPassword", "password.not.match");
                }else if(personService.getByEmail(personneVto.getEmail()) != null) {
                    errors.rejectValue("email", "email.already.used");
                }
            }
        }
    }
}
