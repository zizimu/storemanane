package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Order")
public class OrderController {

	@RequestMapping("/index")
	public String index() {
		return "Order/index";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "Order/edit";
	}
	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page) {	
		return "Order/"+page;
	}	
}

