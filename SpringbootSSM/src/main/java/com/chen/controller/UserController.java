package com.chen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.bean.User;
import com.chen.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("list")
	@ResponseBody
	public List<User> getAll() {
		List<User> all = userService.getAll();
		return all;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
}
