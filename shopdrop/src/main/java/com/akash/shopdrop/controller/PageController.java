package com.akash.shopdrop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/", "/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","welcome to spring mvc");
		return mv;
	}
	
	@RequestMapping(value= {"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		ModelAndView mv = new ModelAndView("page");
		
		if (greeting== null) {
			greeting="Hi there !";
		}
		mv.addObject("greeting",greeting);
		return mv;
	}

}
