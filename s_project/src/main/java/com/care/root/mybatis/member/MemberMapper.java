package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public ArrayList<MemberDTO> memberDTOList();
	public void memberRegister(MemberDTO dto);
	public MemberDTO info(String id);
}
