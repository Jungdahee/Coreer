package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dadam.coreer.dao.ReviewDAO;
import com.dadam.coreer.vo.ReviewVO;


@WebServlet("/updateReview")
public class ReviewUpdateActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String reviewContents = request.getParameter("reviewUpdateContents");
		int score = Integer.parseInt(request.getParameter("reviewUpdateScore"));
		int reviewNumber = Integer.parseInt(request.getParameter("reviewUpdateReviewNumber"));
		
		ReviewVO vo = new ReviewVO();
		vo.setReview_Contents(reviewContents);
		vo.setReview_Score(score);
		vo.setReview_Number(reviewNumber);
		
		new ReviewDAO().updateReview(vo);
	}


}
