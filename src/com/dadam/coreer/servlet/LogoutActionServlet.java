package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* return : coreer.jsp */
@WebServlet("/logout")
public class LogoutActionServlet implements JavaBAction{

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session.invalidate();
		
		return "login.jsp";
	}

}
