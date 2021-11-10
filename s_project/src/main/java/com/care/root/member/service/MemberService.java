package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int userChk(String id, String pw);
	public ArrayList<MemberDTO> memberinfo();
	public int memberRegister(MemberDTO dto);
	public void info(Model model, String id);
}
