package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;
import com.dadam.coreer.vo.NoticeVO;

// �������� ���� �ҷ�����
public class NoticeLoadActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// �������� ��ȣ �ޱ�
		int noticeNum = Integer.parseInt(request.getParameter("Notice_Number"));
		
		// �ش� �������� ������ NoticeVO ��ü�� ����
		NoticeVO vo = new NoticeDAO().selectNotice(noticeNum);
		
		// NoticeVO ��ü�� return �������� ����
		request.setAttribute("noticeContents", vo);
		
		return "noticeUpdate.jsp";
	}


}
