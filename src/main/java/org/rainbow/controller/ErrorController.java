package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/404")
	public String handle1(){
		return "error/404";
	}

	@RequestMapping("/500")
	public String handle2(){
		return "error/500";
	}
}
