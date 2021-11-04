package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	public MemberController() {
		System.out.println("MemberController 생성자 실행");
	}
	@Autowired
	MemberService ms;
	
	@GetMapping("/index")
	public String memberIndex() {
		return "/member/index";
	}
	
	@RequestMapping("login")
	public String login(Model model, RedirectAttributes re,
				@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		ms.login(id, pwd, model);
		re.addFlashAttribute("reMap", model);
		return "redirect:/member/index";
	}
	
	@GetMapping("/register_view")
	public String registerView() {
		return "/member/register_view";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("id") String id,
							@RequestParam String pwd,
							@RequestParam String name) {
		ms.register(id, pwd, name);
		return "redirect:/member/index";
	}
//	@PostMapping("/register")
//	public String register(HttpServletRequest req) {
//		ms.register(req.getParameter("id"),
//				req.getParameter("pwd"),
//				req.getParameter("name"));
//		return "redirect:/member/index";
//	}
//	@PostMapping("/register")
//	public String register(MemberDTO dto) {
//		ms.register(dto); //(ms의 register 매개변수 수정필요)
//		return "redirect:/member/index";
//	}
	
	@GetMapping("/member_list")
	public String memberList(Model model) {
		ms.memberList(model);
		return "/member/member_list";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam String id, Model model) {
		ms.memberInfo(id, model);
		return "member/member_info";
	}
}
