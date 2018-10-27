package diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import jdbc.JdbcUtil;

public class Diary_CommentDBBean{
	
	private static Diary_CommentDBBean instance = new Diary_CommentDBBean();
	
	public static Diary_CommentDBBean getInstance() {
		return instance;
	}
	
	private Diary_CommentDBBean() {}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public Diary_CommentDataBean getComment(int dc_num) throws Exception{
		System.out.println("코멘트 가져옵니다.");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Diary_CommentDataBean comment = new Diary_CommentDataBean();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from diary_comment where dc_num=?");
			pstmt.setInt(1,dc_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				comment.setD_num(rs.getInt("d_num"));
				comment.setDc_num(rs.getInt("dc_num"));
				comment.setDc_content(rs.getString("dc_content"));
				comment.setDc_reg_date(rs.getTimestamp("dc_reg_date"));
				comment.setCommenter(rs.getString("commenter"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return comment;
	}
	
	
	public List getComments(int d_num) throws Exception{
		System.out.println("코멘트들가오져기 start"+d_num);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List commentList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from diary_comment where d_num=? order by dc_num");
			pstmt.setInt(1,d_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				commentList = new ArrayList();
				do {
					Diary_CommentDataBean comment = new Diary_CommentDataBean();
					
					comment.setD_num(rs.getInt("d_num"));
					comment.setDc_num(rs.getInt("dc_num"));
					comment.setDc_content(rs.getString("dc_content"));
					comment.setDc_reg_date(rs.getTimestamp("dc_reg_date"));
					comment.setCommenter(rs.getString("commenter"));

					commentList.add(comment);
				}while(rs.next());
			}else {
				commentList = Collections.EMPTY_LIST;
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		System.out.println("완료");
		return commentList;
	}
    
    
    public String change_Name(String commenter) {
    	System.out.println("commenter 체크 들어감"+commenter);
    	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String real_name = "";
		String sql = "";
		
		if(commenter.contains("teacher")) {
			sql = "select t_name from teacher where t_id = ?";
		}else {
			sql = "select u_name from users where u_id = ?";
		}
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commenter);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				real_name = rs.getString(1);
			}else{
				real_name = "(이름없음)";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		System.out.println("[완료]리얼네임 ="+real_name);
    	return real_name;
    }
    
    public HashMap<String, Object> insertComment(Diary_CommentDataBean comment) throws Exception{
    	System.out.println("insertComment실행");
    	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List comments = new ArrayList();

		int x=0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into diary_comment(d_num,dc_num,dc_content,dc_reg_date,commenter) values(?,seq_d_num.nextval,?,?,?)");
			
			pstmt.setInt(1,comment.getD_num());
			pstmt.setString(2,comment.getDc_content());
			pstmt.setTimestamp(3,comment.getDc_reg_date());
			pstmt.setString(4,comment.getCommenter());
			
			x = pstmt.executeUpdate();

			if(x==1) {
				System.out.println("[축하]성공적으로 댓글 넣음!");
				comments = getComments(comment.getD_num());
			}else {
				System.out.println("[실패]");
				comments = Collections.EMPTY_LIST;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		HashMap<String, Object> hm = new HashMap<>();
	    hm.put("result", x);
	    hm.put("comments", comments);
	    
		return hm;
    }


    public int updateComment(Diary_CommentDataBean comment) throws Exception{
    	System.out.println("updatecomment 실행");
    	
    	Connection conn= null;
    	PreparedStatement pstmt = null;
    	String sql="";
    	
    	int x = 0;
    	
    	try {
    		conn = getConnection();
    		pstmt = conn.prepareStatement("update diary_comment set dc_content=?,dc_reg_date=? where dc_num=?");    		
    		pstmt.setString(1, comment.getDc_content());
    		pstmt.setTimestamp(2, comment.getDc_reg_date());
    		pstmt.setInt(3, comment.getDc_num());
    		x = pstmt.executeUpdate();
    		
    		if(x == 1) {
    			System.out.println("[성공]");
    		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
        return x;
    }
    
	public int deleteComment(int dc_num) throws Exception{
		System.out.println("코멘트 삭제 start!   "+dc_num);

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from diary_comment where dc_num=?");
			pstmt.setInt(1,dc_num);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("[성공]");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return result;
	}
   
	public int getD_num(int dc_num) throws Exception{
		System.out.println("코멘트 삭제2 start!   "+dc_num);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select d_num from diary_comment where dc_num= ?");
			pstmt.setInt(1,dc_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.println("실행!"+result);
			}else {
				System.out.println("안실행");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return result;
	}
}
