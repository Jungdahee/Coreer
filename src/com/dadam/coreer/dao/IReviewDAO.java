package com.dadam.coreer.dao;

import java.util.ArrayList;

import com.dadam.coreer.vo.ReviewVO;

public interface IReviewDAO {
	/** ���� ���
	 * �Է°�: �޴� ��ȣ
	 * ��°�: ArrayList<> 
	 */
	ArrayList<ReviewVO> showReview(String menuNumber);
	
	/** ���� �Է�
	 * �Է°�: ReviewVO
	 * ��°�: ����Ʈ
	 */
	void insertReview(ReviewVO vo);
	
	/** ���� ����
	 * �Է°�: ���� ��ȣ, ���� ����, ����, ��¥(now())
	 * ��°�: ����
	 */
	void updateReview(ReviewVO vo);
	
	/** ���� ����
	 * �Է°�: ���� ��ȣ
	 * ��°�: ����
	 */
	void deleteReview(int reviewNum);
	
	/** ������ ����
	 * �Է°�: ���� ��ȣ
	 * ��°�: ����
	 */
	public void updateGood(int reviewNum, String goodOrBad, String user_id);
	
	int getHistory(int reviewNum, String userId);

	

}
