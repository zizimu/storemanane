package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.rainbow.pojo.TbAccount;
import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;
import org.rainbow.pojo.TbStore;
import org.rainbow.pojo.TbTransfer;
import org.rainbow.service.GoodsService;
import org.rainbow.service.StockService;
import org.rainbow.service.StoreService;
import org.rainbow.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/Stock")
@SessionAttributes("user")
public class StockController {

	@Value("${pageSize}")
	private int pageSize;

	private String catalog = "Stock";

	@Autowired
	private StockService stockService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private TransferService tranService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		List<TbStock> stocks;
		if (account.getStatus() > 2) {
			stocks = stockService.getAllStock();
		} else {
			stocks = stockService.getAllStockByStoreID(account.getStoreid());
		}
		PageInfo<TbStock> p = new PageInfo<>(stocks);
		model.addAttribute("stocksList", stocks);
		model.addAttribute("goods", goodsService.getAllGoodsIdName());
		model.addAttribute("page", p);
		model.addAttribute("stores", storeService.getAllStores());
		return catalog + "/index";
	}

	@RequestMapping(value="addStocks",method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map addStocks(@RequestBody TbStock stock,HttpServletRequest request) {
		System.out.println(2121);
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");
		Map<String, Object> result = new HashMap<>();
		TbStockKey temp = new TbStockKey();
		temp.setBatchId(stock.getBatchId());
		temp.setGoodsId(stock.getGoodsId());
		System.out.println("bun=="+stock.getGoodsStock());
		TbStock rs =stockService.findStockBygoodid(stock.getGoodsId(),account.getStoreid());
	/*	根据货物的id查找，如果有，相加，如果没有，生成一条记录*/
		if(rs!=null) {
			System.out.println("1212");
			rs.setGoodsStock(rs.getGoodsStock()+stock.getGoodsStock());
			stockService.updateStockBygoodsid(rs);
			result.put("stat", 200);
			result.put("message", "添加成功！");
		}else {
			int a=stockService.addStock(stock);
			if(a>0) {
				result.put("stat", 200);
				result.put("message", "添加成功！");
			}else {
				result.put("stat", 500);
				result.put("message", "添加失败，请重试！");
			}
		}
		//TbStock rs = stockService.getStockByID(temp);
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseBody
	public Map deleteStock(@RequestBody TbStockKey id) {
		Map<String, Object> result = new HashMap<>();
		if (id.getGoodsId() == 0) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (stockService.deleteStock(id) > 0) {
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
	public Map updateStock(@RequestBody TbStock stock) {
		Map<String, Object> result = new HashMap<>();
		if (stockService.updateStock(stock) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "添加失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public String search(@RequestParam("wd") String wd, @RequestParam(value = "page", defaultValue = "1") int page, Model model,@ModelAttribute("user") TbAccount account) {
		PageHelper.startPage(page, pageSize);
		try {
			wd = new String(wd.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			e.printStackTrace();
		}
		List<TbStock> stock;
		if (account.getStatus() > 2) {
			stock = stockService.searchStock(wd);
		} else {
			stock = stockService.searchStockInStore(wd,account.getStoreid());
		}
		PageInfo<TbStock> p = new PageInfo<>(stock);
		model.addAttribute("stocksList", stock);
		model.addAttribute("wd", wd);
		model.addAttribute("page", p);
		model.addAttribute("goods", goodsService.getAllGoodsIdName());
		model.addAttribute("stores", storeService.getAllStores());
		return catalog + "/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage(Model model,HttpServletRequest request) {
		/*通过当前用户找到店铺*/
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");
		TbStore store=storeService.getStoreById(account.getStoreid());
		/*后面找到  前面放到前端页面*/
		model.addAttribute("store", store);
		//model.addAttribute("batchs", stockService.getAllBatch());
		model.addAttribute("goods", goodsService.getAllGoods());
		//model.addAttribute("stores", storeService.getAllStores());
		return catalog + "/add";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET, produces = "text/plain")
	public String edit( @RequestParam("goodsId") long goodsId, Model model,HttpServletRequest request) {
		//TbStockKey id = new TbStockKey();
		//id.setBatchId(batchId);
		//id.setGoodsId(goodsId);
		/*TbStock stock = stockService.getStockByID(goodsId);*/
		//System.out.println("storeid"+storeid);
		/*通过当前用户找到店铺*/
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");

		TbStock stock = stockService.findStockBygoodid(goodsId,account.getStoreid());
		//System.out.println("stock"+stock);
		model.addAttribute("stock", stock);
		model.addAttribute("batchs", stockService.getAllBatch());
		model.addAttribute("goods", goodsService.getAllGoodsIdName());
		model.addAttribute("stores", storeService.getAllStores());
		return catalog + "/edit";
	}

	/*@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseBody
	public Map checkGoods(@RequestParam("batchID") String batchID, @RequestParam("goodsID") String goodsID) {
		Map<String, Object> result = new HashMap<>();
		if (stockService.isGoodsByBatch(batchID, goodsID)) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "已存在,请重新选择！");
		}
		return result;
	}*/
	/*向总部申请调货*/
	@RequestMapping(value="transfer",method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map addTTransfer(@RequestBody TbStock stock,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		System.out.println("申请调货");
		HttpSession session=request.getSession();
		TbAccount account=(TbAccount) session.getAttribute("user");
		TbTransfer transfer=new TbTransfer();
		transfer.setGoods_id(stock.getGoodsId());
		Date date=new Date();
		transfer.setCreatetime(new java.sql.Date(date.getTime()));
		System.out.println("num=="+stock.getGoodsStock());
		transfer.setGoods_num(stock.getGoodsStock());
		transfer.setStore_toid(account.getStoreid());
		transfer.setStatus(1);
		int st=tranService.addTransfer(transfer);
		if(st>0) {
			result.put("stat", 200);
			result.put("message", "申请成功！");
		}else {
			result.put("stat", 500);
			result.put("message", "申请失败，请重试！");
		}
		return result;
	}
	
	@RequestMapping(value = "/tranAdd", method = RequestMethod.GET)
	public String gotoTransfer(Model model) {
		//model.addAttribute("batchs", stockService.getAllBatch());
		model.addAttribute("goods", goodsService.getAllGoods());
		//model.addAttribute("stores", storeService.getAllStores());
		return catalog + "/tranAdd";
	}


}
