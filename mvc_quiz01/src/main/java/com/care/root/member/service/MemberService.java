package com.care.root.member.service;

import org.springframework.ui.Model;

public interface MemberService {
	public void register(String id, String pwd, String name);
	public void memberList(Model model);
	public void login(String id, String pwd, Model model);
	public void memberInfo(String id, Model model);
}
