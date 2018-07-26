package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;
import com.dadam.coreer.vo.NoticeVO;

// 공지사항 내용 불러오기
public class NoticeLoadActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 공지사항 번호 받기
		int noticeNum = Integer.parseInt(request.getParameter("Notice_Number"));
		
		// 해당 공지사항 내용을 NoticeVO 객체에 저장
		NoticeVO vo = new NoticeDAO().selectNotice(noticeNum);
		
		// NoticeVO 객체를 return 페이지로 전달
		request.setAttribute("noticeContents", vo);
		
		return "noticeUpdate.jsp";
	}


}
