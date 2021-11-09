package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;

	@Override
	public int userChk(String id, String pw) {
		int result = 0;
		ArrayList<MemberDTO> list = mapper.memberDTOList();
		for(MemberDTO dto : list) {
			if(id.equals(dto.getId()) && pw.equals(dto.getPw())) {
				result = 1;
				break;
			}
		}
		return result;
	}

	@Override
	public ArrayList<MemberDTO> memberinfo() {
		return mapper.memberDTOList();
	}

	@Override
	public void memberRegister(MemberDTO dto) {
		mapper.memberRegister(dto);
	}

	@Override
	public void info(Model model, String id) {
		model.addAttribute("info", mapper.info(id));
	}
}
