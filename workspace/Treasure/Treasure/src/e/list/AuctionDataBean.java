package e.list;

import java.sql.Timestamp;

public class AuctionDataBean {

	 private int auc_ing_no;
	 private int auc_sp;
     private String auc_image;
     private String l_category_name;
     private Timestamp auc_start;
     private Timestamp auc_end;
     private String user_id;
     private String show_title;
     private int show_no;
     private int countedLike;
     
       
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getShow_title() {
		return show_title;
	}
	public void setShow_title(String show_title) {
		this.show_title = show_title;
	}
	public int getShow_no() {
		return show_no;
	}
	public void setShow_no(int show_no) {
		this.show_no = show_no;
	}
	public int getAuc_sp() {
		return auc_sp;
	}
	public void setAuc_sp(int auc_sp) {
		this.auc_sp = auc_sp;
	}
	public int getAuc_ing_no() {
		return auc_ing_no;
	}
	public void setAuc_ing_no(int auc_ing_no) {
		this.auc_ing_no = auc_ing_no;
	}
	public String getAuc_image() {
		return auc_image;
	}
	public void setAuc_image(String auc_image) {
		this.auc_image = auc_image;
	}
	public String getL_category_name() {
		return l_category_name;
	}
	public void setL_category_name(String l_category_name) {
		this.l_category_name = l_category_name;
	}
	public Timestamp getAuc_start() {
		return auc_start;
	}
	public void setAuc_start(Timestamp auc_start) {
		this.auc_start = auc_start;
	}
	public Timestamp getAuc_end() {
		return auc_end;
	}
	public void setAuc_end(Timestamp auc_end) {
		this.auc_end = auc_end;
	}
	public int getCountedLike() {
		return countedLike;
	}
	public void setCountedLike(int countedLike) {
		this.countedLike = countedLike;
	}

}
     
