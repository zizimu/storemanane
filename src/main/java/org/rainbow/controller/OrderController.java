package org.rainbow.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.rainbow.pojo.TbAccount;
import org.rainbow.pojo.TbGoods;
import org.rainbow.pojo.TbOrder;
import org.rainbow.pojo.TbStock;
import org.rainbow.service.GoodsService;
import org.rainbow.service.OrderService;
import org.rainbow.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model,HttpServletRequest request) {
		PageHelper.startPage(page, 8);
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");
		System.out.println("account=="+account.getStoreid());
		List<TbOrder> order =new ArrayList<>();
		if(account.getStoreid()==8) {
			order = orderService.getAllOrder();
		}else {
			order =orderService.findOrderBystoreid(account.getStoreid());
		}
		System.out.println("orqder=="+order.size());
		for (TbOrder tbOrder : order) {
			TbGoods goods=goodsService.getGoodsByID(tbOrder.getGoodsId());
			BigDecimal price=goods.getGoodsPrice().multiply(BigDecimal.valueOf(tbOrder.getGoodsNum()));
			System.out.println("price=="+price);
			tbOrder.setTotalPrice(price);
		}
		PageInfo<TbOrder> st = new PageInfo<>(order);
		model.addAttribute("orderList", order);
		model.addAttribute("page", st);
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Order/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");
		List<TbStock> stocks;
		System.out.println("status=="+account.getStatus());
		if (account.getStatus() > 2) {
			stocks = stockService.getAllStock();
		} else {
			stocks = stockService.getAllStockByStoreID(account.getStoreid());
		}
		List<TbGoods> goods=new ArrayList<>();
		System.out.println("stocks=="+stocks.size());
		for (TbStock tbStock : stocks) {
			System.out.println("goodid=="+tbStock.getGoodsId());
			TbGoods god=goodsService.getGoodsByID(tbStock.getGoodsId());
			if(!goods.contains(god)) {
				goods.add(god);
			}
		}
		model.addAttribute("goods",goods);
		//model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Order/add";
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map add(@RequestBody TbOrder order,HttpSession session) {
		System.out.println("添加订单！！");
		TbAccount account=(TbAccount) session.getAttribute("user");
		Map<String, Object> result = new HashMap<>();
		System.out.println("storeid=="+order.getStore_id());
		TbStock tbstock=stockService.findStockBygoodid(order.getGoodsId(),account.getStoreid());
		if (order == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息！");
			return result;
		}
		if(order.getGoodsNum()>tbstock.getGoodsStock()) {
				result.put("stat", 400);
				result.put("message", "库存不足！！");
				return result;
		}else if (orderService.addOrder(order) > 0) {
			tbstock.setGoodsStock(tbstock.getGoodsStock()-order.getGoodsNum());
			tbstock.setGoodsSold(tbstock.getGoodsSold()+order.getGoodsNum());
			stockService.updateStockBygoodsid(tbstock);
			result.put("stat", 200);
			result.put("message", "添加成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败，请重试！");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseBody
	public Map delete(@PathVariable("id") long id) {
		Map<String, Object> result = new HashMap<>();
		TbOrder order = new TbOrder();
		order.setOrderId(id);
		order.setStatus(2);
		if (id == 0) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		} else if (orderService.updateOrder(order) > 0) {
			result.put("stat", 200);
			result.put("message", "删除成功！");
		} else {
			result.put("start", 500);
			result.put("message", "删除失败，请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map update(@RequestBody TbOrder order, @PathVariable("id") String id) {
		Map<String, Object> result = new HashMap<>();
		if (order == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息,请重试！");
		} else if (orderService.updateOrder(order) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "修改失败，请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbOrder order = orderService.getOrderById(id);
		model.addAttribute("order", order);
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Order/edit";

	}

	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public String search(@RequestParam("wd") String wd, @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		PageHelper.startPage(page, 8);
		try {
			wd = new String(wd.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			e.printStackTrace();
		}
		List<TbOrder> order = orderService.searchOrder(wd);
		PageInfo<TbOrder> p = new PageInfo<>(order);
		model.addAttribute("orderList", order);
		model.addAttribute("wd", wd);
		model.addAttribute("page", p);
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Order/index";
	}

}
