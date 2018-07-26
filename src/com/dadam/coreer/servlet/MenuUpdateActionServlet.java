package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MenuDAO;
import com.dadam.coreer.vo.MenuVO;

public class MenuUpdateActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		
		String menuNumber = request.getParameter("Menu_Number");
		String menuName = request.getParameter("Menu_Name");
		int menuPrice = Integer.parseInt(request.getParameter("Menu_Price"));
		String menuImage = request.getParameter("Menu_Image");
		int menuCaffeine = Integer.parseInt(request.getParameter("Menu_Caffeine"));
		int menuCalorie = Integer.parseInt(request.getParameter("Menu_Calorie"));
		int menuCapacity = Integer.parseInt(request.getParameter("Menu_Capacity"));
		
		vo.setMenu_Name(menuName);
		vo.setMenu_Price(menuPrice);
		vo.setMenu_Image(menuImage);
		vo.setMenu_Caffeine(menuCaffeine);
		vo.setMenu_Calorie(menuCalorie);
		vo.setMenu_Capacity(menuCapacity);
		vo.setMenu_Number(menuNumber);
		

		new MenuDAO().updateMenu(vo);
		
		request.setAttribute("Menu_Number", menuNumber);
		//업데이트 후에 해당번호를 통해 다시 showMenuInfo를 보여줘야하기 때문에 
		//번호를 넘겨야함. 그래서 setAttribute를 해야함.
		
		return "showMenuInfo.do";
	}


}
