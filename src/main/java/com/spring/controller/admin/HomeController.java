package com.spring.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerAdmin")
public class HomeController {
	
	@RequestMapping(value ="/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView md = new ModelAndView("admin/home");
		return md;
		
	}
}
