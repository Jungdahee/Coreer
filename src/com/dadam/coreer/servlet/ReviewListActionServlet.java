package com.dadam.coreer.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dadam.coreer.dao.ReviewDAO;
import com.dadam.coreer.vo.ReviewVO;


/* return : ShowMenuInfoAction */
@WebServlet("/reviewList")
public class ReviewListActionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String menuNumber = request.getParameter("Menu_Number");
		response.getWriter().write(getJSON(menuNumber));
	}

	public String getJSON(String menuNumber) {
		if(menuNumber ==null) menuNumber="";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ArrayList<ReviewVO> reviewList = new ReviewDAO().showReview(menuNumber);
		for(int i=0; i < reviewList.size(); i++) {
			result.append("[{\"value\": \"" +reviewList.get(i).getId() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getMenu_Number() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getReview_Number() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getReview_Contents() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getReview_Date() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getReview_Score() + "\"},");
			result.append("{\"value\": \"" +reviewList.get(i).getReview_Good() + "\"}]");
			if(i != reviewList.size()-1) result.append(",");
		}
		result.append("]}");
		return result.toString();
	}
}
