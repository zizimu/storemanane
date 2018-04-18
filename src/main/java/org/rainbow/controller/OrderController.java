package org.rainbow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rainbow.pojo.TbOrder;
import org.rainbow.service.OrderService;
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
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		PageHelper.startPage(page, 8);
		List<TbOrder> order = orderService.getAllOrder();
		PageInfo<TbOrder> st = new PageInfo<>(order);
		model.addAttribute("orderList", order);
		model.addAttribute("page", st);
		return "Order/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage() {
		return "Order/add";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbOrder order) {
		Map<String,Object> result = new HashMap<>();
		if(order == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息！");
		}else if(orderService.addOrder(order)>0) {
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
		TbOrder order = new TbOrder();
		order.setOrderId(id);
		order.setStatus(2);
		if(id == 0) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(orderService.updateOrder(order)>0) {
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
	public Map update(@RequestBody TbOrder order,@PathVariable("id") String id) {
		Map<String,Object> result = new HashMap<>();
		if(order == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		}else if(orderService.updateOrder(order)>0) {
			result.put("stat", 200);
		}else{
			result.put("stat", 500);
			result.put("message", "修改失败，请重试！");
		}
		return result;		
	}
	
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id,Model model) {
		TbOrder order = orderService.getOrderById(id);
		model.addAttribute("order",order);
		return "Order/edit";
		
	}
	
	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd,@RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbOrder> order = orderService.searchOrder(wd);
		PageInfo<TbOrder> p = new PageInfo<>(order);
		model.addAttribute("orderList", order);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Order/index";
	}

}
