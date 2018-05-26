package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbAccount;
import org.rainbow.pojo.TbBrand;
import org.rainbow.service.BrandService;
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
@RequestMapping("/Brand")
@SessionAttributes("user")
public class BrandController {
	@Value("${pageSize}")
	private int pageSize;

	@Autowired
	private BrandService brandService;
//全部
	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		List<TbBrand> brands = brandService.getAllBrand();
		PageInfo<TbBrand> p = new PageInfo<>(brands);
		model.addAttribute("brandsList", brands);
		model.addAttribute("page", p);
		model.addAttribute("status", account.getStatus());
		return "Brand/index";
	}
//添加
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map addBrand(@RequestBody TbBrand brand) {
		Map<String, Object> result = new HashMap<>();
		System.out.println("name=="+brand.getBrandName());
		TbBrand brand2=brandService.getTbBrandByname(brand.getBrandName());
		if (brand == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		}
		if(brand2==null) {
			 if (brandService.addBrand(brand) > 0) {
				result.put("stat", 200);
				result.put("message", "添加成功！");
			} else {
				result.put("stat", 500);
				result.put("message", "添加失败，请重试！");
			}
		}else {
			result.put("stat", 300);
			result.put("message", "添加失败,该品牌已存在！");
		}
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map deleteBrand(@PathVariable("id") long id) {
		Map<String, Object> result = new HashMap<>();
		TbBrand brand = new TbBrand();
		brand.setBrandId(id);
		brand.setStatus(2);
		if (id == 0) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (brandService.updateBrand(brand) > 0) {
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
	public Map updateBrand(@RequestBody TbBrand brand, @PathVariable("id") String id) {
		System.out.println(11);
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

	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public String search(@RequestParam("wd") String wd, @RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		try {
			wd = new String(wd.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			e.printStackTrace();
		}
		List<TbBrand> brands = brandService.searchBrand(wd);
		PageInfo<TbBrand> p = new PageInfo<>(brands);
		model.addAttribute("brandsList", brands);
		model.addAttribute("wd", wd);
		model.addAttribute("page", p);
		model.addAttribute("status", account.getStatus());
		return "Brand/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String go2AddPage() {
		return "Brand/add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbBrand brand = brandService.getBrandByID(id);
		model.addAttribute("brand", brand);
		return "Brand/edit";
	}
}

