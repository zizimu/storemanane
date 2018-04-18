package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;
import org.rainbow.service.GoodsService;
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
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page",defaultValue = "1")int page, Model  model){
		PageHelper.startPage(page,8);
		List<TbStock> stocks = stockService.getAllStock();
		PageInfo<TbStock> p = new PageInfo<>(stocks);
		model.addAttribute("stocksList",stocks);
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		model.addAttribute("page",p);
		return "Stock/index";
	}

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public Map addStock(@RequestBody TbStock stock){
		Map<String,Object> result = new HashMap<>();
		TbStockKey temp = new TbStockKey();
		temp.setBatchId(stock.getBatchId());
		temp.setGoodsId(stock.getGoodsId());
		TbStock rs =stockService.getStockByID(temp);
		if (rs != null) {
			result.put("stat", 300);
			result.put("message", "该批次下已存在此商品!");
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
		if (id.getGoodsId()==0){
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		}else if (stockService.deleteStock(id) > 0) {
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
		if (stockService.updateStock(stock) > 0) {
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
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Stock/index";
	}

	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String go2AddPage(Model model){
		model.addAttribute("batchs",stockService.getAllBatch());
		model.addAttribute("goods",goodsService.getAllGoods());
		return "Stock/add";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET,produces = "text/plain")
	public String edit(@RequestParam("batchId")long batchId,@RequestParam("goodsId")long goodsId, Model model) {
		TbStockKey id = new TbStockKey();
		id.setBatchId(batchId);
		id.setGoodsId(goodsId);
		TbStock stock = stockService.getStockByID(id);
		model.addAttribute("stock", stock);
		model.addAttribute("batchs",stockService.getAllBatch());
		model.addAttribute("goods",goodsService.getAllGoodsIdName());
		return "Stock/edit";
	}

}
