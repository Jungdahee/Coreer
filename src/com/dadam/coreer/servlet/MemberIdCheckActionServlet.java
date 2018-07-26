package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dadam.coreer.dao.MemberDAO;


public class MemberIdCheckActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkId = request.getParameter("checkId");
		System.out.println(checkId);
		boolean bol = new MemberDAO().memberIdCheck(checkId);
		
		
		StringBuilder json=new StringBuilder();
    	
		
    	json.append("[");
    	json.append( String.format("{\"bol\":%s}",bol));
    	json.append("]");
    		
    	response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(json.toString());
    	
		request.setAttribute("id", checkId);
		
		return "memberJoin.jsp";


	}

}
