package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("userChk")
	public String loginlogin(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							HttpSession session) {
		if(ms.userChk(id, pw) == 0) { // 로그인 실패
			return "member/failLogin";
		}else { // 로그인 성공
			session.setAttribute("loginUser", id);
			return "member/successLogin";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	@GetMapping("memberinfo")
	public String memberinfo(Model model) {
		ArrayList<MemberDTO> list = ms.memberinfo();
		model.addAttribute("memberList", list);
		return "member/memberinfo";
	}
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("register_save")
	public String register_save(MemberDTO dto, Model model) {
		model.addAttribute("result", ms.memberRegister(dto));
		return "member/register_save";
	}
	@GetMapping("/info")
	public String info(Model model, @RequestParam("id") String id) {
		ms.info(model, id);
		return "member/info";
	}
}
