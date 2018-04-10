package org.rainbow.controller;

import com.google.gson.Gson;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/Node")
public class CommodityController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/index")
	public String index() {
		return "Node/index";
	}

	@RequestMapping(value = "/{page}.html", method = RequestMethod.GET)
	public String page(@PathVariable("page") String page) {
		return "Node/" + page;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbGoods goods) {
		Map<String, Object> result = new HashMap<>();
		if (goods == null) {
			result.put("message", "缺少信息!");
		} else {
			if (goodsService.addGoods(goods) > 0) {
				result.put("message","添加成功！");
			}else{
				result.put("message","添加失败，请重试！");
			}
		}
		return result;
	}

}
