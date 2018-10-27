package s.bean;

import java.sql.Timestamp;

public class MessageDataBean {
	
	private int recieve_no;
	private String recieve_to_id;
	private String recieve_from_id;
	private String recieve_subject;
	private String recieve_content;
	private Timestamp recieve_time;
	
	private int send_no;
	private String send_to_id;
	private String send_from_id;
	private String send_subject;
	private String send_content;
	private Timestamp send_time;
	public int getRecieve_no() {
		return recieve_no;
	}
	public void setRecieve_no(int recieve_no) {
		this.recieve_no = recieve_no;
	}
	public String getRecieve_to_id() {
		return recieve_to_id;
	}
	public void setRecieve_to_id(String recieve_to_id) {
		this.recieve_to_id = recieve_to_id;
	}
	public String getRecieve_from_id() {
		return recieve_from_id;
	}
	public void setRecieve_from_id(String recieve_from_id) {
		this.recieve_from_id = recieve_from_id;
	}
	public String getRecieve_subject() {
		return recieve_subject;
	}
	public void setRecieve_subject(String recieve_subject) {
		this.recieve_subject = recieve_subject;
	}
	public String getRecieve_content() {
		return recieve_content;
	}
	public void setRecieve_content(String recieve_content) {
		this.recieve_content = recieve_content;
	}
	public Timestamp getRecieve_time() {
		return recieve_time;
	}
	public void setRecieve_time(Timestamp recieve_time) {
		this.recieve_time = recieve_time;
	}
	public int getSend_no() {
		return send_no;
	}
	public void setSend_no(int send_no) {
		this.send_no = send_no;
	}
	public String getSend_to_id() {
		return send_to_id;
	}
	public void setSend_to_id(String send_to_id) {
		this.send_to_id = send_to_id;
	}
	public String getSend_from_id() {
		return send_from_id;
	}
	public void setSend_from_id(String send_from_id) {
		this.send_from_id = send_from_id;
	}
	public String getSend_subject() {
		return send_subject;
	}
	public void setSend_subject(String send_subject) {
		this.send_subject = send_subject;
	}
	public String getSend_content() {
		return send_content;
	}
	public void setSend_content(String send_content) {
		this.send_content = send_content;
	}
	public Timestamp getSend_time() {
		return send_time;
	}
	public void setSend_time(Timestamp send_time) {
		this.send_time = send_time;
	}
	
	

}
