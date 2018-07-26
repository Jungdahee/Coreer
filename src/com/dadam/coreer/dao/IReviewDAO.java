package com.dadam.coreer.dao;

import java.util.ArrayList;

import com.dadam.coreer.vo.ReviewVO;

public interface IReviewDAO {
	/** 리뷰 목록
	 * 입력값: 메뉴 번호
	 * 출력값: ArrayList<> 
	 */
	ArrayList<ReviewVO> showReview(String menuNumber);
	
	/** 리뷰 입력
	 * 입력값: ReviewVO
	 * 출력값: 포인트
	 */
	void insertReview(ReviewVO vo);
	
	/** 리뷰 수정
	 * 입력값: 리뷰 번호, 리뷰 내용, 평점, 날짜(now())
	 * 출력값: 없음
	 */
	void updateReview(ReviewVO vo);
	
	/** 리뷰 삭제
	 * 입력값: 리뷰 번호
	 * 출력값: 없음
	 */
	void deleteReview(int reviewNum);
	
	/** 공감수 수정
	 * 입력값: 리뷰 번호
	 * 출력값: 없음
	 */
	public void updateGood(int reviewNum, String goodOrBad, String user_id);
	
	int getHistory(int reviewNum, String userId);

	

}
