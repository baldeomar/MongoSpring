package com.oumar.learn.controller;

import com.oumar.learn.Application.AppUrl;
import com.oumar.learn.Application.PageMap;
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

	private static final String MODEL_ATTRIBUTE_ERROR = "error";
	private static final String MODEL_ATTRIBUTE_MESSAGE = "message";
	private static final String MODEL_ATTRIBUTE_REGISTER_PAGE = "registerPage";
	private static final String MODEL_ATTRIBUTE_PERSON = "person";
	private static final String MODEL_ATTRIBUTE_REGISTER_POST_LINK = "registerPostLink";

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
		return PageMap.LOGIN;
	}
	
	@RequestMapping(value = AppUrl.REGISTER_PRE, method = {RequestMethod.GET, RequestMethod.POST})
	public String showRegistrationForm(Model model) {
		log.info("envoi du model register");
		Person person = new Person();
		model.addAttribute(MODEL_ATTRIBUTE_PERSON, person);
		model.addAttribute(MODEL_ATTRIBUTE_REGISTER_POST_LINK, AppUrl.REGISTER_POST);
		return PageMap.REGISTER_PRE;
	}

	@RequestMapping(value = AppUrl.REGISTER_POST, method = RequestMethod.POST)
	public String registerPerson(@ModelAttribute("person") @Valid Person person,
			BindingResult result, Model model) {
		log.info("registering person...{}", person.toString());
		PersonSpecifications personSpec = new PersonSpecifications();
		CostumValidator costumValidator = new CostumValidator();
		costumValidator.validate(person, result);
		if(!result.hasErrors()){
			personSpec.createPerson(person);
			return "redirect: "+PageMap.ADMIN;
		}else{
			log.info("errors: {}", result.getAllErrors().toString());
			model.addAttribute(MODEL_ATTRIBUTE_PERSON, person);
			model.addAttribute(MODEL_ATTRIBUTE_REGISTER_POST_LINK, AppUrl.REGISTER_POST);
			return PageMap.REGISTER_PRE;
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

	@RequestMapping(value = AppUrl.DATATABLE_HANDLE, method = RequestMethod.GET)
	public ModelAndView getDataTable() {
		log.info("giving datatable page");
		ModelAndView model = new ModelAndView();
		model.setViewName("handleDataTable");
		return model;
	}
}