package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Brand")
public class BrandController {
	@RequestMapping("/index")
	public String index() {
		return "Brand/index";
		
	}
	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page) {
		return "Brand/"+page;
		
	}
}

