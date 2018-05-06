package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.rainbow.pojo.TbActivity;
import org.rainbow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Activity")
public class ActivityController {
	@Value("${pageSize}")
	private int pageSize;

	@Autowired
	private ActivityService activityService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page",defaultValue = "1")int page, Model  model){
		PageHelper.startPage(page,pageSize);
		List<TbActivity> activitys = activityService.getAllActivity();
		PageInfo<TbActivity> p = new PageInfo<>(activitys);
		model.addAttribute("activityList",activitys);
		model.addAttribute("page",p);
		return "Activity/index";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map addActivity(@RequestBody TbActivity activity){
		Map<String,Object> result = new HashMap<>();
		if (activity == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else if (activityService.addActivity(activity) > 0) {
			result.put("stat", 200);
			result.put("message", "添加成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败，请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Map deleteActivity(@PathVariable("id") int id){
		Map<String, Object> result = new HashMap<>();
		TbActivity activity = new TbActivity();
		activity.setActivityId(id);
		activity.setStatus(2);
		if (id == 0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (activityService.updateActivity(activity) > 0) {
			result.put("stat", 200);
			result.put("message", "删除成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "删除失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map updateActivity(@RequestBody TbActivity activity, @PathVariable("id") String id){
		Map<String, Object> result = new HashMap<>();
		if (activity == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (activityService.updateActivity(activity) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, pageSize);
		try {
			wd = new String(wd.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<TbActivity> activity = activityService.searchActivity(wd);
		PageInfo<TbActivity> p = new PageInfo<>(activity);
		model.addAttribute("activityList", activity);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Activity/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(){
		return "Activity/add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		TbActivity activity = activityService.getActivityByID(id);
		model.addAttribute("activity", activity);
		return "Activity/edit";
	}
}

