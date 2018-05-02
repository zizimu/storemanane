package org.rainbow.controller;

import org.rainbow.pojo.TbAccount;
import org.rainbow.service.AccountService;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
@Controller
@SessionAttributes("user")
public class CommonController {
	@Autowired
	private ParameterService parameterService;
	@Autowired
	private AccountService accountServeice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BGimage", parameterService.getLoginBGimage());
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map loginVerification(@RequestBody TbAccount loginer, ModelMap modelMap) {
		Map<String, Object> result = new HashMap<>();
		if (loginer == null || loginer.getLoginname() == null || loginer.getPassword() == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else {
			TbAccount account = accountServeice.loginByIdOrName(loginer);
			if (account != null) {
				result.put("stat", 200);
				result.put("message", "登陆成功！");
				result.put("url","/index");
				modelMap.addAttribute("user",account);
			} else {
				result.put("stat", 500);
				result.put("message", "用户名或密码错误！");
			}
		}
		return result;
	}
}