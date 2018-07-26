package com.dadam.coreer.vo;

public class ReviewVO {
   int review_Number;
   String review_Contents;
   String review_Date;
   int review_Score;
   int review_Good;
   String id;
   String menu_Number;
   
   public ReviewVO(){}
   
   public ReviewVO(int review_Number, String review_Contents, String review_Date, int review_Score, int review_Good,
         String id, String menu_Number) {
      super();
      this.review_Number = review_Number;
      this.review_Contents = review_Contents;
      this.review_Date = review_Date;
      this.review_Score = review_Score;
      this.review_Good = review_Good;
      this.id = id;
      this.menu_Number = menu_Number;
   }


   public int getReview_Number() {
      return review_Number;
   }


   public void setReview_Number(int review_Number) {
      this.review_Number = review_Number;
   }


   public String getReview_Contents() {
      return review_Contents;
   }


   public void setReview_Contents(String review_Contents) {
      this.review_Contents = review_Contents;
   }


   public String getReview_Date() {
      return review_Date;
   }


   public void setReview_Date(String review_Date) {
      this.review_Date = review_Date;
   }


   public int getReview_Score() {
      return review_Score;
   }


   public void setReview_Score(int review_Score) {
      this.review_Score = review_Score;
   }


   public int getReview_Good() {
      return review_Good;
   }


   public void setReview_Good(int review_Good) {
      this.review_Good = review_Good;
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getMenu_Number() {
      return menu_Number;
   }


   public void setMenu_Number(String menu_Number) {
      this.menu_Number = menu_Number;
   }
   
   
   
   
}