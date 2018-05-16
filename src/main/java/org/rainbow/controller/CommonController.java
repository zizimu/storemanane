package org.rainbow.controller;

import org.rainbow.pojo.TbAccount;
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
 * @date 2018-04-08
 */
@Controller
@SessionAttributes(value = {"pageSize", "ossUrl","user"})
public class CommonController {
	@Autowired
	private ParameterService parameterService;

	@RequestMapping("/index")
	public String index(HttpSession session, ModelMap modelMap,Model model,@ModelAttribute("user")TbAccount account) {
		Map paras = parameterService.getPara();
		modelMap.addAttribute("pageSize", paras.get("pageSize"));
		modelMap.addAttribute("ossUrl", paras.get("ossUrl"));
		model.addAttribute("topImage", parameterService.getTopImage());
		model.addAttribute("status", account.getStatus());
		return "index";
	}

	@RequestMapping("/")
	public String rootDirectory() {
		return "redirect:/index";
	}

	@RequestMapping("/1/person.html")
	public String firstPage() {
		return "redirect:/account/information";
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