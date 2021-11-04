package com.care.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("signup_save")
	public String signup_save(HttpServletRequest request, Model model,
								@RequestParam("id") String id,
								@RequestParam("pwd") String pwd,
								@RequestParam("name") String name) {
		System.out.println("signup_save post방식으로 들어옴");
		
//		model.addAttribute("id", id);
//		model.addAttribute("pwd", pwd);
//		model.addAttribute("name", name);
		
		int result = ms.insert(id, pwd, name);
		
		model.addAttribute("result", result);
		
		return "signup_save";
	}
	
	@GetMapping("membership")
	public String membership(HttpServletRequest request, Model model) {
		model.addAttribute("list", ms.select());
		return "membership";
	}
}
