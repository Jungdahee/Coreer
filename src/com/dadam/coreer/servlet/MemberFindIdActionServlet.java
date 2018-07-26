package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;

/* return : findUserInfo.jsp */
@WebServlet("/findId")
public class MemberFindIdActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		
		String id = new MemberDAO().findId(name, phoneNumber);
		
		request.setAttribute("id", id);
		
		return "memberFindResult.jsp";
	}

}
