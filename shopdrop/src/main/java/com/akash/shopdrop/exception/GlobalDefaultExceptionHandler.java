package com.akash.shopdrop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoudException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("pageTitle","404 Error! ");
		mv.addObject("errorTitle","Oops, you broke the internet ");
		mv.addObject("errorDescription","Just kidding. But it seems Robo, your personal robot, can't find\r\n" + 
				"					the page you're looking for. ");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoudException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("pageTitle","Product Unavailable");
		mv.addObject("errorTitle","Product Unavailable! ");
		mv.addObject("errorDescription","The product you are looking for is not available right now. ");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("pageTitle","Error!");
		mv.addObject("errorTitle","Contact your Administrator! ");
		mv.addObject("errorDescription",ex.toString());
		
		return mv;
	}

}
