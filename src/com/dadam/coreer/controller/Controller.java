package com.dadam.coreer.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.servlet.*;

@WebServlet("*.do")
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		controll(session, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		controll(session,req, resp);
	}
	
	private void controll(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		JavaBAction bAction = null;
		
		String viewPage = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(com);
		
		if(com.equals("/login.do")){
			bAction = new LoginActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/logout.do")){
			bAction = new LogoutActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/join.do")){
			bAction = new MemberJoinActionServlet();
			viewPage=bAction.execute(session,request, response);
			
		}
		else if(com.equals("/checkId.do")){
			bAction = new MemberIdCheckActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/modifyMyInfo.do")){
			bAction = new MemberModifyInfoActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/loadMyInfo.do")){
			bAction = new LoadMyInfoActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/showMyInfo.do")){
			bAction = new ShowMyInfoActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/showPoint.do")){
			viewPage="";
		}
		else if(com.equals("/updateReview.do")){
			viewPage="";
		}
		else if(com.equals("/usePoint.do")){
			viewPage="";
		}
		else if(com.equals("/deleteReview.do")){
			viewPage="";
		}
		else if(com.equals("/dropMember.do")){
			bAction = new MemberDropActionServlet();
			viewPage = bAction.execute(session, request, response);
		}
		else if(com.equals("/dropCancelMember.do")){
			bAction = new MemberDropCancelActionServlet();
			viewPage= bAction.execute(session, request, response);
		}
		else if(com.equals("/findId.do")){
			bAction = new MemberFindIdActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/findPw.do")){
			bAction = new MemberFindPwActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/checkPw.do")){
			bAction = new MemberPwCheckActionServlet();
			viewPage=bAction.execute(session, request, response);
		}
		else if(com.equals("/insertReview.do")){
			viewPage="";
		}
		else if(com.equals("/noticeList.do")){
			bAction = new NoticeListActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/noticeInsert.do")){
			bAction = new NoticeInsertActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/noticeContents.do")){
			bAction = new NoticeContentsActionServlet();
			viewPage= bAction.execute(session,request, response);
		}
		else if(com.equals("/noticeDelete.do")){
			bAction = new NoticeDeleteActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/noticeLoad.do")){
			bAction = new NoticeLoadActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/noticeUpdate.do")){
			bAction = new NoticeUpdateActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/menuList.do")){
			bAction = new MenuListActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/menuInsert.do")){
			bAction = new MenuInsertActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/menuUpdate.do")){
			bAction = new MenuUpdateActionServlet();
			viewPage=bAction.execute(session,request, response);

		}
		else if(com.equals("/menuDelete.do")){
			bAction = new MenuDeleteActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/menuLoad.do")){
			bAction = new MenuLoadActionServlet();
			viewPage=bAction.execute(session,request, response);
		}
		else if(com.equals("/showMenuInfo.do")){
			bAction = new ShowMenuInfoActionServlet();
			viewPage = bAction.execute(session, request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
