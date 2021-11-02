package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController02 {
	@RequestMapping(value = "/index02")
	public String member02Index(Model model) {
		model.addAttribute("index", "기본 페이지 입니다.");
		return "member02/index";
	}
	@RequestMapping("/login02")
	public String member02Login(Model model) {
		model.addAttribute("login", "로그인 성공");
		return "member02/login";
	}
	@RequestMapping("logout02")
	public ModelAndView member02Logout() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout", "로그아웃 성공");
		mv.setViewName("member02/logout");
		return mv;
	}
}
