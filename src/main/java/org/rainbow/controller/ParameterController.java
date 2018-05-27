package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbParameter;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/param")
@SessionAttributes("pageSize")
public class ParameterController {
	@Autowired
	private ParameterService parameterService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("pageSize") int pageSize){
		PageHelper.startPage(page, pageSize);
		List<TbParameter> accounts = parameterService.selectAll();
		PageInfo<TbParameter> p = new PageInfo<>(accounts);
		model.addAttribute("params", accounts);
		model.addAttribute("page", p);
		return "param/index";
	}
}
