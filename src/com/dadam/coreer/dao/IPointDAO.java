package com.dadam.coreer.dao;

import com.dadam.coreer.vo.PointVO;

public interface IPointDAO {
   /*����Ʈ��������
    * �Է°�:���̵�, 
    * ��°�: ����
    * */
   void insertPointDetail(String id);

   /*����Ʈ����Ʈ��������
    * �Է°�:���̵�
    * ��°�:PointVO
    * */
   PointVO selectPointDetail(String id);
}