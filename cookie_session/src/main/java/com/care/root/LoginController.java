package com.care.root;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie", "쿠키생성");
		cook.setMaxAge(10);
		response.addCookie(cook);
		return "/login/login";
	}
	
	@PostMapping("/chkUser")
	public String chkUser(@RequestParam("id") String id,
							@RequestParam("pwd") String pwd,
							HttpSession session) {
		String db_id = "1", db_pwd = "1", db_nick = "홍길동구리구리";
		if(id.equals(db_id) && pwd.equals(db_pwd)) {
			session.setAttribute("loginId", db_id);
			session.setAttribute("loginNick", db_nick);
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("main")
	public String main(HttpSession session) {
		if(session.getAttribute("loginId") != null)
			return "login/main";
		return "redirect:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		PrintWriter out = null;
		response.setContentType("text/html; charset=utf-8");
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<script>alert(\"로그아웃이 되었습니다\");" +
					"location.href=\"login\"</script>");
		return "login/logout";
	}
}
