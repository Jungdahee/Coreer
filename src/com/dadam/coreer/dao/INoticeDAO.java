package com.dadam.coreer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.dadam.coreer.vo.NoticeVO;


public interface INoticeDAO {
	/** �������� ���
	 * �Է°� : ����
	 * ��°� : ���� 
	 * @return 
	 * */
	
	ArrayList<NoticeVO> listNotice(HashMap<String, Object> listOpt) throws SQLException;
	
	/** �������� ����
	 * 	�Է°� : �������� ��ȣ
	 * 	��°� : NoticeVO
	 * @return
	 */
	NoticeVO selectNotice(int noticeNum);
	
	
	/** �������� �Է�
	 * �Է°�: ���̵�, ����, ����, ��¥(now() �Լ���)
	 * ��°�: ����
	 * @throws SQLException 
	 */
	void insertNotice(String id, String title, String contents) throws SQLException;
	
	/** �������� ����
	 * �Է°�: ����, ����, ��¥(now()), �� ��ȣ
	 * ��°�: ����
	 */
	void updateNotice(String title, String contents, int noticeNum);
	
	/** �������� ����
	 * �Է°�: �� ��ȣ
	 * ��°�: ����
	 */
	void deleteNotice(int noticeNum);
	
	/** �������� ���
	 * �Է°�: ����
	 * ��°�: 
	 */
	//ArrayList<MainVO> getMainList(HashMap<String, Object> listOpt); 

}
