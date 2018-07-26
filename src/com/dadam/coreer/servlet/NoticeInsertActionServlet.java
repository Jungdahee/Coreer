package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;

// 공지사항 작성
public class NoticeInsertActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 공지사항 제목,내용을 받아오고 session에 저장된 Id를 가져옴
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = (String)session.getAttribute("sessionId");
		
		
		// 공지사항 입력
		new NoticeDAO().insertNotice(id, title, contents);
		
		return "noticeList.do";
		
	}
	

}
