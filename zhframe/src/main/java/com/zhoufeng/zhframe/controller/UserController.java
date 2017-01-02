package com.zhoufeng.zhframe.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserController {

	@RequestMapping(value="/save")
	public ModelAndView saveUser() {
		ModelAndView view = new ModelAndView("/jsps/testPage");
		return view;
	}
}
