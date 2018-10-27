package j.lcomment;

import java.sql.Timestamp;

public class LcommentDataBean {
	
	private int l_comm_no;
	private int show_no;
	private String l_comm_content;
	private String user_id;
	private Timestamp l_comm_date;
	
	public int getL_comm_no() {
		return l_comm_no;
	}
	public void setL_comm_no(int l_comm_no) {
		this.l_comm_no = l_comm_no;
	}
	public int getShow_no() {
		return show_no;
	}
	public void setShow_no(int show_no) {
		this.show_no = show_no;
	}
	public String getL_comm_content() {
		return l_comm_content;
	}
	public void setL_comm_content(String l_comm_content) {
		this.l_comm_content = l_comm_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getL_comm_date() {
		return l_comm_date;
	}
	public void setL_comm_date(Timestamp l_comm_date) {
		this.l_comm_date = l_comm_date;
	}
	
	

}
