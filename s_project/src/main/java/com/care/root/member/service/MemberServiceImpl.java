package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder encoder;
	
	public MemberServiceImpl() { //생성자
		encoder = new BCryptPasswordEncoder();
	}

	@Override
	public int userChk(String id, String pw) {
		int result = 0;
		ArrayList<MemberDTO> list = mapper.memberDTOList();
		for(MemberDTO dto : list) {
			// encoder.matches(사용자가 입력한 비밀번호, DB의 비밀번호)
			if(id.equals(dto.getId()) && encoder.matches(pw, dto.getPw())) {
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
	public int memberRegister(MemberDTO dto) {
		// PW 암호화 후 DB에 저장
		System.out.println("비번 변경 전 : " + dto.getPw());
		String securePw = encoder.encode(dto.getPw());
		System.out.println("비번 변경 후 : " + securePw);
		dto.setPw(securePw);
		
		int result;
		try {
			mapper.memberRegister(dto);
			result = 1;
		} catch (Exception e) {
			System.out.println("---- SQL insert/id 중복 에러 ----");
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public void info(Model model, String id) {
		model.addAttribute("info", mapper.info(id));
	}
}
