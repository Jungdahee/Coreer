package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dadam.coreer.dao.ReviewDAO;


@WebServlet("/deleteReview")
public class ReviewDeleteActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int reviewNumber = Integer.parseInt(request.getParameter("reviewNumber"));
		new ReviewDAO().deleteReview(reviewNumber);
	}


}
