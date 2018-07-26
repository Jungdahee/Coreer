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

// 공지사항 목록
public class NoticeListActionServlet implements JavaBAction {

	@Override
	public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDAO dao = new NoticeDAO();
		
		// 현재 페이지 -- 초기값을 1로 설정
		int spage = 1;
		
		// page 값 받기
		String page = request.getParameter("page");
		
		if(page != null)
			spage = Integer.parseInt(page);
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		
		// sql 파라미터 값 설정
		listOpt.put("start", spage*10-10);
		
		// 해당 숫자부터 시작하는 공지사항 목록 10개 가져옴
		ArrayList<NoticeVO> list = dao.listNotice(listOpt);
		int count = dao.countNotice();
		
		// 최대 페이지
		int maxPage = (int)(count/10.0 + 0.9);
		
		// 해당 장 수의 시작페이지와 끝 페이지 계산  ex) 1 2 3 4 5 --> 1은 시작페이지 5는 끝페이지
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
