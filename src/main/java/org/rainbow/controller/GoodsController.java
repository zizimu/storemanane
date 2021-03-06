package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbAccount;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.BrandService;
import org.rainbow.service.GoodsService;
import org.rainbow.service.TypeService;
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
@RequestMapping("/Goods")
@SessionAttributes({"pageSize", "user"})
public class GoodsController {

	@Value("${pageSize}")
	private int pageSize1;

	private String catalog = "Goods";

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private BrandService brandService;
//展示全部商品信息
	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("pageSize") int pageSize, @ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		List<TbGoods> goods = goodsService.getAllGoods();
		PageInfo<TbGoods> p = new PageInfo<>(goods);
		model.addAttribute("goodsList", goods);
		model.addAttribute("page", p);
		model.addAttribute("brands", brandService.getAllBrandName());
		model.addAttribute("types", typeService.getAllTypeName());
		model.addAttribute("units", typeService.getAllUnits());
		model.addAttribute("status", account.getStatus());
		return catalog + "/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String go2AddPage(Model model) {
		model.addAttribute("brands", brandService.getAllBrand());
		model.addAttribute("types", typeService.getAllType());
		model.addAttribute("units", typeService.getAllUnits());
		return catalog + "/add";
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbGoods goods) {
		Map<String, Object> result = new HashMap<>();
		if (goods == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else if (goodsService.addGoods(goods) > 0) {
			result.put("stat", 200);
			result.put("message", "添加成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败，请重试！");
		}
		return result;
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbGoods goods = goodsService.getGoodsByID(id);
		model.addAttribute("goods", goods);
		model.addAttribute("brands", brandService.getAllBrand());
		model.addAttribute("types", typeService.getAllType());
		model.addAttribute("units", typeService.getAllUnits());
		return catalog + "/edit";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable("id") long id) {
		Map<String, Object> result = new HashMap<>();
		if (id == 0) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (goodsService.deleteGoodsBystatus(id) > 0) {
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
	public Map updateGoods(@PathVariable("id") String id, @RequestBody TbGoods tbGoods) {
		Map<String, Object> result = new HashMap<>();
		if (tbGoods == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (goodsService.updateGoods(tbGoods) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public String search(@RequestParam("wd") String wd, @RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("pageSize") int pageSize, @ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		try {
			wd = new String(wd.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			e.printStackTrace();
		}
		List<TbGoods> goods = goodsService.searchGoods(wd);
		PageInfo<TbGoods> p = new PageInfo<>(goods);
		model.addAttribute("goodsList", goods);
		model.addAttribute("wd", wd);
		model.addAttribute("page", p);
		model.addAttribute("brands", brandService.getAllBrandName());
		model.addAttribute("types", typeService.getAllTypeName());
		model.addAttribute("units", typeService.getAllUnits());
		model.addAttribute("status", account.getStatus());
		return catalog + "/index";
	}
}