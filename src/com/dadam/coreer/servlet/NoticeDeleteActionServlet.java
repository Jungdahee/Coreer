package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;

// 공지사항 삭제
public class NoticeDeleteActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 공지사항 번호를 받아옴
		int noticeNum = Integer.parseInt(request.getParameter("Notice_Number"));
		
		// 공지사항 삭제
		new NoticeDAO().deleteNotice(noticeNum);
		
		return "noticeList.do";
		
	}


}
