package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entity.User;
import com.bankapp.model.entity.UserType;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.UserBean;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("userBean") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adduser";
		} else {
			userService.addUser(user);
		return "redirect:/home";
		}
	}
	
	@ModelAttribute(value = "usertype")
	public UserType[] userType() {
		return UserType.values();
	}

}