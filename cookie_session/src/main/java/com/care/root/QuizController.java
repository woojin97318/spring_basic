package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("quiz")
public class QuizController {

	@GetMapping("/login")
	public String login() {
		return "/cookie_session_quiz/login";
	}
	
	@PostMapping("/chkUser")
	public String chkUser(@RequestParam("id") String id,
							@RequestParam("pwd") String pwd,
							HttpSession session) {
		String db_id = "1", db_pwd = "1", db_nick = "홍길동";
		if(db_id.equals(id) && db_pwd.equals(pwd)) {
			session.setAttribute("id", db_id);
			session.setAttribute("nick", db_nick);
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("main")
	public String main(HttpSession session) {
		if(session != null)
			return "/cookie_session_quiz/main";
		else
			return "redirect:login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/cookie_session_quiz/logout";
	}
	
	@RequestMapping("/popup")
	public String popup() {
		return "/cookie_session_quiz/popup";
	}
	
	@GetMapping("/cookieChk")
	public void cookieChk(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie", "쿠키");
		cook.setMaxAge(10);
		response.addCookie(cook);
	}
	
	@RequestMapping("cookie")
	public String cookie(HttpServletResponse response, HttpServletRequest request,
			@CookieValue(value = "myCookie", required = false) Cookie cook,
			Model model) {
		Cookie[] cookies = request.getCookies();
		
		if(cook != null )
			model.addAttribute("cook", cook.getValue());
		
		return "cookie_session_quiz/cookie";
	}
}
