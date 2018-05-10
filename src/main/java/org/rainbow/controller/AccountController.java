package org.rainbow.controller;

import org.rainbow.mapper.TbParameterMapper;
import org.rainbow.pojo.TbAccount;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class AccountController {
	@Autowired
	private ParameterService parameterService;

	@RequestMapping("/person")
	public String toPerson(@ModelAttribute("user")TbAccount account, Model model){
		model.addAttribute("account",account);
		return "account/person";
	}

	@RequestMapping(value = "/initPara", method = RequestMethod.GET)
	@ResponseBody
	public Map initParameter(HttpSession session, ModelMap modelMap) {
		Map<String, Object> result = new HashMap<>();
		Map paras = parameterService.getPara();
		if (paras.size() > 0) {
			modelMap.addAttribute("pageSize", paras.get("pageSize"));
			modelMap.addAttribute("ossUrl", paras.get("ossUrl"));
			result.put("stat", 200);
			result.put("message", "缓存更新成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "缓存更新失败，请重试！");
		}
		return result;
	}
}
