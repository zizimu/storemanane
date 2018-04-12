package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Type")
public class TypeController {
	
	@RequestMapping("/index")
	public String index() {
		return "Type/index";
		
	}
	
	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page) {
		return "Type/"+page;		
	}

}
