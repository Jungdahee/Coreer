package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.ReviewDAO;
import com.dadam.coreer.vo.ReviewVO;


/* return : ShowMenuInfoAction */
@WebServlet("/insertReview")
public class ReviewInsertActionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String reviewContents = request.getParameter("reviewContents");
		int score = Integer.parseInt(request.getParameter("score"));
		String userId = request.getParameter("userId");
		String menuNumber = request.getParameter("menu_number");
		
		ReviewVO vo = new ReviewVO();
		vo.setReview_Contents(reviewContents);
		vo.setReview_Score(score);
		vo.setId(userId);
		vo.setMenu_Number(menuNumber);
		
		new ReviewDAO().insertReview(vo);
	}


}
