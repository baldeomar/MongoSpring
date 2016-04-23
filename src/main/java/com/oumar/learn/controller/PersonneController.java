package com.oumar.learn.controller;

import com.oumar.learn.application.AppUrl;
import com.oumar.learn.application.PageMap;
import com.oumar.learn.model.Person;
import com.oumar.learn.model.Vto.PersonneVto;
import com.oumar.learn.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class PersonneController {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	PersonService personService;

	@Autowired
	PersonneValidator personneValidator;

	private static final String MODEL_ATTRIBUTE_ERROR = "error";
	private static final String MODEL_ATTRIBUTE_MESSAGE = "message";
	private static final String MODEL_ATTRIBUTE_REGISTER_PAGE = "registerPage";
	private static final String MODEL_ATTRIBUTE_PERSON = "personneForm";
	private static final String MODEL_ATTRIBUTE_REGISTER_POST = "registerPost";
	private static final String MODEL_LOGIN_POST = "loginPost";

	@RequestMapping(value = AppUrl.LOGIN, method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		Model model) {
		if (error != null) {
			model.addAttribute(MODEL_ATTRIBUTE_ERROR, "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute(MODEL_ATTRIBUTE_MESSAGE, "You've been logged out successfully.");
		}
		model.addAttribute(MODEL_ATTRIBUTE_REGISTER_PAGE, AppUrl.REGISTER_PRE);
		model.addAttribute(MODEL_LOGIN_POST, AppUrl.HOME);
		return PageMap.LOGIN;
	}

	@RequestMapping(value = AppUrl.HOME, method = RequestMethod.POST)
	public String showHomePage(){
		return PageMap.HOME;
	}
	
	@RequestMapping(value = AppUrl.REGISTER_PRE, method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		PersonneVto personneVto = new PersonneVto();
		model.addAttribute(MODEL_ATTRIBUTE_PERSON, personneVto);
		model.addAttribute(MODEL_ATTRIBUTE_REGISTER_POST, AppUrl.REGISTER_POST);
		return PageMap.REGISTER_PRE;
	}

	@RequestMapping(value = AppUrl.REGISTER_POST, method = RequestMethod.POST)
	public String registerPerson(@ModelAttribute("personneForm") PersonneVto personneVto,
			BindingResult result, Model model) {
		personneValidator.validate(personneVto, result);
		if(!result.hasErrors()){
			log.info("trying to register person email {}", personneVto.getEmail());
			Person person = personneVto.toPerson();
			person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
			personService.saveOrUpdate(person);
			return PageMap.HOME;
		}else{
			model.addAttribute(MODEL_ATTRIBUTE_PERSON, personneVto);
			model.addAttribute(MODEL_ATTRIBUTE_REGISTER_POST, AppUrl.REGISTER_POST);
			return PageMap.REGISTER_PRE;
		}
	}

	@RequestMapping(value = AppUrl.DATATABLE_HANDLE, method = RequestMethod.GET)
	public ModelAndView getDataTable() {
		ModelAndView model = new ModelAndView();
		model.setViewName("handleDataTable");
		return model;
	}
}