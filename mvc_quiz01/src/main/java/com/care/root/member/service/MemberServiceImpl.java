package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dao.UserLoginDTO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	public MemberServiceImpl() {
		System.out.println("MemberService 생성자 실행");
	}
	@Autowired
	MemberDAO dao;
	
	@Override
	public void register(String id, String pwd, String name) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dao.register(dto);
	}

	@Override
	public void memberList(Model model) {
		model.addAttribute("list", dao.memberList());
	}

	@Override
	public void login(String id, String pwd, Model model) {
		UserLoginDTO dto = dao.login(id, pwd);
		model.addAttribute("usercheck", dto);
	}

	@Override
	public void memberInfo(String id, Model model) {
		model.addAttribute("member", dao.memberInfo(id) );
	}
}
