package org.rainbow.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.rainbow.pojo.TbGoods;
import org.rainbow.pojo.TbOrder;
import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStore;
import org.rainbow.pojo.TbTransfer;
import org.rainbow.service.GoodsService;
import org.rainbow.service.StockService;
import org.rainbow.service.StoreService;
import org.rainbow.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/transfer")
@SessionAttributes(value = {"pageSize", "user"})
public class TransferController {
	@Autowired
	private StockService stockService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private TransferService transervice;
	
	@RequestMapping("listAllTransfer")
	public String listAllTransfer(@RequestParam(value = "page", defaultValue = "1")int page, Model model, @ModelAttribute("pageSize") int pageSize) {
		PageHelper.startPage(page, pageSize);
		List<TbTransfer> transfers =transervice.findAllCheckTransfer();
		PageInfo<TbTransfer> p = new PageInfo<>(transfers);
		for (TbTransfer tbTransfer : transfers) {
			TbStore store;
			if(tbTransfer.getStore_fromid()!=null&&!"".equals(tbTransfer.getStore_fromid())) {
				store=storeService.getStoreById(tbTransfer.getStore_fromid());
				tbTransfer.setStore(store);
			}
			if(tbTransfer.getStore_toid()!=null&&!"".equals(tbTransfer.getStore_toid())) {
				store=storeService.getStoreById(tbTransfer.getStore_toid());
				tbTransfer.setToStore(store);
			}
			TbGoods goods=goodsService.getGoodsByID(tbTransfer.getGoods_id());
			tbTransfer.setGoods(goods);
		}
		model.addAttribute("page", p);
		model.addAttribute("transferList", transfers);
		return "transfer/index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		System.out.println("id=="+id);
		List<TbStore> stores=storeService.getAllStore();
		TbTransfer transfer=transervice.findCheckTransfer(id);
		TbStore store;
		if(transfer.getStore_toid()!=null&&!"".equals(transfer.getStore_toid())) {
			store=storeService.getStoreById(transfer.getStore_toid());
			transfer.setToStore(store);
		}
		TbGoods goods=goodsService.getGoodsByID(transfer.getGoods_id());
		transfer.setGoods(goods);
		model.addAttribute("transfer", transfer);
		model.addAttribute("stores", stores);
		return "transfer/edit";
	}
	
	@RequestMapping(value="/checkTransfer", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map updateAccount(@RequestBody TbTransfer transfer, ModelMap modelMap) {
		System.out.println("调货");
		Map<String, Object> result = new HashMap<>();
		transfer.setStatus(2);
		transervice.updateTransfer(transfer);
		System.out.println("更新TbTransfer表");
		TbStock fromStock=stockService.findStockBygoodid(transfer.getGoods_id(), transfer.getStore_fromid());
		TbStock tostock=stockService.findStockBygoodid(transfer.getGoods_id(), transfer.getStore_toid());
		if(fromStock!=null) {
			if(fromStock.getGoodsStock()<transfer.getGoods_num()) {
				result.put("stat", 400);
				result.put("message", "该店的货源不足，请重新选择数量！");
				return result;
			}else {
				fromStock.setGoodsStock(fromStock.getGoodsStock()-transfer.getGoods_num());
				stockService.updateStockBygoodsid(fromStock);
				if(tostock!=null) {
					tostock.setGoodsStock(tostock.getGoodsStock()+transfer.getGoods_num());
					stockService.updateStockBygoodsid(tostock);
				}else {
					TbStock stock=new TbStock();
					stock.setGoodsId(transfer.getGoods_id());
					stock.setCreateTime(new Date(new java.util.Date().getTime()));
					stock.setGoodsStock(transfer.getGoods_num());
					stock.setStoreId(transfer.getStore_toid());
					stock.setStatus(1);
					stockService.addStock(stock);
				}
				result.put("stat", 200);
				result.put("message", "调货成功！");
				return result;
			}
			
		}else {
			result.put("stat", 400);
			result.put("message", "该店没有这种货源！");
			return result;
		}
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTransfer/{id}")
	@ResponseBody
	public Map delete(@PathVariable("id") long id) {
		Map<String, Object> result = new HashMap<>();
		System.out.println("删除...");
		TbTransfer transfer=transervice.findCheckTransfer(id);
		transfer.setStatus(3);
		transervice.updateTransfer(transfer);
		result.put("stat", 200);
		result.put("message", "删除成功");
		return result;
	}

	/*@RequestMapping("/information")
	public String toPerson(@ModelAttribute("user") TbAccount account, Model model) {
		model.addAttribute("account", account);
		return "transfer/index";
	}*/

	/*@RequestMapping(method = RequestMethod.GET)
	public String allAccount(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("pageSize") int pageSize) {
		PageHelper.startPage(page, pageSize);
		List<TbAccount> accounts = accountService.getAllAccount();
		PageInfo<TbAccount> p = new PageInfo<>(accounts);
		model.addAttribute("accounts", accounts);
		model.addAttribute("page", p);
		model.addAttribute("status", accountService.getAllStatus());
		model.addAttribute("stores", storeService.getAllStores());
		return "account/index";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {
		TbAccount account = accountService.getAccountByID(id);
		model.addAttribute("account", account);
		model.addAttribute("status", accountService.getAllStatus());
		model.addAttribute("stores", storeService.getAllStores());
		return "account/edit";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map updateInformation(@PathVariable("id") String id, @RequestBody TbAccount account) {
		Map<String, Object> result = new HashMap<>();
		if (account == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else if (accountService.updateAccount(account) > 0) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "更新失败,请重试！");
		}
		return result;
	}

	@RequestMapping(value = "/pwdCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map pwdCheck(@RequestParam("pwd") String pwd, @ModelAttribute("user") TbAccount account) {
		Map<String, Object> result = new HashMap<>();
		Encryption en = Encryption.getInstance();
		if (pwd == null) {
			result.put("stat", 400);
			result.put("message", "密码缺失！");
		} else if (account.getPassword().equals(en.byte2BASE64(en.passwordEncry(pwd)))) {
			result.put("stat", 200);
		} else {
			result.put("stat", 500);
			result.put("message", "密码错误！");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public Map updateAccount(@RequestBody TbAccount account, ModelMap modelMap, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		if (account == null) {
			result.put("stat", 400);
			result.put("message", "信息缺失,请重试！");
		} else {
			if (account.getPassword() != null) {
				Encryption en = Encryption.getInstance();
				account.setPassword(en.byte2BASE64(en.passwordEncry(account.getPassword())));
			}
			if (accountService.updateAccount(account) > 0) {
				account = accountService.getAccountByID(account.getSid());
				modelMap.addAttribute("user", account);
				result.put("stat", 200);
			} else {
				result.put("stat", 500);
				result.put("message", "更新失败,请重试！");
			}
		}
		return result;
	}*/
}
