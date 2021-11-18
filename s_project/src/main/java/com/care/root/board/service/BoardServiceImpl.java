package com.care.root.board.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.common.MemberSessionName;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;

	@Override
	public void selectAllBoardList(Model model) {
		model.addAttribute("boardList", mapper.selectAllBoardList());
	}

	@Override
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		HttpSession session = request.getSession();
		dto.setId((String)session.getAttribute(MemberSessionName.LOGIN));

		MultipartFile file = mul.getFile("image_file_name");
		if(file.getSize() != 0) {
			//이미지 있을경우 처리
			dto.setImageFileName(bfs.saveFile(file));
		}else {
			dto.setImageFileName("nan");
		}
		// 이 아래부분도 boardDelete 메소드처럼 바꿔주면 댐
		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bfs.getMessage(result, request);
	}

	@Override
	public void contentView(int writeNo, Model model) {
		model.addAttribute("personalData", mapper.contentView(writeNo));
		upHit(writeNo);
	}
	
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}

	@Override
	public String boardDelete(int writeNo, String imageFileName,
								HttpServletRequest request) {
		BoardFileService bfs = new BoardFileServiceImpl();
		int result = mapper.delete(writeNo);
//		MessageDTO mDTO = new MessageDTO();
		String message = null;
		if(result == 1) {
			bfs.deleteImage(imageFileName);
			message = bfs.getMessage(request, "삭제 성공", "/board/boardAllList");
		}else {
			message = bfs.getMessage(request, "삭제 실패", "/board/contentView");
		}
		return message;
	}

}
