package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.TxType;
import com.bankapp.model.service.TransactionLogService;
@Controller
public class TransactionController {
	
	private TransactionLogService logservice;
	@Autowired
	public TransactionController(TransactionLogService logservice) {
	
		this.logservice = logservice;
	}
	
		@GetMapping("txlog")
		public ModelAndView alltransactions(ModelAndView mv) {
			mv.setViewName("txlog");
			mv.addObject("logs", logservice.getAllTransactions());
			return mv;
		}
		

}
