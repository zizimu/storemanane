package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Staff")
public class StaffController {

	@RequestMapping("/index")
	public String index(){
		return "Staff/index";
	}
	
	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page) {
		return "Staff/"+page;
		
	}
}


