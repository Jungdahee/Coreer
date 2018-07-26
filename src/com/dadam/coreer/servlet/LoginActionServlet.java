package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;
import com.dadam.coreer.vo.MemberVO;

/* return : main.jsp */
public class LoginActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MemberVO vo = new MemberDAO().login(id, pw, null);

		
		
		if(vo.getMember_Name()!=null){
			session.setAttribute("sessionId", vo.getMember_Id());
			session.setAttribute("sessionName", vo.getMember_Name());
			session.setAttribute("sessionIsAdmin", vo.getMember_IsAdmin());
			session.setAttribute("sessionPoint", vo.getMember_Point());
			session.setAttribute("sessionDropDate", vo.getMember_DropDate());
			
			return "menuList.do";
		}
		return "login.jsp";
	}

}
