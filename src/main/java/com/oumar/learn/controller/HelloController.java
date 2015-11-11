package com.oumar.learn.controller;

import com.oumar.learn.Application.AppUrl;
import com.oumar.learn.Specifications.PersonSpecifications;
import com.oumar.learn.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HelloController {

	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = {AppUrl.ROOT, AppUrl.WELCOME }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = AppUrl.ADMIN, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}

	//Spring Security see this :
	@RequestMapping(value = AppUrl.LOGIN, method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = AppUrl.REGISTER_PRE, method = RequestMethod.GET)
	public ModelAndView showRegistrationForm(Model model) {
		log.info("envoi du model register");
		Person person = new Person();
		model.addAttribute("person", person);
		return new ModelAndView("register");
	}

	@RequestMapping(value = AppUrl.REGISTER_POST, method = RequestMethod.POST)
	public ModelAndView registerPerson(@ModelAttribute("person") @Valid Person person,
			BindingResult result) {
		log.info("registering person...{}", person.toString());
		PersonSpecifications personSpec = new PersonSpecifications();
		CostumValidator costumValidator = new CostumValidator();
		costumValidator.validate(person, result);
		if(!result.hasErrors()){
			Person createdPerson = personSpec.createPerson(person);
			return new ModelAndView("admin", "person", createdPerson);
		}else{
			log.info("errors: {}", result.getAllErrors().toString());
			return new ModelAndView("register", "person", person);
		}
	}

	@RequestMapping(value = AppUrl.MAIN, method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView testMain() {
		int size = 0;
		try {
			PersonSpecifications personSpec = new PersonSpecifications();
			size = personSpec.personList().size();
		}catch (ExceptionInInitializerError eie){
			log.error("erreur dans spec: {}", eie);
		}
		return new ModelAndView("main", "size", size);
	}
}