package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;

public class MemberDropCancelActionServlet implements JavaBAction{
	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)session.getAttribute("sessionId");
		new MemberDAO().updateCancelDropDate(id);
		String dropDate = new MemberDAO().selectDropDate(id);
		request.setAttribute("dropDate", dropDate);
		return "showMyInfo.do";
	}
}
