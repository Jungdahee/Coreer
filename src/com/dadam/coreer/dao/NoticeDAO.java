package com.dadam.coreer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.dadam.coreer.vo.NoticeVO;

public class NoticeDAO implements INoticeDAO {
	
	private Connection conn;
	
	// DB연결
	public NoticeDAO(){
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
	
	/*	
	 * 	PreparedStatement는 SQL INJECTION을 예방한다.
	 * 
	 * 	PreparedStatement 객체인 pstmt 의 set 메소드는  sql문의 ?에 값을 설정
	 * 	데이터의 자료형 주의 --> setInt,setString 등등
	 *  
	 *  select의 경우 executeQuery()
	 * 	insert,update,delete의 경우 executeUpdate() 사용
	 * 
	 * 	sql은 DB에서 돌려보고 원하는 값이 나오는지 확인 후 사용할 것
	 * 
	 * */
	
	
	
	// 공지사항 목록
	@Override
	public ArrayList<NoticeVO> listNotice(HashMap<String, Object> listOpt){
		// TODO Auto-generated method stub
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		int start = (int)listOpt.get("start");
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select Notice_Number,Notice_Title,Notice_Contents,Notice_Date from NOTICE order by Notice_Number desc limit ?,10";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while(rs.next()){
				NoticeVO vo = new NoticeVO();
				vo.setNotice_Number(rs.getInt(1));
				vo.setNotice_Title(rs.getString(2));
				vo.setNotice_Contents(rs.getString(3));
				vo.setNotice_Date(rs.getString(4));

				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}

	
	// 공지사항 입력
	@Override
	public void insertNotice(String id, String title, String contents){
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into NOTICE(Notice_Title, Notice_Contents, Notice_Date, Member_Id) values (?, ?, now(), ?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	
	// 공지사항 수정
	@Override
	public void updateNotice(String title, String contents, int noticeNum) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		String sql = "update NOTICE set Notice_Title = ?, Notice_Contents = ? where Notice_Number = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setInt(3, noticeNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 공지사항 삭제
	@Override
	public void deleteNotice(int noticeNum) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		
		String sql = "delete from NOTICE where Notice_Number = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNum);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 공지사항 내용 출력
	@Override
	public NoticeVO selectNotice(int noticeNum) {
		NoticeVO vo = new NoticeVO();
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select Notice_Number,Notice_Title,Notice_Contents,Notice_Date,Member_Id from NOTICE where Notice_Number=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNum);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				vo.setNotice_Number(rs.getInt(1));
				vo.setNotice_Title(rs.getString(2));
				vo.setNotice_Contents(rs.getString(3));
				vo.setNotice_Date(rs.getString(4));
				vo.setId(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return vo;
		
	}
	
	
	// 공지사항 총 갯수
	public int countNotice(){
		
		int count=0;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		String sql = "select count(*) from NOTICE";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}

}
