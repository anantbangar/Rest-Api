package com.restUsingSp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController 
{
	@RequestMapping("/home")
	public String get()
	{
		return "index";
	}

}
