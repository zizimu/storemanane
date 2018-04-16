package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbGoodsType;
import org.rainbow.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ross
 */
@Controller
@RequestMapping("/Type")
public class TypeController {

	@Autowired
	private TypeService typeService;


	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page",defaultValue = "1")int page, Model  model){
		PageHelper.startPage(page,8);
		List<TbGoodsType> types = typeService.getAllType();
		PageInfo<TbGoodsType> p = new PageInfo<>(types);
		model.addAttribute("typesList",types);
		model.addAttribute("page",p);
		return "Type/index";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map addBrand(@RequestBody TbGoodsType type){
		Map<String,Object> result = new HashMap<>();
		if (type == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else if (typeService.addType(type) > 0) {
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
	public Map deleteBrand(@PathVariable("id") long id){
		Map<String, Object> result = new HashMap<>();
		TbGoodsType type = new TbGoodsType();
		type.setTypeId(id);
		type.setStatus(2);
		if (id == 0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (typeService.updateType(type) > 0) {
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
	public Map updateBrand(@RequestBody TbGoodsType type, @PathVariable("id") String id){
		Map<String, Object> result = new HashMap<>();
		if (type == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (typeService.updateType(type) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbGoodsType> types = typeService.searchType(wd);
		PageInfo<TbGoodsType> p = new PageInfo<>(types);
		model.addAttribute("typesList", types);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Type/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(){
		return "Type/add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbGoodsType type = typeService.getTypeByID(id);
		model.addAttribute("type", type);
		return "Type/edit";
	}

}
