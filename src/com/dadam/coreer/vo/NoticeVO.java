package com.dadam.coreer.vo;

public class NoticeVO {
	int notice_Number;
	String notice_Title;
	String notice_Contents;
	String notice_Date;
	String id;
	
	public NoticeVO(){}
	
	public NoticeVO(int notice_Number, String notice_Title, String notice_Contents, String notice_Date, String id) {
		super();
		this.notice_Number = notice_Number;
		this.notice_Title = notice_Title;
		this.notice_Contents = notice_Contents;
		this.notice_Date = notice_Date;
		this.id = id;
	}


	public int getNotice_Number() {
		return notice_Number;
	}


	public void setNotice_Number(int notice_Number) {
		this.notice_Number = notice_Number;
	}


	public String getNotice_Title() {
		return notice_Title;
	}


	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}


	public String getNotice_Contents() {
		return notice_Contents;
	}


	public void setNotice_Contents(String notice_Contents) {
		this.notice_Contents = notice_Contents;
	}


	public String getNotice_Date() {
		return notice_Date;
	}


	public void setNotice_Date(String notice_Date) {
		this.notice_Date = notice_Date;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [notice_Number=" + notice_Number + ", notice_Title=" + notice_Title + ", notice_Contents=" + notice_Contents + ", notice_Date=" + notice_Date
				 + "]";
	}
	
	
	
	
	
	
}
