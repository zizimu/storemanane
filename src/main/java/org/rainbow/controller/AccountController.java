package org.rainbow.controller;

import org.rainbow.pojo.TbAccount;
import org.rainbow.service.AccountService;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-01
 */
@Controller
@RequestMapping("/account")
@SessionAttributes("user")
public class AccountController {
	@Autowired
	private ParameterService parameterService;

	private AccountService accountService;

	@RequestMapping("/information")
	public String toPerson(@ModelAttribute("user")TbAccount account, Model model){
		model.addAttribute("account",account);
		return "account/person";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String allAccount(){
		return "";
	}
}
