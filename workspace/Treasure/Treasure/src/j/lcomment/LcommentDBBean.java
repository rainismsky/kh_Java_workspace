package j.lcomment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LcommentDBBean {
	
	private static LcommentDBBean instance = new LcommentDBBean();
	
	public static LcommentDBBean getInstance() {
		return instance;
	}
	
	private LcommentDBBean() {}
	
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public void insertLcomment (LcommentDataBean lcomm, int show_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into line_comment values(LINE_COMMENT_SEQ.NEXTVAL,?,?,?,?)");
			
			pstmt.setInt(1, show_no);
			pstmt.setString(2, lcomm.getL_comm_content());
			pstmt.setString(3, lcomm.getUser_id());
			pstmt.setTimestamp(4, lcomm.getL_comm_date());
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}

}
