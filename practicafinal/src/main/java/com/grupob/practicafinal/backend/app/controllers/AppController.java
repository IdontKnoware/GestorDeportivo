package com.grupob.practicafinal.backend.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="practicafinal/app")
public class AppController {
	
	
	// Welcome page
	
	@RequestMapping(value="/",
					method=RequestMethod.GET)	
	public String home() {
		return "index";
	}

}
