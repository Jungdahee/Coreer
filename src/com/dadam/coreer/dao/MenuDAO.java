package com.dadam.coreer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dadam.coreer.vo.MenuVO;

public class MenuDAO implements IMenuDAO {

	private Connection conn;
	public MenuDAO(){
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

	String sql;
	
	
	// 메뉴 전체 목록
	@Override
	public ArrayList<MenuVO> listMenu(){ //전체 리스트
		// TODO Auto-generated method stub
		ArrayList<MenuVO> menuList = new ArrayList<MenuVO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "select Menu_Image, Menu_Name, Menu_Price, Brand_Name, Menu_Number from MENU,BRAND where MENU.Brand_Number = BRAND.Brand_Number";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//메뉴 이미지, 메뉴 이름, 메뉴 가격 보여주기 

		try {
			while(rs.next()){
				MenuVO vo = new MenuVO();
				vo.setMenu_Image(rs.getString(1));
				vo.setMenu_Name(rs.getString(2));
				vo.setMenu_Price(rs.getInt(3));
				vo.setBrand_Name(rs.getString(4));
				vo.setMenu_Number(rs.getString(5));
				menuList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuList;
	}
	
	// 메뉴 선택 목록
	@Override
	public ArrayList<MenuVO> listMenu(String[] menu_Number, String[] brand_Number) throws SQLException {
		// TODO Auto-generated method stub
		int i=0;
		ArrayList<MenuVO> menuList = new ArrayList<MenuVO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "select Menu_Image, Menu_Name, Menu_Price, Brand_Name, Menu_Number from MENU,BRAND where MENU.Brand_Number = BRAND.Brand_Number and ";
		
		if(menu_Number == null && brand_Number != null){
			if(brand_Number.length==1)
				sql = sql + "MENU.Brand_Number in (" +brand_Number[0] + ")";
			else{
				for(i=0;i<brand_Number.length;i++){
					if(i==0)
						sql = sql + "MENU.Brand_Number in (" +brand_Number[i] + ",";
					else if(i!=brand_Number.length-1)
						sql = sql + brand_Number[i] + ",";
					else
						sql = sql + brand_Number[i] + ")";
				}
			}
		}
		
		else if(menu_Number != null && brand_Number == null){
			if(menu_Number.length==1)
				sql = sql + "SUBSTRING(Menu_Number,1,2) in (\'" +menu_Number[0] + "\')";
			else{
				for(i=0;i<menu_Number.length;i++){
					if(i==0)
						sql = sql + "SUBSTRING(Menu_Number,1,2) in (\'" +menu_Number[i] + "\',";
					else if(i!=menu_Number.length-1)
						sql = sql +"\'"+ menu_Number[i] + "\',";
					else
						sql = sql +"\'"+ menu_Number[i] + "\')";
				}
			}
		}
		
		else{
			if(brand_Number.length==1)
				sql = sql + "MENU.Brand_Number in (" +brand_Number[0] + ") and ";
			else{
				for(i=0;i<brand_Number.length;i++){
					if(i==0)
						sql = sql + "MENU.Brand_Number in (" +brand_Number[i] + ",";
					else if(i!=brand_Number.length-1)
						sql = sql + brand_Number[i] + ",";
					else
						sql = sql + brand_Number[i] + ") and ";
				}
			}
			
			if(menu_Number.length==1)
				sql = sql + "SUBSTRING(Menu_Number,1,2) in (\'" +menu_Number[0] + "\')";
			else{
				for(i=0;i<menu_Number.length;i++){
					if(i==0)
						sql = sql + "SUBSTRING(Menu_Number,1,2) in (\'" +menu_Number[i] + "\',";
					else if(i!=menu_Number.length-1)
						sql = sql +"\'"+ menu_Number[i] + "\',";
					else
						sql = sql +"\'"+ menu_Number[i] + "\')";
				}
			}
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//메뉴 이미지, 메뉴 이름, 메뉴 가격 보여주기 

		try {
			while(rs.next()){
				MenuVO vo = new MenuVO();
				vo.setMenu_Image(rs.getString(1));
				vo.setMenu_Name(rs.getString(2));
				vo.setMenu_Price(rs.getInt(3));
				vo.setBrand_Name(rs.getString(4));
				vo.setMenu_Number(rs.getString(5));
				menuList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuList;
		
		
	}
	
	
	// 메뉴 정보 보기
	@Override
	public MenuVO selectMenu(String num){ //상세 정보
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = "select Menu_Number, Menu_Name,Menu_Price,Menu_Caffeine,Menu_Calorie,Menu_Capacity,Menu_Image,Brand_Name, Menu_AvgScore from MENU,BRAND where MENU.Brand_Number = BRAND.Brand_Number and Menu_Number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs.next()){
				vo.setMenu_Number(rs.getString(1));
				vo.setMenu_Name(rs.getString(2));
				vo.setMenu_Price(rs.getInt(3));
				vo.setMenu_Caffeine(rs.getInt(4));
				vo.setMenu_Calorie(rs.getInt(5));
				vo.setMenu_Capacity(rs.getInt(6));
				vo.setMenu_Image(rs.getString(7));
				vo.setBrand_Name(rs.getString(8));
				vo.setMenu_AvgScore(rs.getDouble(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;

	}
	
	
	// 메뉴 등록
	@Override
	public void insertMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		sql = "insert into MENU(Menu_Number,Menu_Name,Menu_Price,Menu_AvgScore,Menu_Caffeine,Menu_Calorie,Menu_Capacity,Menu_Image,Brand_Number) values (?,?,?,?,?,?,?,?,?)";
		try {
			/*서블릿에서 request를 바탕으로 vo를 만들어서 MenuDAO의 insert 함수를 실행시킴 -> 여기서는 넘어온 파라미터 vo를 사용함.
    	 넘어온 파라미터에서 sql문을 실행하기 위한 것들을 get 함수로 가져오고 이것을 새로운 변수 pstmt에 할당하여 쿼리 실행 */
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMenu_Number());
			pstmt.setString(2, vo.getMenu_Name());
			pstmt.setInt(3, vo.getMenu_Price());
			pstmt.setDouble(4, vo.getMenu_AvgScore());
			pstmt.setInt(5, vo.getMenu_Caffeine());
			pstmt.setInt(6, vo.getMenu_Calorie());
			pstmt.setInt(7, vo.getMenu_Capacity());
			pstmt.setString(8, vo.getMenu_Image());
			pstmt.setInt(9, vo.getBrand_Number());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	// 메뉴 수정
	@Override
	public void updateMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		sql = "update MENU set Menu_Name = ?,Menu_Price = ?,Menu_Image = ?, Menu_Calorie = ?, Menu_Caffeine = ?, Menu_Capacity = ? where Menu_Number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMenu_Name());
			pstmt.setInt(2, vo.getMenu_Price());
			pstmt.setString(3, vo.getMenu_Image());
			pstmt.setInt(4, vo.getMenu_Calorie());
			pstmt.setInt(5, vo.getMenu_Caffeine());
			pstmt.setInt(6, vo.getMenu_Capacity());
			pstmt.setString(7, vo.getMenu_Number());


			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 메뉴 삭제
	@Override
	public void deleteMenu(String num){
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		sql = "delete from REVIEW where Menu_Number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sql = "delete from MENU where Menu_Number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

	}
	
	
	// 평점 수정
	@Override
	//num에 해당하는 게 메뉴 번호인지?메뉴 번호라면 String 타입으로 변경해야함
	public void updateAvgScore(int num, double score) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		sql = "update MENU set Menu_AvgScore = ? where Menu_Number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}