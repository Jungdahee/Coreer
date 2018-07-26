package com.dadam.coreer.dao;
import com.dadam.coreer.vo.MemberVO;

//DAO ��� ���� �Է� �� ��� �뵵
//VO�� ���� �뵵
public interface IMemberDAO {
   /** �α���
    *  �Է°� : ���̵�, ��й�ȣ ->�α����� �� ���� �� ,Ż��¥
    *  ��°� : �̸�, ȸ�����(�����, ������) , ����Ʈ
    *  member */
   MemberVO login(String id, String pw, String dropDate);
   MemberVO login(MemberVO vo);
   
   /** �ߺ�Ȯ��(ȸ������ ��)
    * �Է°� : ���̵�
    * ��°� : �ߺ����� ������ true, ������ false 
    * member */
   boolean memberIdCheck(String id);
   
   /**�н����� üũ(������ ���� �� �н����� ��ġ�ϴ��� ���� üũ) -> ��й�ȣ �Է� �� ���� ����
    * �Է°� : ���̵�, �Է��� ��й�ȣ
    * ��°� : ���� �� true, �ٸ� �� false 
    * member */
   boolean memberPwCheck(String id, String pw);
   
   /** ȸ������
    * �Է°� : ���̵�, ��й�ȣ, �̸�, ����ó, ��ȣ �귣��(1-3)
    * ��°� : ���� 
    * member */
   void addMember(String id, String pw, String name, String phone, String firstBrand, String secondBrand, String thirdBrand);
   
   /** ������ ����
    * �Է°� : ���̵�(����X, ���Ƕ�����), ���ο� ��й�ȣ, ����ó, �̸�, ��ȣ �귣��(3��)
    * ��°� : ���� 
    * member */
   void updateInfo(String id, String pw, String phone, String name, String firstBrand, String secondBrand, String thirdBrand);
   
   /** ����Ʈ ����
    * �Է°�: ���̵�, ����Ʈ
    * ��°�: �ʿ����
    */
   void updatePoint(String id, int point);
   
   //����: �Ѵ��� �����Ⱓ�� �� ������? Ȥ�� Ż�� �� �Ѵ� ���� ������ ���ϰ� �� ������?
   /** Ż�� ��¥ ����
    * �Է°�: ���̵�
    * ��°�: ���� 
    */
   void updateDropDate(String id);
   
   /**  ID ã��
    * 	�Է°� : �̸�, ����ó
    * 	��°� : ���̵�
    * */
   
   String findId(String name , String phoneNumber);
   
   /**  Pw ã��
    * 	�Է°� : ���̵�,�̸�, ����ó
    * 	��°� : ��й�ȣ
    * */
   
   String findPw(String id, String name , String phoneNumber);
   
   /** ����������
    *  �Է°� : ���̵�
    *  ��°� : MemberVO
    * 
    * */
   MemberVO showMyInfo(String id);
   
   /** Ż�� ���
    *  �Է°� : ���̵�
    *  ��°� : ����
    * 	*/
   
   void updateCancelDropDate(String id);
   
   /** Ż�� Ȯ��*/
   
   String selectDropDate(String id);
}
 