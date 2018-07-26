package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dadam.coreer.dao.MemberDAO;


public class MemberPwCheckActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String)session.getAttribute("sessionId");
		String pw = request.getParameter("pw");
		boolean bol = new MemberDAO().memberPwCheck(id, pw);
		
		if(bol){
			return "loadMyInfo.do";
		}
		
		return "memberPwCheck.jsp";
	}

}
