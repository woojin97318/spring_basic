package com.care.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("make_session")
	public String makeSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("id", "abc123");
		session.setAttribute("name", "홍길동");
		
		return "session/makeSession";
	}
	
	@RequestMapping("result_session")
	public String resultSession(Model model) {
		model.addAttribute("id", "모델로 저장한 아이디");
		return "session/resultSession";
	}
	
	@RequestMapping("del_session")
	public String delSession(HttpSession session) {
		session.removeAttribute("id"); // "id" 세션만 삭제
//		session.invalidate(); //모든 세션 삭제
		return "session/delSession";
	}
}
