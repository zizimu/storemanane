package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
@Controller
public class CommonController {
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}

	@RequestMapping("/{page}")
	public String page2jsp(@PathVariable String page){
		return page;
	}
	
}
