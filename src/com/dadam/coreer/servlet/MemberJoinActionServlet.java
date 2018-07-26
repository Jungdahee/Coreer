package com.dadam.coreer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dadam.coreer.dao.MemberDAO;

/* return : coreer.jsp */ 
@WebServlet("/join")
public class MemberJoinActionServlet implements JavaBAction{

   @Override
   public String execute(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String pwCheck = request.getParameter("pwCheck");
      String name = request.getParameter("name");
      String phone = request.getParameter("phone");
      String firstBrand = request.getParameter("firstBrand");
      String secondBrand = request.getParameter("secondBrand");
      String thirdBrand = request.getParameter("thirdBrand");
      
      
      if(pw.equals(pwCheck)){
    	  new MemberDAO().addMember(id, pw, name, phone, firstBrand, secondBrand, thirdBrand);
    	  return "login.jsp";
      }
      
      request.setAttribute("id", id);
      request.setAttribute("name", name);
      request.setAttribute("phone", phone);
      request.setAttribute("firstBrand", firstBrand);
      request.setAttribute("secondBrand", secondBrand);
      request.setAttribute("thirdBrand", thirdBrand);
      
      return "memberJoin.jsp";
      
      
   }

}