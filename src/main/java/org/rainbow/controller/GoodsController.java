package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.GoodsService;
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
 * @date 2018-04-08
 */
@Controller
@RequestMapping("/Goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/index")
	public String index(@RequestParam(value="page",defaultValue="1") int page,Model model) {
		PageHelper.startPage(page,10);
		List<TbGoods> goods = goodsService.getAllGoods();
		PageInfo<TbGoods> p=new PageInfo<>(goods);
		model.addAttribute("goodsList",goods);
		model.addAttribute("page",p);
		return "Goods/index";
	}

	@RequestMapping(value = "/{page}.html", method = RequestMethod.GET)
	public String page(@PathVariable("page") String page) {
		return "Goods/" + page;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbGoods goods) {
		Map<String, Object> result = new HashMap<>();
		if (goods == null) {
			result.put("stat",400);
			result.put("message", "缺少信息!");
		} else {
			if (goodsService.addGoods(goods) > 0) {
				result.put("stat",200);
				result.put("message","添加成功！");
			}else{
				result.put("stat",500);
				result.put("message","添加失败，请重试！");
			}
		}
		return result;
	}

	@RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id,Model model){
		TbGoods goods = goodsService.getGoodsByID(id);
		model.addAttribute("goods",goods);
		return "Goods/edit";
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable("id") long id){
		Map<String,Object> result = new HashMap<>();
		if(goodsService.deleteGoodsBystatus(id)>0){
			result.put("stat",200);
			result.put("message","删除成功！");
		}else {
			result.put("stat",500);
			result.put("message","删除失败,请重试！");
		}
		return result;
	}
}
