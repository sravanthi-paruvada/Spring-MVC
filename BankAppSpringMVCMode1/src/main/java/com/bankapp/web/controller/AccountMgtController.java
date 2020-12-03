package com.bankapp.web.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.AccountStatus;
import com.bankapp.model.entity.AccountType;
import com.bankapp.model.entity.User;
import com.bankapp.model.entity.UserType;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.AccountBean;
import com.bankapp.web.formbeans.DepositeBean;
import com.bankapp.web.formbeans.TransferBean;
import com.bankapp.web.formbeans.UserBean;
import com.bankapp.web.formbeans.WithdrawBean;

@Controller
public class AccountMgtController {
	
	private AccountService accountService;

	@Autowired
	public AccountMgtController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("success")
	public String success() {
		return "success";
	}
	
	@GetMapping("transfer")
	public String transferAmountGet(ModelMap model) {
		model.addAttribute("transferbean", new TransferBean());
		return "transfer";
	}

	@PostMapping("transfer")
	public String transferAmountPost(@Valid @ModelAttribute(name = "transferbean") TransferBean transferbean,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "transfer";
		}else {
		int fromAccountId=transferbean.getFromAccountId();
		int toAccountId=transferbean.getToAccountId();
		double amount=transferbean.getAmount();
		accountService.transfer(fromAccountId, toAccountId, amount);
		return "redirect:/success";
	}
	}
	
	@GetMapping("deposite")
	public String depositeAmountGet(ModelMap model) {
		model.addAttribute("depositebean", new DepositeBean());
		return "deposite";
	}
	
	@PostMapping("deposite")
	public String depositeAmountPost(@Valid @ModelAttribute(name = "depositebean") DepositeBean depositebean,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "deposite";
		}else {
		int toAccountId=depositebean.getToAccountId();
		double amount=depositebean.getAmount();
		accountService.deposite(toAccountId, amount);
		return "redirect:/success";
	}
	}
	
	@GetMapping("withdraw")
	public String withdrawAmountGet(ModelMap model) {
		model.addAttribute("withdrawbean", new WithdrawBean());
		return "withdraw";
	}
	
	@PostMapping("withdraw")
	public String withdrawAmountPost(@Valid @ModelAttribute(name = "withdrawbean") WithdrawBean withdrawbean,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "withdraw";
		}else {
		int fromAccountId=withdrawbean.getFromAccountId();
		double amount=withdrawbean.getAmount();
		accountService.withdraw(fromAccountId, amount);
		return "redirect:/success";
	}
	}
	
	@GetMapping("addaccount")
	public String addAccountrGet(ModelMap map) {
		map.addAttribute("addAccountBean", new Account());
		return "addaccount";
	}
	
	@PostMapping("addaccount")
	public String addAccountPost(@Valid @ModelAttribute("addAccountBean") Account addAccountBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/addaccount";
		} else {
			if(addAccountBean.getAccountId() == 0) {
				accountService.addAccount(addAccountBean);
			} else {
				accountService.updateAccount(addAccountBean);
			}}
		return "redirect:/home";
		}
	
	
	@GetMapping("allaccounts")
	public ModelAndView allaccounts(ModelAndView mv) {
		mv.setViewName("allaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
	}

	@GetMapping("updateaccount")
	public String updateaccount(HttpServletRequest req, ModelMap map) {
		int Id = Integer.parseInt(req.getParameter("accountId"));
		Account account = accountService.getAccountById(Id);
		map.addAttribute("addAccountBean", account);
		return "updateaccount";
	}
	
	@GetMapping("deleteaccount")
	public String deleteaccount(HttpServletRequest req) {
		int Id = Integer.parseInt(req.getParameter("accountId"));
		System.out.println(Id);
		accountService.delAccount(Id);
		return "redirect:/allaccounts";
	}
	
	
	@ModelAttribute(value = "accounttype")
	public AccountType[] accountType() {
		return AccountType.values();
	}
	@ModelAttribute(value = "accountstatus")
	public AccountStatus[] accountStatus() {
		return AccountStatus.values();
	}

}
