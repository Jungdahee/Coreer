package com.dadam.coreer.test;

import java.sql.SQLException;

import com.dadam.coreer.dao.NoticeDAO;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//new NoticeDAO().insertNotice("jinggor", "��������2", "��������2");
		int count = new NoticeDAO().countNotice();
		
		System.out.println(count);
		
		// ���⼭ �׽�Ʈ �ϸ� �ſ�.

	}

}
