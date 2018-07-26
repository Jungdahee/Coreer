package com.dadam.coreer.vo;

public class MenuVO {
	String menu_Number;
	String menu_Name;
	int menu_Price;
	double menu_AvgScore;
	int menu_Caffeine;
	int menu_Calorie;
	int menu_Capacity;
	String menu_Image;
	int brand_Number;
	String brand_Name;

	public MenuVO(){

	}

	public MenuVO(String menu_Number, String menu_Name, int menu_Price, double menu_AvgScore, int menu_Caffeine,
			int menu_Calorie, int menu_Capacity, String menu_Image, int brand_Number) {
		super();
		this.menu_Number = menu_Number;
		this.menu_Name = menu_Name;
		this.menu_Price = menu_Price;
		this.menu_AvgScore = menu_AvgScore;
		this.menu_Caffeine = menu_Caffeine;
		this.menu_Calorie = menu_Calorie;
		this.menu_Capacity = menu_Capacity;
		this.menu_Image = menu_Image;
		this.brand_Number = brand_Number;
	}


	public String getMenu_Number() {
		return menu_Number;
	}


	public void setMenu_Number(String menu_Number) {
		this.menu_Number = menu_Number;
	}


	public String getMenu_Name() {
		return menu_Name;
	}


	public void setMenu_Name(String menu_Name) {
		this.menu_Name = menu_Name;
	}


	public int getMenu_Price() {
		return menu_Price;
	}


	public void setMenu_Price(int menu_Price) {
		this.menu_Price = menu_Price;
	}


	public double getMenu_AvgScore() {
		return menu_AvgScore;
	}


	public void setMenu_AvgScore(double menu_AvgScore) {
		this.menu_AvgScore = menu_AvgScore;
	}


	public int getMenu_Caffeine() {
		return menu_Caffeine;
	}


	public void setMenu_Caffeine(int menu_Caffeine) {
		this.menu_Caffeine = menu_Caffeine;
	}


	public int getMenu_Calorie() {
		return menu_Calorie;
	}


	public void setMenu_Calorie(int menu_Calorie) {
		this.menu_Calorie = menu_Calorie;
	}


	public int getMenu_Capacity() {
		return menu_Capacity;
	}


	public void setMenu_Capacity(int menu_Capacity) {
		this.menu_Capacity = menu_Capacity;
	}


	public String getMenu_Image() {
		return menu_Image;
	}


	public void setMenu_Image(String menu_Image) {
		this.menu_Image = menu_Image;
	}


	public int getBrand_Number() {
		return brand_Number;
	}


	public void setBrand_Number(int brand_Number) {
		this.brand_Number = brand_Number;
	}

	public String getBrand_Name() {
		return brand_Name;
	}

	public void setBrand_Name(String brand_Name) {
		this.brand_Name = brand_Name;
	}

}