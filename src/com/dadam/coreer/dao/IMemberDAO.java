package com.dadam.coreer.dao;
import com.dadam.coreer.vo.MemberVO;

//DAO 디비에 값을 입력 및 얻는 용도
//VO도 같은 용도
public interface IMemberDAO {
   /** 로그인
    *  입력값 : 아이디, 비밀번호 ->로그인할 시 들어가는 값 ,탈퇴날짜
    *  출력값 : 이름, 회원등급(사용자, 관리자) , 포인트
    *  member */
   MemberVO login(String id, String pw, String dropDate);
   MemberVO login(MemberVO vo);
   
   /** 중복확인(회원가입 시)
    * 입력값 : 아이디
    * 출력값 : 중복값이 있을때 true, 없을때 false 
    * member */
   boolean memberIdCheck(String id);
   
   /**패스워드 체크(내정보 수정 시 패스워드 일치하는지 여부 체크) -> 비밀번호 입력 후 들어가기 때문
    * 입력값 : 아이디, 입력한 비밀번호
    * 출력값 : 같을 때 true, 다를 때 false 
    * member */
   boolean memberPwCheck(String id, String pw);
   
   /** 회원가입
    * 입력값 : 아이디, 비밀번호, 이름, 연락처, 선호 브랜드(1-3)
    * 출력값 : 없음 
    * member */
   void addMember(String id, String pw, String name, String phone, String firstBrand, String secondBrand, String thirdBrand);
   
   /** 내정보 수정
    * 입력값 : 아이디(수정X, 세션때문에), 새로운 비밀번호, 연락처, 이름, 선호 브랜드(3개)
    * 출력값 : 없음 
    * member */
   void updateInfo(String id, String pw, String phone, String name, String firstBrand, String secondBrand, String thirdBrand);
   
   /** 포인트 수정
    * 입력값: 아이디, 포인트
    * 출력값: 필요없음
    */
   void updatePoint(String id, int point);
   
   //질문: 한달의 유예기간을 줄 것인지? 혹은 탈퇴 후 한달 동안 가입을 못하게 할 것인지?
   /** 탈퇴 날짜 수정
    * 입력값: 아이디
    * 출력값: 없음 
    */
   void updateDropDate(String id);
   
   /**  ID 찾기
    * 	입력값 : 이름, 연락처
    * 	출력값 : 아이디
    * */
   
   String findId(String name , String phoneNumber);
   
   /**  Pw 찾기
    * 	입력값 : 아이디,이름, 연락처
    * 	출력값 : 비밀번호
    * */
   
   String findPw(String id, String name , String phoneNumber);
   
   /** 내정보보기
    *  입력값 : 아이디
    *  출력값 : MemberVO
    * 
    * */
   MemberVO showMyInfo(String id);
   
   /** 탈퇴 취소
    *  입력값 : 아이디
    *  출력값 : 없음
    * 	*/
   
   void updateCancelDropDate(String id);
   
   /** 탈퇴 확인*/
   
   String selectDropDate(String id);
}
 