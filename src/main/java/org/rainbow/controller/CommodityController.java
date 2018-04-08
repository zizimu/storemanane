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
@RequestMapping("/Node")
public class CommodityController {

	@RequestMapping("/index")
	public String index(){
		return "Node/index";
	}

	@RequestMapping("/{page}.html")
	public String page(@PathVariable("page") String page){
		return "Node/" +page;
	}

	/*@RequestMapping("/add.html")
	public String initAddPage(){
		return "Node/add";
	}*/

}