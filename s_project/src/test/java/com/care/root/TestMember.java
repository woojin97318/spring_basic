package com.care.root;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.mybatis.member.MemberMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={
		"classpath:TestMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		})
public class TestMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Autowired MemberMapper mapper;
	
	@Test
	public void testMc() {
		System.out.println("mc : " + mc);
		assertNotNull(mc); //null이 아니면 성공
	}
	@Test
	public void testMs() {
		System.out.println("ms : " + ms);
		assertNotNull(ms);
	}
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}
	@Test
	public void testMsUserChk() {
		ms.userChk("aaa", "aaa");
	}
	@Test
	public void testMsMemberDTO() {
		mapper.memberDTOList();
	}
	@Test
	public void testMsMemberInfo() {
		ms.memberinfo();
	}
	@Test
	public void testMsRegisterSave() {
		MemberDTO dto = new MemberDTO();
		dto.setId("test4");
		dto.setPw("test4");
		dto.setAddr("test4");
		ms.memberRegister(dto);
	}
	@Test
	public void testMapperMemberRegistere() {
		MemberDTO dto = new MemberDTO();
		dto.setId("test5");
		dto.setPw("test5");
		dto.setAddr("test5");
		mapper.memberRegister(dto);
	}
//	@Test
//	public void testMsInfo() {
//		ms.info(Model model, "aaa");
//	}
	@Test
	public void testMapperInfo() {
		mapper.info("aaa");
	}
}
