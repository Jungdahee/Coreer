package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;

/* return : findUserInfo.jsp */
@WebServlet("/findPw")
public class MemberFindPwActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		
		String pw = new MemberDAO().findPw(id,name, phoneNumber);
		
		request.setAttribute("pw", pw);
		
		return "memberFindResult.jsp";
	}

}
