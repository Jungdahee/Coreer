package com.dadam.coreer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dadam.coreer.vo.MemberVO;


public class MemberDAO implements IMemberDAO {

	private Connection conn;

	public MemberDAO() {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/coreer?useSSL=false";
			//String url = "jdbc:mysql://1004server.iptime.org:3306/coreer?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "root");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Connection Exception");
		}
	}
	
	
	// 로그인
	@Override
	public MemberVO login(String id, String pw, String dropDate) {
		// TODO Auto-generated method stub
		String sql = "Select Member_Id , Member_Name, Member_IsAdmin, Member_Point From MEMBER Where Member_ID = ? and Member_PW = ?";
		MemberVO vo = new MemberVO();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setMember_Id(rs.getString(1));
				vo.setMember_Name(rs.getString(2));
				vo.setMember_IsAdmin(rs.getInt(3));
				vo.setMember_Point(rs.getInt(4));
			}

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {}
		}

		return vo;
	}
	
	
	
	// 로그인 --> 파라미터 MemberVO 객체
	@Override
	public MemberVO login(MemberVO vo) {      
		login(vo.getMember_Id(), vo.getMember_Pw(),vo.getMember_DropDate());
		return vo;
	}
	
	
	// 아이디 중복체크
	@Override
	public boolean memberIdCheck(String id) {
		// TODO Auto-generated method stub
		String sql = "select count(Member_Id) from MEMBER where Member_Id = ?";
		int result = 1;

		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			// false(result>0):중복되는 아이디가 있음
			if(rs.next()){
				result = rs.getInt(1);
				if(result==0)
					return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return false;
	}
	
	
	// 비밀번호 체크
	@Override
	public boolean memberPwCheck(String id, String pw) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from MEMBER where Member_id = ? and Member_Pw = ?";
		int result = 1;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt(1);
			
			if(result == 0) return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	
	// 회원가입
	@Override
	public void addMember(String id, String pw, String name, String phone, String firstBrand, String secondBrand,
			String thirdBrand) {
		// TODO Auto-generated method stub
		String sql = "insert into MEMBER values(?,?,?,?,500,1,null)";
		String sql1 = "insert into LIKEBRAND values(?,?,?,?)";

		PreparedStatement pstmt= null,pstmt1 = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);

			pstmt.executeUpdate();

			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, id);
			pstmt1.setString(2, firstBrand);
			pstmt1.setString(3, secondBrand);
			pstmt1.setString(4, thirdBrand);

			pstmt1.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
			} catch(SQLException e) {}
		}
	}
	
	
	// 내정보 수정
	@Override
	public void updateInfo(String id, String pw, String name, String phone, String firstBrand, String secondBrand,
			String thirdBrand) {
		// TODO Auto-generated method stub
		String sql = "update MEMBER set  Member_Pw=?, Member_Name=?, Member_PhoneNumber=? where Member_Id=?";

		String sql1 = "update LIKEBRAND set FirstBrand=?, SecondBrand=?, ThirdBrand=? where Member_Id=?";

		PreparedStatement pstmt= null,pstmt1 = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, id);

			pstmt.executeUpdate();

			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, firstBrand);
			pstmt1.setString(2, secondBrand);
			pstmt1.setString(3, thirdBrand);
			pstmt1.setString(4, id);


			pstmt1.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
			} catch(SQLException e) {}
		}
	}
	
	
	// 포인트 사용
	@Override
	public void updatePoint(String id, int point) {
		// TODO Auto-generated method stub
		String sql = "update MEMBER set Member_Point=? where Member_Id=?";

		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {}
		}
	}
	
	
	// 사용자 탈퇴
	@Override
	public void updateDropDate(String id) {
		// TODO Auto-generated method stub
		String sql = "update MEMBER set Member_DropDate=now() where Member_Id=?";

		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {}
		}
	}
	
	
	// 아이디 찾기
	@Override
	public String findId(String name, String phoneNumber) {
		// TODO Auto-generated method stub
		String sql = "select Member_Id from MEMBER where Member_name=? and Member_PhoneNumber=?";
		
		String id = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				id = rs.getString(1);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return id;
	}
	
	
	// 비밀번호 찾기
	@Override
	public String findPw(String id, String name, String phoneNumber) {
		// TODO Auto-generated method stub
		String sql = "select Member_Pw from MEMBER where Member_Id=? and Member_name=? and Member_PhoneNumber=?";
		
		String pw = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phoneNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				pw = rs.getString(1);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pw;
	}

	// 내정보보기
	@Override
	public MemberVO showMyInfo(String id) {
		// TODO Auto-generated method stub
		String sql1 = "Select Member_Id ,Member_Name, Member_PhoneNumber, Member_Point,Member_Pw From MEMBER Where Member_ID = ?";
		String sql2 = "Select FirstBrand,SecondBrand,ThirdBrand from LIKEBRAND where Member_Id = ?";
		
		
		MemberVO vo = new MemberVO();

		PreparedStatement pstmt = null,pstmt1=null;
		ResultSet rs = null,rs1=null;

		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			
			pstmt1 = conn.prepareStatement(sql2);
			pstmt1.setString(1, id);
			rs = pstmt.executeQuery();
			rs1 = pstmt1.executeQuery();
			if(rs.next()){
				vo.setMember_Id(rs.getString(1));
				vo.setMember_Name(rs.getString(2));
				vo.setMember_PhoneNumber(rs.getString(3));
				vo.setMember_Point(rs.getInt(4));
				vo.setMember_Pw(rs.getString(5));
			}
			if(rs1.next()){
				vo.setFirstBrand(rs1.getString(1));
				vo.setSecondBrand(rs1.getString(2));
				vo.setThirdBrand(rs1.getString(3));
			}

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
			} catch(SQLException e) {}
		}

		return vo;
	}
	
	
	// 탈퇴 취소
	@Override
	public void updateCancelDropDate(String id) {
		// TODO Auto-generated method stub
		String sql = "update MEMBER set Member_DropDate=null where Member_Id=?";

		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {}
		}		
	}

	
	// 탈퇴 검색
	@Override
	public String selectDropDate(String id) {
		// TODO Auto-generated method stub
		String sql = "select Member_DropDate from MEMBER where Member_Id=?";
		
		String dropDate = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				dropDate = rs.getString(1);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dropDate;
	}

}