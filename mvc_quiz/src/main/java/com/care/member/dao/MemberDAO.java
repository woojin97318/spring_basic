package com.care.member.dao;

import java.util.ArrayList;

import com.care.member.dto.MemberDTO;

public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}

	public int insert(String id, String pwd, String name) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		list.add(dto);
		
		if(list == null)
			return 0;
		else
			return 1;
	}

	public ArrayList<MemberDTO> select() {
		return list;
	}
}
