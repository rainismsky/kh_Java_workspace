package logon;

import java.sql.Timestamp;

public class B_commentDataBean {
	private int b_c_no;
	private int b_no;
	private String b_c_content;
	private String user_id;
	private Timestamp b_c_date;
	public int getB_c_no() {
		return b_c_no;
	}
	public void setB_c_no(int b_c_no) {
		this.b_c_no = b_c_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_c_content() {
		return b_c_content;
	}
	public void setB_c_content(String b_c_content) {
		this.b_c_content = b_c_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getB_c_date() {
		return b_c_date;
	}
	public void setB_c_date(Timestamp b_c_date) {
		this.b_c_date = b_c_date;
	}
	
	
}
