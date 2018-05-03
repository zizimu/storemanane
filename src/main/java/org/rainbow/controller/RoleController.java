package org.rainbow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rainbow.pojo.TbRole;
import org.rainbow.service.RoleService;
import org.rainbow.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private StoreService storeService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		PageHelper.startPage(page, 8);
		List<TbRole> role = roleService.getAllRole();
		PageInfo<TbRole> st = new PageInfo<>(role);
		model.addAttribute("roleList", role);
		model.addAttribute("page", st);
		return "Role/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage(Model model) {
		model.addAttribute("stores", storeService.getAllStore());
		return "Role/add";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbRole role) {
		Map<String,Object> result = new HashMap<>();
		if(role == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息！");
		}else if(roleService.addRole(role)>0) {
			result.put("stat", 200);
			result.put("message", "添加成功！");
		}else{
			result.put("stat", 500);
			result.put("message", "添加失败，请重试！");
		}
		return result;		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	@ResponseBody
	public Map delete(@PathVariable("id")  int id) {
		Map<String,Object> result = new HashMap<>();
		TbRole role = new TbRole();
		role.setRoleId(id);
		role.setStatus(2);
		if(id == 0) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(roleService.updateRole(role)>0) {
			result.put("stat", 200);
			result.put("message", "删除成功！");
		}else{
			result.put("start", 500);
			result.put("message", "删除失败，请重试！");
		}
		return result;		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = "application/json")
	@ResponseBody
	public Map update(@RequestBody TbRole role,@PathVariable("id") String id) {
		Map<String,Object> result = new HashMap<>();
		if(role == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(roleService.updateRole(role)>0) {
			result.put("stat", 200);
		}else{
			result.put("stat", 500);
			result.put("message", "修改失败，请重试！");
		}
		return result;		
	}
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id,Model model) {
		TbRole role = roleService.getRoleById(id);
		model.addAttribute("role",role);
		return "Role/edit";
		
	}
	
	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbRole> role = roleService.searchRole(wd);
		PageInfo<TbRole> p = new PageInfo<>(role);
		model.addAttribute("roleList", role);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Role/index";
	}

}
