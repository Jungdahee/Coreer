package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MenuDAO;
import com.dadam.coreer.vo.MenuVO;

public class MenuInsertActionServlet implements JavaBAction{

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MenuVO vo = new MenuVO();
		String menuNumber = request.getParameter("Menu_Number");
		int brandNumber = Integer.parseInt(request.getParameter("Brand_Number"));
		String menuName = request.getParameter("Menu_Name");
		int menuPrice = Integer.parseInt(request.getParameter("Menu_Price"));
		int menuCaffeine = Integer.parseInt(request.getParameter("Menu_Caffeine"));
		int menuCalorie = Integer.parseInt(request.getParameter("Menu_Calorie"));
		int menuCapacity = Integer.parseInt(request.getParameter("Menu_Capacity"));
		String menuImage = request.getParameter("Menu_Image");
		double menu_AvgScore = Double.parseDouble(request.getParameter("Menu_AvgScore"));
 		//메뉴 이름,메뉴 번호,브랜드 이름,메뉴 이미지,용량,카페인,칼로리,평점,
		
		vo.setMenu_Number(menuNumber);
		vo.setBrand_Number(brandNumber);
		vo.setMenu_Name(menuName);
		vo.setMenu_Price(menuPrice);
		vo.setMenu_Caffeine(menuCaffeine);
		vo.setMenu_Calorie(menuCalorie);
		vo.setMenu_Capacity(menuCapacity);
		vo.setMenu_Image(menuImage);
		vo.setMenu_AvgScore(menu_AvgScore);
		
		new MenuDAO().insertMenu(vo);
		
		return "showMenuInfo.do";
	}


}
