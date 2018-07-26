package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;
import com.dadam.coreer.vo.MemberVO;

public class LoadMyInfoActionServlet implements JavaBAction{

	@Override
	public String execute(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String)session.getAttribute("sessionId");
		
		MemberVO vo = new MemberDAO(). showMyInfo(id);
		request.setAttribute("myInfo", vo);
		return "modifyMyInfo.jsp";
	}

}
