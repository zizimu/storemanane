package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbBrand;
import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;
import org.rainbow.service.StockService;
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
 * @date 2018-04-16
 */
@Controller
@RequestMapping("/Stock") 
public class StockController {

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page",defaultValue = "1")int page, Model  model){
		PageHelper.startPage(page,8);
		List<TbStock> stocks = stockService.getAllStock();
		PageInfo<TbStock> p = new PageInfo<>(stocks);
		model.addAttribute("brandsList",stocks);
		model.addAttribute("page",p);
		return "Stock/index";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map addStock(@RequestBody TbStock stock){
		Map<String,Object> result = new HashMap<>();
		if (stock == null) {
			result.put("stat", 400);
			result.put("message", "缺少信息!");
		} else if (stockService.addStock(stock) > 0) {
			result.put("stat", 200);
			result.put("message", "添加成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败，请重试！");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE,consumes = "application/json")
	@ResponseBody
	public Map deleteStock(@RequestBody TbStockKey id){
		Map<String, Object> result = new HashMap<>();
		TbStock stock = new TbStock();
		stock.setBatchId(id.getBatchId());
		stock.setGoodsId(id.getGoodsId());
		stock.setStatus(2);
		if (id.getGoodsId()==0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (stockService.updateStock(stock) > 0) {
			result.put("stat", 200);
			result.put("message", "删除成功！");
		} else {
			result.put("stat", 500);
			result.put("message", "删除失败,请重试！");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map updateStock(@RequestBody TbStock stock){
		Map<String, Object> result = new HashMap<>();
		if (stock == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (stockService.updateStock(stock) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/s",method = RequestMethod.GET)
	public String search(@RequestParam("wd")String wd, @RequestParam(value = "page", defaultValue = "1") int page, Model model){
		PageHelper.startPage(page, 8);
		List<TbStock> stock = stockService.searchStock(wd);
		PageInfo<TbStock> p = new PageInfo<>(stock);
		model.addAttribute("stocksList", stock);
		model.addAttribute("wd",wd);
		model.addAttribute("page", p);
		return "Stock/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(Model model){
		model.addAttribute("batchs",stockService.getAllBatch());
		return "Stock/add";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestBody TbStockKey id, Model model) {
		TbStock stock = stockService.getStockByID(id);
		model.addAttribute("brand", stock);
		return "Stock/edit";
	}

}
