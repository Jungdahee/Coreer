package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.ReviewDAO;


@WebServlet("/clickGoodBadBtn")
public class ReviewLikeActionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		String goodOrBad = request.getParameter("goodOrBad");
		String userId = request.getParameter("userId");		
		new ReviewDAO().updateGood(reviewNum, goodOrBad, userId);
	}

	
}

