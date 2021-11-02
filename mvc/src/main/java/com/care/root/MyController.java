package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value = "/index")
	public String memberIndex() {
		return "member/index";
	}
	@RequestMapping("logout")
	public String memberLogout(Model model) {
		model.addAttribute("key", "로그아웃 완료");
		return "member/logout";
	}
	@RequestMapping("/login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "로그인 성공");
		mv.setViewName("member/login");
		return mv;
	}
}
