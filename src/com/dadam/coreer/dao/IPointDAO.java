package com.dadam.coreer.dao;

import com.dadam.coreer.vo.PointVO;

public interface IPointDAO {
   /*포인트내역삽입
    * 입력값:아이디, 
    * 출력값: 없음
    * */
   void insertPointDetail(String id);

   /*포인트리스트가져오기
    * 입력값:아이디
    * 출력값:PointVO
    * */
   PointVO selectPointDetail(String id);
}