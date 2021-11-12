package com.care.root.member.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.common.MemberSessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController implements MemberSessionName {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String index() {
		System.out.println("컨트롤러의 index 실행");
		return "index";
	}
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("userChk")
	public String loginlogin(@RequestParam String id, @RequestParam String pw,
							@RequestParam(required = false) String autoLogin,
							HttpSession session, HttpServletResponse response) {
		if(ms.userChk(id, pw) == 0) { // 로그인 실패
			return "member/failLogin";
		}else { // 로그인 성공
			session.setAttribute(LOGIN, id);
			if(autoLogin != null) { // 자동로그인 체크시 loginCookie생성
				int limitTime = 60*60*24*90; //90일
				Cookie logincookie = new Cookie("loginCookie", session.getId());
				logincookie.setPath("/");
				logincookie.setMaxAge(limitTime);
				response.addCookie(logincookie);
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.MONTH, 3);
				
				java.sql.Date limitDate = new java.sql.Date(cal.getTimeInMillis());
				ms.keepLogin(session.getId(), limitDate, id);
			}
			return "member/successLogin";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response,
			@CookieValue(value="loginCookie", required=false) Cookie loginCookie) throws Exception {
		if(session.getAttribute(LOGIN) != null) {
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				ms.keepLogin(
						"nan",
						new java.sql.Date(System.currentTimeMillis()),
						(String)session.getAttribute(LOGIN));
			}
		}
		session.invalidate();
		return "/member/logout";
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
