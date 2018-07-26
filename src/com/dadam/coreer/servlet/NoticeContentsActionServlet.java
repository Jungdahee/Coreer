package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;
import com.dadam.coreer.vo.NoticeVO;

// 공지사항 내용 보기
public class NoticeContentsActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 공지사항 번호를 받아옴
		int noticeNum = Integer.parseInt(request.getParameter("Notice_Number"));
		
		// 해당 공지사항 번호의 내용을 NoticeVO 객체에 담음
		NoticeVO vo = new NoticeDAO().selectNotice(noticeNum);
		
		
		// return 페이지에 보낼 값을 저장
		request.setAttribute("noticeContents", vo);
		request.setAttribute("test", noticeNum);
		
		return "noticeContents.jsp";
	}


}
