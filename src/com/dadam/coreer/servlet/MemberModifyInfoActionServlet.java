package com.dadam.coreer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dadam.coreer.dao.MemberDAO;


public class MemberModifyInfoActionServlet implements JavaBAction {

   @Override
   public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String sid = (String) session.getAttribute("sessionId");
      String pw = request.getParameter("pw");
      String pwCheck = request.getParameter("pwCheck");
      String name = request.getParameter("name");
      String phoneNumber = request.getParameter("phoneNumber");
      String firstBrand = request.getParameter("firstBrand");
      String secondBrand = request.getParameter("secondBrand");
      String thirdBrand = request.getParameter("thirdBrand");
      

      if(pw.equals(pwCheck)){
    	  new MemberDAO().updateInfo(sid, pw, name, phoneNumber, firstBrand, secondBrand, thirdBrand);
    	  session.invalidate();
          return "login.jsp";
      }else{
          return "loadMyInfo.do";
      }
   }
}