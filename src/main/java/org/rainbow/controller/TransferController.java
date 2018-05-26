//package org.rainbow.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//
//import org.rainbow.service.GoodsService;
//import org.rainbow.service.StockService;
//import org.rainbow.service.StoreService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/transfer")
//@SessionAttributes(value = {"pageSize", "user"})
//public class TransferController {
//	@Autowired
//	private StockService stockService;
//	@Autowired
//	private GoodsService goodsService;
//	@Autowired
//	private StoreService storeService;
//
//	@RequestMapping("/information")
//	public String toPerson(@ModelAttribute("user") TbAccount account, Model model) {
//		model.addAttribute("account", account);
//		return "transfer/index";
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String allAccount(@RequestParam(value = "page", defaultValue = "1") int page, Model model, @ModelAttribute("pageSize") int pageSize) {
//		PageHelper.startPage(page, pageSize);
//		List<TbAccount> accounts = accountService.getAllAccount();
//		PageInfo<TbAccount> p = new PageInfo<>(accounts);
//		model.addAttribute("accounts", accounts);
//		model.addAttribute("page", p);
//		model.addAttribute("status", accountService.getAllStatus());
//		model.addAttribute("stores", storeService.getAllStores());
//		return "account/index";
//	}
//
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String edit(@PathVariable("id") long id, Model model) {
//		TbAccount account = accountService.getAccountByID(id);
//		model.addAttribute("account", account);
//		model.addAttribute("status", accountService.getAllStatus());
//		model.addAttribute("stores", storeService.getAllStores());
//		return "account/edit";
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
//	@ResponseBody
//	public Map updateInformation(@PathVariable("id") String id, @RequestBody TbAccount account) {
//		Map<String, Object> result = new HashMap<>();
//		if (account == null) {
//			result.put("stat", 400);
//			result.put("message", "信息缺失,请重试！");
//		} else if (accountService.updateAccount(account) > 0) {
//			result.put("stat", 200);
//		} else {
//			result.put("stat", 500);
//			result.put("message", "更新失败,请重试！");
//		}
//		return result;
//	}
//
//	@RequestMapping(value = "/pwdCheck", method = RequestMethod.POST)
//	@ResponseBody
//	public Map pwdCheck(@RequestParam("pwd") String pwd, @ModelAttribute("user") TbAccount account) {
//		Map<String, Object> result = new HashMap<>();
//		Encryption en = Encryption.getInstance();
//		if (pwd == null) {
//			result.put("stat", 400);
//			result.put("message", "密码缺失！");
//		} else if (account.getPassword().equals(en.byte2BASE64(en.passwordEncry(pwd)))) {
//			result.put("stat", 200);
//		} else {
//			result.put("stat", 500);
//			result.put("message", "密码错误！");
//		}
//		return result;
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
//	@ResponseBody
//	public Map updateAccount(@RequestBody TbAccount account, ModelMap modelMap, HttpSession session) {
//		Map<String, Object> result = new HashMap<>();
//		if (account == null) {
//			result.put("stat", 400);
//			result.put("message", "信息缺失,请重试！");
//		} else {
//			if (account.getPassword() != null) {
//				Encryption en = Encryption.getInstance();
//				account.setPassword(en.byte2BASE64(en.passwordEncry(account.getPassword())));
//			}
//			if (accountService.updateAccount(account) > 0) {
//				account = accountService.getAccountByID(account.getSid());
//				modelMap.addAttribute("user", account);
//				result.put("stat", 200);
//			} else {
//				result.put("stat", 500);
//				result.put("message", "更新失败,请重试！");
//			}
//		}
//		return result;
//	}
//}
