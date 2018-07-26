package com.dadam.coreer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dadam.coreer.vo.ReviewVO;
import java.sql.PreparedStatement;

public class ReviewDAO implements IReviewDAO {
	
	private Connection conn;
	
	public ReviewDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/coreer?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "root");
		}catch(Exception e){
		    e.printStackTrace();
			throw new RuntimeException("Connection Exception");
		}
	}
	
	
	@Override
	public ArrayList<ReviewVO> showReview(String menuNumber) {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		
		String sql = 
		" select * from review where menu_number = ?";
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menuNumber);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setReview_Number(rs.getInt(1));
				vo.setReview_Contents(rs.getString(2));
				vo.setReview_Date(rs.getString(3));
				vo.setReview_Score(rs.getInt(4));
				vo.setReview_Good(rs.getInt(5));
				vo.setId(rs.getString(6));
				vo.setMenu_Number(rs.getString(7));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void insertReview(ReviewVO vo) {
		String sql = "insert into review (review_number, review_contents, review_date, review_score, review_good, member_id, menu_number) values ((select COALESCE(MAX(review_number),0) + 1 from review a), ?, now(), ?, 0 , ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReview_Contents());
			pstmt.setDouble(2, vo.getReview_Score());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getMenu_Number());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReview(ReviewVO vo) {
		String sql = "update review set Review_Contents = ?, review_score = ? where review_number = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReview_Contents());
			pstmt.setInt(2, vo.getReview_Score());
			pstmt.setInt(3, vo.getReview_Number());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteReview(int reviewNum) {
		String historyDeleteSql = "delete from history where review_number = ?";
		String sql = "delete from review where review_number = ?";
		
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(historyDeleteSql);
			pstmt.setInt(1, reviewNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateGood(int reviewNum, String goodOrBad, String user_id) {
		String sql = "";
		String historyInsertSql = "";
		
		if(goodOrBad.equals("good")) {
			// ≈‰±€, 0¿∏∑Œ πŸ≤„æﬂµ 
			sql = "update review set review_good = review_good + 1 where review_number = ?;";
			historyInsertSql = "insert into history values((select COALESCE(MAX(History_Id),0) + 1 from history a), ?, ?, 2);";
		}
		else {
			sql = "update review set review_good = review_good - 1 where review_number = ?;";
			historyInsertSql = "insert into history values((select COALESCE(MAX(History_Id),0) + 1 from history a), ?, ?, 1);";
		}
		
		PreparedStatement pstmt = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt = conn.prepareStatement(historyInsertSql);
			pstmt.setInt(1, reviewNum);
			pstmt.setString(2, user_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int getHistory(int reviewNum, String userId) {
		String sql = "select good from history where review_number = ? and user_id = ? order by history_id desc limit 1;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();			
			
			while(rs.next()){
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		return result;
	}

}
