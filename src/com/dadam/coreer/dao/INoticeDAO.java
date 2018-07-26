package com.dadam.coreer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.dadam.coreer.vo.NoticeVO;


public interface INoticeDAO {
	/** 공지사항 목록
	 * 입력값 : 없음
	 * 출력값 : 없음 
	 * @return 
	 * */
	
	ArrayList<NoticeVO> listNotice(HashMap<String, Object> listOpt) throws SQLException;
	
	/** 공지사항 내용
	 * 	입력값 : 공지사항 번호
	 * 	출력값 : NoticeVO
	 * @return
	 */
	NoticeVO selectNotice(int noticeNum);
	
	
	/** 공지사항 입력
	 * 입력값: 아이디, 제목, 내용, 날짜(now() 함수로)
	 * 출력값: 없음
	 * @throws SQLException 
	 */
	void insertNotice(String id, String title, String contents) throws SQLException;
	
	/** 공지사항 수정
	 * 입력값: 제목, 내용, 날짜(now()), 글 번호
	 * 출력값: 없음
	 */
	void updateNotice(String title, String contents, int noticeNum);
	
	/** 공지사항 삭제
	 * 입력값: 글 번호
	 * 출력값: 없음
	 */
	void deleteNotice(int noticeNum);
	
	/** 공지사항 목록
	 * 입력값: 없음
	 * 출력값: 
	 */
	//ArrayList<MainVO> getMainList(HashMap<String, Object> listOpt); 

}
