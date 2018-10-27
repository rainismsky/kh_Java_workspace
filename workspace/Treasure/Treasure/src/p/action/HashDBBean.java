package p.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HashDBBean {
	private static HashDBBean instance = new HashDBBean();
	
	public static HashDBBean getInstance() {
		return instance;
	}
	
	private HashDBBean() {}
	
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public void insertHash(ArrayList<HashDataBean> article, int show_no) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn=getConnection();
		String sql="";
		sql = "insert into hashtag(h_tag, show_no) values(?,?)";
		
		pstmt = conn.prepareStatement(sql);
		for(int i = 0; article.size() > i; i++) {
			pstmt.setString(1, article.get(i).getH_tag());
			pstmt.setInt(2, show_no);
			System.out.println(show_no);
			pstmt.executeUpdate();
			System.out.println("i" + i);
	}
	}
}















