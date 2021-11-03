package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	public MemberService() {
		System.out.println("MemberService 생성자 실행");
	}
	
	@Autowired
	MemberDAO dao;
	
	public int insert(String id, String pwd, String name) {
		return dao.insert(id, pwd, name);
	}

	public ArrayList<MemberDTO> select() {
		return dao.select();
	}
}
