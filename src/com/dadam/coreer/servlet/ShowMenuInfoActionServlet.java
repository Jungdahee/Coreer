package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MenuDAO;
import com.dadam.coreer.vo.MenuVO;

/* return : menuInfo.jsp */
public class ShowMenuInfoActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String menuNumber = request.getParameter("Menu_Number");

		MenuVO vo = new MenuDAO().selectMenu(menuNumber);
		
		request.setAttribute("vo", vo);
		
		return "menuInfo.jsp";
	}

}
