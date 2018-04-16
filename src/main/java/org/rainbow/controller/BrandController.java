package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbBrand;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-14
 */
@Controller
@RequestMapping("/Brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page",defaultValue = "1")int page, Model  model){
		PageHelper.startPage(page,8);
		List<TbBrand> brands = brandService.getAllBrand();
		PageInfo<TbBrand> p = new PageInfo<>(brands);
		model.addAttribute("brandsList",brands);
		model.addAttribute("page",p);
		return "Brand/index";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map addBrand(@RequestBody TbBrand brand){
		Map<String,Object> result = new HashMap<>();
		if (brand == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else if (brandService.addBrand(brand) > 0) {
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
		TbBrand brand = new TbBrand();
		brand.setBrandId(id);
		brand.setStatus(2);
		if (id == 0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (brandService.updateBrand(brand) > 0) {
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
	public Map updateBrand(@RequestBody TbBrand brand, @PathVariable("id") String id){
		Map<String, Object> result = new HashMap<>();
		if (brand == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (brandService.updateBrand(brand) > 0) {
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
		List<TbBrand> brands = brandService.searchBrand(wd);
		PageInfo<TbBrand> p = new PageInfo<>(brands);
		model.addAttribute("brandsList", brands);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Brand/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(){
		return "Brand/add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbBrand brand = brandService.getBrandByID(id);
		model.addAttribute("brand", brand);
		return "Brand/edit";
	}
}

