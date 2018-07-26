package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;

// �������� �ۼ�
public class NoticeInsertActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// �������� ����,������ �޾ƿ��� session�� ����� Id�� ������
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = (String)session.getAttribute("sessionId");
		
		
		// �������� �Է�
		new NoticeDAO().insertNotice(id, title, contents);
		
		return "noticeList.do";
		
	}
	

}
