package com.javalec.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		System.out.println("BContentCommand들어옴"); //테스트
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		System.out.println("BContentCommand 에서 bId는"+bId);//테스트
		
		model.addAttribute("content_view", dto);
		

	}

}
