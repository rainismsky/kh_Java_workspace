package logon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class LogonDBBean {//DB와 관련된 일을 하는 클래스: DBBean, DAO
   
	private static LogonDBBean instance = new LogonDBBean();
   
	//LogonDBBean m = LogonDBBean.getInstance();
    public static LogonDBBean getInstance() {
        return instance;
    }
   
    private LogonDBBean() {} //외부에서 못만들게
   
    private Connection getConnection() throws Exception { //getConnection() 메서드 이용해서 계속 호출
    	String jdbcDriver = "jdbc:apache:commons:dbcp:pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    //inputPro.jsp
    public void insertMember(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
 //DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
            pstmt = conn.prepareStatement(
            "insert into users values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pw());
            pstmt.setString(3, member.getUser_grade());
            pstmt.setString(4, member.getUser_name());
            pstmt.setString(5, member.getUser_birth());
            pstmt.setString(6, member.getUser_gender());
            pstmt.setString(7, member.getUser_phone()); 
            pstmt.setString(8, member.getUser_email());
            pstmt.setString(9, member.getUser_pw_hint());
            pstmt.setString(10, member.getUser_introduction());
            pstmt.setString(11, member.getUser_photo());
            pstmt.setString(12, member.getUser_con1());
            pstmt.setString(13, member.getUser_con2());
            pstmt.setString(14, member.getUser_con3());
            pstmt.setTimestamp(15, member.getUser_date());
            pstmt.setInt(16, member.getDay_post());
            pstmt.setInt(17, member.getTotal_like());
            pstmt.setInt(18, member.getTotal_post());
            
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    //loginPro.jsp
    public int userCheck(String user_id, String user_pw) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;    
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select user_pw from users where user_id = ?");
            pstmt.setString(1, user_id);
            rs= pstmt.executeQuery();

            if(rs.next()){
            	dbpasswd= rs.getString("user_pw");
            	if(dbpasswd.equals(user_pw))
            		x= 1; //인증 성공
            	else
            		x= 0; //비밀번호 틀림
            }else
            	x= -1;//해당 아이디 없음

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    //confirmId.jsp
    public int confirmId(String user_id) throws Exception {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;//경우의 수
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select user_id from users where user_id = ?");
            pstmt.setString(1, user_id);
            rs= pstmt.executeQuery();

            if(rs.next())
            	x= 1; //해당 아이디 있음
            else
            	x= -1;//해당 아이디 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }

    //modifyForm.jsp
    public LogonDataBean getMember(String user_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean member=null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from users where user_id = ?");
            pstmt.setString(1, user_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new LogonDataBean();
                member.setUser_id(rs.getString("user_id"));
                member.setUser_pw(rs.getString("user_pw"));
                member.setUser_name(rs.getString("user_name"));
                member.setUser_birth(rs.getString("user_birth"));
                member.setUser_gender(rs.getString("user_gender"));
                member.setUser_phone(rs.getString("user_phone"));
                member.setUser_email(rs.getString("user_email"));
                member.setUser_pw_hint(rs.getString("user_pw_hint"));
                member.setUser_introduction(rs.getString("user_introduction"));
                member.setUser_photo(rs.getString("user_photo"));
                member.setUser_con1(rs.getString("user_con1"));
                member.setUser_con2(rs.getString("user_con2"));
                member.setUser_con3(rs.getString("user_con3"));
                
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return member;
    }
    //modifyPro.jsp
    public void updateMember(LogonDataBean member, String user_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
"update users set user_pw=?,user_name=?,user_email=?,user_phone=?,user_pw_hint=?,user_photo=?,user_introduction=?,user_con1=?,user_con2=?,user_con3=?" +
" where user_id=?");

            
            
            pstmt.setString(1, member.getUser_pw());
            pstmt.setString(2, member.getUser_name());
            pstmt.setString(3, member.getUser_email());
            pstmt.setString(4, member.getUser_phone());
            pstmt.setString(5, member.getUser_pw_hint());
            pstmt.setString(6, member.getUser_photo());
            pstmt.setString(7, member.getUser_introduction());
            pstmt.setString(8, member.getUser_con1());
            pstmt.setString(9, member.getUser_con2());
            pstmt.setString(10, member.getUser_con3());
            pstmt.setString(11, member.getUser_id());
            
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
   
    public int deleteMember(String user_id, String user_pw) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select user_pw from users where user_id = ?");
            pstmt.setString(1, user_id);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            	dbpasswd= rs.getString("user_pw");
            	if(dbpasswd.equals(user_pw)){
            		pstmt = conn.prepareStatement(
                  "delete from users where user_id=?");
                    pstmt.setString(1, user_id);
                    pstmt.executeUpdate();
                    x= 1; //회원탈퇴 성공
            	}else
            		x= 0; //비밀번호 틀림
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    public String findId(String user_name ,String user_birth) {
		
    	String user_id = null;
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    	
        try {
			con = getConnection();
		
        String strQuery = "select user_id from users where user_name=? and user_birth=?";
        pstmt = con.prepareStatement(strQuery);
        pstmt.setString(1, user_name);
        pstmt.setString(2, user_birth);
        
        rs = pstmt.executeQuery();
        
        if(rs.next()) {
        	user_id = rs.getString("user_id");
        }
        
        } catch (Exception e) {
			e.printStackTrace();
        }finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (con != null) try { con.close(); } catch(SQLException ex) {}
        }
        return user_id;
    }
    
public String findPwd(String user_id ,String user_pw_hint) {
		
    	String user_pw = null;
    	String user_name = null;
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    	
        try {
			con = getConnection();
		
        String strQuery = "select user_pw, user_name from users where user_id=? and user_pw_hint=?";
        pstmt = con.prepareStatement(strQuery);
        pstmt.setString(1, user_id);
        pstmt.setString(2, user_pw_hint);
        
        rs = pstmt.executeQuery();
        
        if(rs.next()) {
        	user_pw = rs.getString("user_pw");
        	user_name = rs.getString("user_name");
        }
        
        } catch (Exception e) {
			e.printStackTrace();
        }finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (con != null) try { con.close(); } catch(SQLException ex) {}
        }
        return user_pw;
    }    

public List<Map<String,Object>> Myshowlist(String user_id) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Map<String,Object>> showlist = null;
    showlist = new ArrayList<Map<String,Object>>();
    MypageDataBean article = new MypageDataBean();
    
    try {
        conn = getConnection();


pstmt = conn.prepareStatement("select show_image, show_title from show where user_id=?");
        pstmt.setString(1, user_id);
        rs = pstmt.executeQuery();

while (rs.next()) {
        		
               Map<String,Object> pm = new HashMap<String,Object>();
               article.setShow_image(rs.getString("show_image"));
               StringTokenizer sauc_img = new StringTokenizer(rs.getString("show_image"), ",");
               String auc_img = sauc_img.nextToken();
               pm.put("show_image", auc_img);
               article.setShow_title(rs.getString("show_title"));
               pm.put("show_title", article.getShow_title());
               
               showlist.add(pm);
        }


    } catch(Exception ex) {
        ex.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
    }
    return showlist;
}

	public List<Map<String,Object>> Myfollower(String user_id) throws Exception {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> fwlist = null;
	    fwlist = new ArrayList<Map<String,Object>>();
	    LogonDataBean article = new LogonDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();
	
	
	pstmt = conn.prepareStatement("select u.user_id, u.user_photo, f.follower from users u join follow f on u.user_id=f.follower where f.following=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();
	
	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setUser_id(rs.getString("user_id"));
	               pm.put("user_id", rs.getString("user_id"));
	               article.setUser_photo(rs.getString("user_photo"));
	               pm.put("user_photo", rs.getString("user_photo"));
	               fwlist.add(pm);
	        }
	
	
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return fwlist;
	}

	public List<Map<String,Object>> Myfollowing(String user_id) throws Exception {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> fwnlist = null;
	    fwnlist = new ArrayList<Map<String,Object>>();
	    LogonDataBean article = new LogonDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();
	
	        pstmt = conn.prepareStatement("select u.user_id, u.user_photo, f.follower from users u join follow f on u.user_id=f.following where f.follower=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();
	
	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setUser_id(rs.getString("user_id"));
	               pm.put("user_id", rs.getString("user_id"));
	               article.setUser_photo(rs.getString("user_photo"));
	               pm.put("user_photo", rs.getString("user_photo"));
	               fwnlist.add(pm);
	        }
	
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return fwnlist;
	}
	
	public List<Map<String,Object>> Myfeedmain(String user_id) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> articleList = null;
	    articleList = new ArrayList<Map<String,Object>>();
	    MypageDataBean article = new MypageDataBean();
	    
	    try {
	        conn = getConnection();


	pstmt = conn.prepareStatement("select show_image, show_title, show_no from show where user_id=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();

	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setShow_image(rs.getString("show_image"));
	               StringTokenizer sauc_img = new StringTokenizer(rs.getString("show_image"), ",");
	               String auc_img = sauc_img.nextToken();
	               pm.put("show_image", auc_img);
	               article.setShow_no(rs.getInt("show_no"));
	               pm.put("show_no", rs.getString("show_no"));
	               article.setShow_title(rs.getString("show_title"));
	               pm.put("show_title", rs.getString("show_title"));
	               articleList.add(pm);
	        }


	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return articleList;
	}

	public MypageDataBean Myfeedgradeoption(String user_id) {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    MypageDataBean gradeop=null;
		
	    try {
			con = getConnection();
		
	    String strQuery = "select user_name, user_grade from users where user_id=?";
	    pstmt = con.prepareStatement(strQuery);
	    pstmt.setString(1, user_id);
	    
	    rs = pstmt.executeQuery();
	    
	    if(rs.next()) {
	    	gradeop = new MypageDataBean();
	    	gradeop.setUser_name(rs.getString("user_name"));
	    	gradeop.setUser_grade(rs.getString("user_grade"));
	    }
	    
	    } catch (Exception e) {
			e.printStackTrace();
	    }finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (con != null) try { con.close(); } catch(SQLException ex) {}
	    }
	    return gradeop;
	}    

	public List<Map<String,Object>> Myfeedcount(String user_id) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> count = null;
	    count = new ArrayList<Map<String,Object>>();
	    MypageDataBean article = new MypageDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();


	pstmt = conn.prepareStatement("select count(*) show_no from show where user_id=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();

	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setShow_no(rs.getInt("show_no"));
	               pm.put("show_no", rs.getInt("show_no"));
	               count.add(pm);
	        }


	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return count;
	}


	public List<Map<String,Object>> Myfeedcount1(String user_id) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> count1 = null;
	    count1 = new ArrayList<Map<String,Object>>();
	    MypageDataBean article = new MypageDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();


	pstmt = conn.prepareStatement("select * from follow where follower=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();

	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setFollower(rs.getString("follower"));
	               article.setFollowing(rs.getString("following"));
	               pm.put("follower", rs.getString("follower"));
	               pm.put("following", rs.getString("following"));
	               count1.add(pm);
	        }


	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return count1;
	}
	public List<Map<String,Object>> Myfollowercount(String user_id) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> fowcount = null;
	    fowcount = new ArrayList<Map<String,Object>>();
	    MyFollowDataBean article = new MyFollowDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();


	pstmt = conn.prepareStatement("select count(*) follower from follow where following=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();

	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setFollowing(rs.getInt("follower"));
	               pm.put("follower", rs.getInt("follower"));
	               fowcount.add(pm);
	        }


	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return fowcount;
	}

	public List<Map<String,Object>> Myfollowingcount(String user_id) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Map<String,Object>> fowicount = null;
	    fowicount = new ArrayList<Map<String,Object>>();
	    MyFollowDataBean article = new MyFollowDataBean();
	    
	    
	    
	    
	    try {
	        conn = getConnection();


	pstmt = conn.prepareStatement("select count(*) following from follow where follower=?");
	        pstmt.setString(1, user_id);
	        rs = pstmt.executeQuery();

	while (rs.next()) {
	        		
	               Map<String,Object> pm = new HashMap<String,Object>();
	               article.setFollower(rs.getInt("following"));
	               pm.put("following", rs.getInt("following"));
	               fowicount.add(pm);
	        }


	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	    return fowicount;
	}

	public LogonDataBean Myfeedmain2(String user_id) {
		
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    LogonDataBean member=null;
		
	    try {
			con = getConnection();
		
	    String strQuery = "select user_id, user_introduction, user_photo, user_name, user_grade  from users where user_id=?";
	    pstmt = con.prepareStatement(strQuery);
	    pstmt.setString(1, user_id);
	    
	    rs = pstmt.executeQuery();
	    
	    if(rs.next()) {
	    	member = new LogonDataBean();
	    	member.setUser_id(rs.getString("user_id"));
	    	member.setUser_introduction(rs.getString("user_introduction"));
	    	member.setUser_photo(rs.getString("user_photo"));
	    	member.setUser_name(rs.getString("user_name"));
	    	member.setUser_grade(rs.getString("user_grade"));
	    }
	    
	    } catch (Exception e) {
			e.printStackTrace();
	    }finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (con != null) try { con.close(); } catch(SQLException ex) {}
	    }
	    return member;
	}    
	
	//my_interest.jsp 관심사 불러오기
		public LogonDataBean getInterest(String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			LogonDataBean ldb = new LogonDataBean();
			
			try {
				conn = getConnection();
				
				pstmt = conn.prepareStatement("select user_con1, user_con2, user_con3 from users where user_id=?");
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					ldb.setUser_con1(rs.getString("user_con1"));
					ldb.setUser_con2(rs.getString("user_con2"));
					ldb.setUser_con3(rs.getString("user_con3"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return ldb;
		}
		
		//팔로우 등록 여부 가저오기
		public int checkfollow(String user_id, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int check = 0;
			int i = 0;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from follow where follower = ? and following = ?");
				pstmt.setString(1, sessionId);
				pstmt.setString(2, user_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					check = 1;
				} else {
					check = 0;
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return check;
		}
		
		//팔로우 등록 
		public void follow(String user_id, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("insert into follow values(?,?)");
				pstmt.setString(1, sessionId);
				pstmt.setString(2, user_id);
				pstmt.executeUpdate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
		}
		
		//팔로우 취소
				public void unfollow(String user_id, String sessionId) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("delete from follow where follower = ? and following = ?");
						pstmt.setString(1, sessionId);
						pstmt.setString(2, user_id);
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






