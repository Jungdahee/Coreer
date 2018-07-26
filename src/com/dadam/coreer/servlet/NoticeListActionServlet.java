package com.dadam.coreer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.NoticeDAO;
import com.dadam.coreer.vo.NoticeVO;

// �������� ���
public class NoticeListActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDAO dao = new NoticeDAO();
		
		// ���� ������ -- �ʱⰪ�� 1�� ����
		int spage = 1;
		
		// page �� �ޱ�
		String page = request.getParameter("page");
		
		if(page != null)
			spage = Integer.parseInt(page);
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		
		// sql �Ķ���� �� ����
		listOpt.put("start", spage*10-10);
		
		// �ش� ���ں��� �����ϴ� �������� ��� 10�� ������
		ArrayList<NoticeVO> list = dao.listNotice(listOpt);
		int count = dao.countNotice();
		
		// �ִ� ������
		int maxPage = (int)(count/10.0 + 0.9);
		
		// �ش� �� ���� ������������ �� ������ ���  ex) 1 2 3 4 5 --> 1�� ���������� 5�� ��������
		int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage)
			endPage = maxPage;
		
		
		request.setAttribute("list", list);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		return "noticeList.jsp";
	}


}
