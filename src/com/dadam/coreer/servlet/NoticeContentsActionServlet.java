package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;
import com.dadam.coreer.vo.NoticeVO;

// �������� ���� ����
public class NoticeContentsActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// �������� ��ȣ�� �޾ƿ�
		int noticeNum = Integer.parseInt(request.getParameter("Notice_Number"));
		
		// �ش� �������� ��ȣ�� ������ NoticeVO ��ü�� ����
		NoticeVO vo = new NoticeDAO().selectNotice(noticeNum);
		
		
		// return �������� ���� ���� ����
		request.setAttribute("noticeContents", vo);
		request.setAttribute("test", noticeNum);
		
		return "noticeContents.jsp";
	}


}
