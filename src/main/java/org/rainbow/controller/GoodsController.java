package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.BrandService;
import org.rainbow.service.GoodsService;
import org.rainbow.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
@Controller
@RequestMapping("/Goods")
public class GoodsController {

	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor cust = new CustomDateEditor(sdf,true);
		bin.registerCustomEditor(Date.class,cust);
	}

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		PageHelper.startPage(page, 8);
		List<TbGoods> goods = goodsService.getAllGoods();
		PageInfo<TbGoods> p = new PageInfo<>(goods);
		model.addAttribute("goodsList", goods);
		model.addAttribute("page", p);
		model.addAttribute("brands",brandService.getAllBrandName());
		model.addAttribute("types",typeService.getAllTypeName());
		return "Goods/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(Model model){
		model.addAttribute("brands",brandService.getAllBrand());
		model.addAttribute("types",typeService.getAllType());
		return "Goods/add";
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
		model.addAttribute("brands",brandService.getAllBrand());
		model.addAttribute("types",typeService.getAllType());
		return "Goods/edit";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable("id") long id) {
		Map<String, Object> result = new HashMap<>();
		if (id == 0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (goodsService.deleteGoodsBystatus(id) > 0) {
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

	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbGoods> goods = goodsService.searchGoods(wd);
		PageInfo<TbGoods> p = new PageInfo<>(goods);
		model.addAttribute("goodsList", goods);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		model.addAttribute("brands",brandService.getAllBrandName());
		model.addAttribute("types",typeService.getAllTypeName());
		return "Goods/index";
	}
}