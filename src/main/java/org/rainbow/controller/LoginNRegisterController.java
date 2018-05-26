package org.rainbow.controller;

import org.rainbow.pojo.TbAccount;
import org.rainbow.service.AccountService;
import org.rainbow.service.ParameterService;
import org.rainbow.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class LoginNRegisterController {
	@Autowired
	private ParameterService parameterService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BGimage", parameterService.getLoginBGimage());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map loginVerification(@RequestBody TbAccount loginer, ModelMap modelMap, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		if (loginer == null || loginer.getLoginname() == null || loginer.getPassword() == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else {
			Encryption en = Encryption.getInstance();
			loginer.setPassword(en.byte2BASE64(en.passwordEncry(loginer.getPassword())));
			TbAccount account = accountService.loginByIdOrName(loginer);
			if (account != null) {
				if (account.getStatus() > 0) {
					modelMap.addAttribute("user", account);
					result.put("stat", 200);
					result.put("message", "登陆成功！");
					result.put("url", "/index");
				} else {
					result.put("stat", 300);
					result.put("message", "账号待审核！");
				}
			} else {
				result.put("stat", 500);
				result.put("message", "用户名或密码错误！");
			}
		}
		return result;
	}

	@RequestMapping("/logout")
	public String loginOut(HttpSession session, SessionStatus sessionStatus) {
		session.removeAttribute("user");
		sessionStatus.setComplete();
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("BGimage", parameterService.getLoginBGimage());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Map registerNew(@RequestBody TbAccount loginer) {
		Map<String, Object> result = new HashMap<>();
		if (loginer == null || loginer.getLoginname() == null || loginer.getPassword() == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else {
			Encryption en = Encryption.getInstance();
			loginer.setPassword(en.byte2BASE64(en.passwordEncry(loginer.getPassword())));
			if (accountService.insertNew(loginer) > 0) {
				result.put("stat", 200);
				result.put("message", "注册成功！");
				result.put("url", "/login");
			} else {
				result.put("stat", 500);
				result.put("message", "注册失败，请重试！");
			}
		}
		return result;
	}
}
