package com.dadam.coreer.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dadam.coreer.vo.MenuVO;

public interface IMenuDAO {
   /** �޴� ��� 
    * �Է°�: �귣�庰, Ŀ�Ǻ�, ��ȣ�귣��
    * ��°�: ArrayList(MenuVO)
    * @throws SQLException 
    * 
    */
   ArrayList<MenuVO> listMenu() throws SQLException; //�ʱ�ȭ�� ��ü ����Ʈ 
   ArrayList<MenuVO> listMenu(String[] menu_Number,String[] brand_Number) throws SQLException;
   
   MenuVO selectMenu(String num) throws SQLException; //���� ���ǿ� �ش��ϴ� ����Ʈ //�޴� ��ȣ�� ����Ʈ �ؾ���
   /** �޴� ����
    * �Է°�: �޴� ��ȣ
    * ��°�: MenuVO
    */
   
   void insertMenu(MenuVO vo) throws SQLException;
   /** �޴� �Է�(������)
    * �Է°�: MenuVO
    * ��°�: ����
    * @throws SQLException 
    */ 
   
   void updateMenu(MenuVO vo) throws SQLException;
   /** �޴� ����
    * �Է°�: MenuVO
    * ��°�: ����
    * @throws SQLException 
    */
   
   void deleteMenu(String num) throws SQLException;
   /** �޴� ����
    * �Է°�: �޴� ��ȣ
    * ��°�: ����
    * @throws SQLException 
    */
   
   void updateAvgScore(int num, double score) throws SQLException;
   /** ���� ����
    * �Է°�: �޴� ��ȣ, ����
    * ��°�: ����
    * @throws SQLException 
    */


}