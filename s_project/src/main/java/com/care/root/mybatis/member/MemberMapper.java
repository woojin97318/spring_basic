package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public ArrayList<MemberDTO> memberDTOList();
	public void memberRegister(MemberDTO dto);
	public MemberDTO info(String id);
	public void keepLogin(Map<String, Object> map);
	public MemberDTO getUserSessionId(String sessionId);
}
