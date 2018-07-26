package com.dadam.coreer.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MenuDAO;
import com.dadam.coreer.vo.MenuVO;

public class MenuListActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] menu_Number = request.getParameterValues("coffee");
		String[] brand_Number = request.getParameterValues("brand");
		
		MenuDAO dao = new MenuDAO();

		if(	menu_Number == null && brand_Number == null){
			ArrayList<MenuVO> list = dao.listMenu();
			
			request.setAttribute("list", list);
		}
		else{

			try {
				ArrayList<MenuVO> list = dao.listMenu(menu_Number,brand_Number);
				request.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}



		return "menuList.jsp";
	}

}
