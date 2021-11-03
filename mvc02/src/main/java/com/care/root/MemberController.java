package com.care.root;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	public MemberController() {
		System.out.println("MemberController 생성자 실행");
	}
	//@Autowired
	@Inject
	@Qualifier("memberService")
	MemberService ms;
	
	@RequestMapping(value = "insert")
	public String insert(Model model) {
		
//		ms = new MemberService();
		int result = ms.insert();
		System.out.println("ms : " + ms);
		model.addAttribute("result", result);
		return "di/index";
	}
}
