package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;

// �������� ����
public class NoticeUpdateActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// �������� ��ȣ, ����, ���� �ޱ�
		int noticeNum = Integer.parseInt(request.getParameter("notice_Number"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		// �������� ����
		new NoticeDAO().updateNotice(title, contents, noticeNum);
		
		return "noticeList.do";
	}


}
