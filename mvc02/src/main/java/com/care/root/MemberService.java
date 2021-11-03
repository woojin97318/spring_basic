package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	public MemberService() {
		System.out.println("MemberService 생성자 실행");
	}
	@Autowired
	MemberDAO dao;
	
	public int insert() {
//		dao = new MemberDAO();
		System.out.println("dao : " + dao);
		return dao.insert();
	}

}
