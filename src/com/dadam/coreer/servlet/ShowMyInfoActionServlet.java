package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;
import com.dadam.coreer.vo.MemberVO;

public class ShowMyInfoActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("Id");
		if(sid==null)
			sid = (String)session.getAttribute("sessionId");
		MemberVO vo = new MemberDAO().showMyInfo(sid);
		request.setAttribute("myInfo", vo);
				
		return "memberMyInfo.jsp";
	}

}
