package com.dadam.coreer.vo;

public class MemberVO {
	String member_Id;
	String member_Pw;
	String member_Name;
	String member_PhoneNumber;
	int member_Point;
	int member_IsAdmin;
	String member_DropDate;
	String firstBrand;
	String secondBrand;
	String thirdBrand;


	public MemberVO(String member_Id, String member_Pw, String member_Name, String member_PhoneNumber, int member_Point,
			int member_IsAdmin, String member_DropDate, String firstBrand, String secondBrand, String thirdBrand) {
		super();
		this.member_Id = member_Id;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.member_PhoneNumber = member_PhoneNumber;
		this.member_Point = member_Point;
		this.member_IsAdmin = member_IsAdmin;
		this.member_DropDate = member_DropDate;
		this.firstBrand = firstBrand;
		this.secondBrand = secondBrand;
		this.thirdBrand = thirdBrand;
	}

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getMember_Pw() {
		return member_Pw;
	}

	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}

	public String getMember_Name() {
		return member_Name;
	}

	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}

	public String getMember_PhoneNumber() {
		return member_PhoneNumber;
	}

	public void setMember_PhoneNumber(String member_PhoneNumber) {
		this.member_PhoneNumber = member_PhoneNumber;
	}

	public int getMember_Point() {
		return member_Point;
	}

	public void setMember_Point(int member_Point) {
		this.member_Point = member_Point;
	}

	public int getMember_IsAdmin() {
		return member_IsAdmin;
	}

	public void setMember_IsAdmin(int member_IsAdmin) {
		this.member_IsAdmin = member_IsAdmin;
	}

	public String getMember_DropDate() {
		return member_DropDate;
	}

	public void setMember_DropDate(String member_DropDate) {
		this.member_DropDate = member_DropDate;
	}

	public String getFirstBrand() {
		return firstBrand;
	}

	public void setFirstBrand(String firstBrand) {
		this.firstBrand = firstBrand;
	}

	public String getSecondBrand() {
		return secondBrand;
	}

	public void setSecondBrand(String secondBrand) {
		this.secondBrand = secondBrand;
	}

	public String getThirdBrand() {
		return thirdBrand;
	}

	public void setThirdBrand(String thirdBrand) {
		this.thirdBrand = thirdBrand;
	}

}