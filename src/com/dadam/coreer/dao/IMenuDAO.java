package com.dadam.coreer.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dadam.coreer.vo.MenuVO;

public interface IMenuDAO {
   /** 메뉴 목록 
    * 입력값: 브랜드별, 커피별, 선호브랜드
    * 출력값: ArrayList(MenuVO)
    * @throws SQLException 
    * 
    */
   ArrayList<MenuVO> listMenu() throws SQLException; //초기화면 전체 리스트 
   ArrayList<MenuVO> listMenu(String[] menu_Number,String[] brand_Number) throws SQLException;
   
   MenuVO selectMenu(String num) throws SQLException; //선태 조건에 해당하는 리스트 //메뉴 번호로 셀렉트 해야함
   /** 메뉴 정보
    * 입력값: 메뉴 번호
    * 출력값: MenuVO
    */
   
   void insertMenu(MenuVO vo) throws SQLException;
   /** 메뉴 입력(관리자)
    * 입력값: MenuVO
    * 출력값: 없음
    * @throws SQLException 
    */ 
   
   void updateMenu(MenuVO vo) throws SQLException;
   /** 메뉴 수정
    * 입력값: MenuVO
    * 출력값: 없음
    * @throws SQLException 
    */
   
   void deleteMenu(String num) throws SQLException;
   /** 메뉴 삭제
    * 입력값: 메뉴 번호
    * 출력값: 없음
    * @throws SQLException 
    */
   
   void updateAvgScore(int num, double score) throws SQLException;
   /** 평점 수정
    * 입력값: 메뉴 번호, 평점
    * 출력값: 없음
    * @throws SQLException 
    */


}