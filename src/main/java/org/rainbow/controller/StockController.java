package org.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Stock") 

public class StockController {
	
	@RequestMapping("/index")
	public String index(){
		return "Stock/index";
	}
	
	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page){
		return "Stock/" +page;
	}


}
