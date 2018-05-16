package org.rainbow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rainbow.pojo.TbStaff;
import org.rainbow.service.RoleService;
import org.rainbow.service.StaffService;
import org.rainbow.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/Staff")
public class StaffController {

	@Value("${pageSize}")
	private int pageSize1;

	private String catalog = "Staff";
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		PageHelper.startPage(page, 8);
		List<TbStaff> staff = staffService.getAllStaff();
		PageInfo<TbStaff> st = new PageInfo<>(staff);
		model.addAttribute("staffList", staff);
		model.addAttribute("page", st);
		model.addAttribute("store", storeService.getAllStores());
		model.addAttribute("role", roleService.getAllRole());
		return catalog + "/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage(Model model) {
		model.addAttribute("stores", storeService.getAllStore());
		return catalog + "/add";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbStaff staff) {
		Map<String,Object> result = new HashMap<>();
		if(staff == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息！");
		}else if(staffService.addStaff(staff)>0) {
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
	public Map delete(@PathVariable("id")  long id) {
		Map<String,Object> result = new HashMap<>();
		TbStaff staff = new TbStaff();
		staff.setStaffId(id);
		staff.setStatus(2);
		if(id == 0) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(staffService.updateStaff(staff)>0) {
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
	public Map update(@RequestBody TbStaff staff,@PathVariable("id") String id) {
		Map<String,Object> result = new HashMap<>();
		if(staff == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(staffService.updateStaff(staff)>0) {
			result.put("stat", 200);
		}else{
			result.put("stat", 500);
			result.put("message", "修改失败，请重试！");
		}
		return result;		
	}
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id,Model model) {
		TbStaff staff = staffService.getStaffById(id);
		model.addAttribute("staff",staff);
		return catalog+"/edit";
		
	}
	
	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbStaff> staff = staffService.searchStaff(wd);
		PageInfo<TbStaff> p = new PageInfo<>(staff);
		model.addAttribute("staffList", staff);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return catalog+"/index";
	}

}
