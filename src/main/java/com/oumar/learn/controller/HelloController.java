package com.oumar.learn.controller;
import javax.validation.Valid;

import com.oumar.learn.Application.ApplicationUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.oumar.learn.dao.PersonDAO;
import com.oumar.learn.model.Person;

@Controller
public class HelloController {
	public static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = {ApplicationUrl.ROOT, ApplicationUrl.WELCOME }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = ApplicationUrl.ADMIN, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}

	//Spring Security see this :
	@RequestMapping(value = ApplicationUrl.LOGIN, method = RequestMethod.GET)
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
	
	@RequestMapping(value = ApplicationUrl.REGISTER, method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		Person person = new Person();
		person.setFirstName("haha");
		model.addAttribute("person", person);
		return "register";
	}

	@RequestMapping(value = ApplicationUrl.REGISTER, method = RequestMethod.POST)
	public ModelAndView registerPerson(@ModelAttribute("person") @Valid Person person,
			BindingResult result) {
		logger.info("registering person...");
		Person p = new Person();
		if(!result.hasErrors()){
			p = createPerson(person);
		}
		if(p == null){
			result.rejectValue("email", "user null returned");
		}
		if(result.hasErrors()) {
			return new ModelAndView("register", "person", p);
		}else{
			return new ModelAndView("admin", "person", p);
		}
	}
	
	private Person createPerson(Person person) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext-beans.xml");
		PersonDAO personDao = context.getBean("PersonDAO", PersonDAO.class);
		try {
			personDao.create(person); 
		}catch(Exception e){
			logger.error("erreur de creation d'un user: ", e);
			return null;
		}
		return person;
	}
}