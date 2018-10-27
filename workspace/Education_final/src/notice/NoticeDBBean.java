package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDBBean {

	   private static NoticeDBBean instance = new NoticeDBBean();

	   public static NoticeDBBean getInstance() {
	      return instance;
	   }

	   private NoticeDBBean() {
	   }

	   private Connection getConnection() throws Exception {
	      String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
	      return DriverManager.getConnection(jdbcDriver);
	   }
	   
	 //Notice.jsp : ����¡�� ���ؼ� ��ü DB�� �Էµ� ���Ǽ��� �ʿ��ϴ�.! // ��ü �� ���� ��������
	   public int getArticle_count() throws Exception {
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      int x = 0;
		   
		      ArrayList<NoticeDataBean> articleList = null;
		   
		      try {
		         conn = getConnection();	         
		    
		            pstmt = conn.prepareStatement("select count(*) from notice");
		            rs = pstmt.executeQuery();
		            
		         if (rs.next()) {
		            x = rs.getInt(1);

		         }
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      } finally {
		         if (rs != null)
		            try {
		               rs.close();
		            } catch (SQLException ex) {
		            }
		         if (pstmt != null)
		            try {
		               pstmt.close();
		            } catch (SQLException ex) {
		            }
		         if (conn != null)
		            try {
		               conn.close();
		            } catch (SQLException ex) {
		            }
		      }
		      return x;
		   }
	   
	   
	   // start���� end���� �ش��ϴ� �� ����Ʈ�� ��������
	    public ArrayList getArticlelist(int start, int end) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        ArrayList articleList=null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement("select n_num,n_subject,n_content,n_reg_date,n_readcount, r "
	            		+ "from (select n_num,n_subject,n_content,n_reg_date,n_readcount, rownum r "
	            		+ "from (select * from notice order by n_num desc)) where r>=? and r<=?");
	            pstmt.setInt(1, start);
	            pstmt.setInt(2, end);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	
	            	System.out.println("���������� ��� �϶�!");
	                
	            	articleList = new ArrayList(end);
	                do{
	                  NoticeDataBean article= new NoticeDataBean();
	                  article.setN_num(rs.getInt("n_num"));
	                  article.setN_subject(rs.getString("n_subject"));
	                  article.setN_content(rs.getString("n_content"));
	                  article.setN_readcount(rs.getInt("n_readcount"));
	                  article.setN_reg_date(rs.getTimestamp("n_reg_date"));
	                  
	                  articleList.add(article);
	                  
	                }while(rs.next());
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

	    //writePro.jsp
	    public void insertArticle(NoticeDataBean article) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;

	       	String sql = "";

	        try {
	            conn = getConnection();

	    // ������ �ۼ�
	            sql = "insert into Notice values(seq_n_num.nextval,?,?,?,?)";

	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, article.getN_subject());
	            pstmt.setString(2, article.getN_content());
	            pstmt.setInt(3, article.getN_readcount());
	            pstmt.setTimestamp(4, article.getN_reg_date());
	            pstmt.executeUpdate();
	            conn.commit();
	            
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	    }
	   
	    
	    //updateForm.jsp : �������� ������ �����͸� �����ö�.
	    public NoticeDataBean UpdateGetArticle(int n_num) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        NoticeDataBean article=null;
	        try {
	            conn = getConnection();

	            pstmt = conn.prepareStatement(
	            "select * from notice where n_num = ?");
	            pstmt.setInt(1, n_num);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                article = new NoticeDataBean();
	                
	                article.setN_num(rs.getInt("n_num"));	              
	                article.setN_subject(rs.getString("n_subject"));
	                article.setN_content(rs.getString("n_content"));
 	                article.setN_readcount(rs.getInt("n_readcount"));
	                article.setN_reg_date(rs.getTimestamp("n_reg_Date"));
	
	}
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	return article;
	    }

	    //updatePro.jsp : ���� �����͸� �����ϴ� �޼ҵ�.
	    public int updateArticle(NoticeDataBean article) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;

	        String dbpasswd="";
	        String sql="";
	int x=-1;
	        try {
	            conn = getConnection();
	           
	    pstmt = conn.prepareStatement(
	            "select n_content from Notice where n_num=?");
	            pstmt.setInt(1, article.getN_num());
	            rs = pstmt.executeQuery();
	           
	    if(rs.next()){
	dbpasswd= rs.getString("n_content");
	if(dbpasswd.equals(article.getN_content())){
	      
		sql="update Notice set n_num=?,n_subject=?,n_content=?,n_readcount=?,n_reg_date=? where n_num=?";
	      
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setInt(1, article.getN_num());
	                pstmt.setString(2, article.getN_subject());
	                pstmt.setString(3, article.getN_content());
	                pstmt.setInt(4, article.getN_readcount());
	                pstmt.setTimestamp(5, article.getN_reg_date());
	                
	                pstmt.executeUpdate();
	                
	                x= 1;
		}else{
					x= 0;
			}
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
	   
	    //deletePro.jsp : ���� �����͸� �����ϴ� �޼ҵ�...
	    public int deleteArticle(int n_num, String n_content) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;
	        String dbpasswd="";
	        int x=-1;
	        try {
	    conn = getConnection();

	            pstmt = conn.prepareStatement(
	            "select n_content from Notice where n_num=?");
	            pstmt.setInt(1, n_num);
	            rs = pstmt.executeQuery();
	           
	            if(rs.next()){
	dbpasswd= rs.getString("passwd");
	if(dbpasswd.equals(dbpasswd)){
	            pstmt = conn.prepareStatement(
	                  "delete from Notice where n_num=?");
	                    pstmt.setInt(1, n_num);
	                    pstmt.executeUpdate();
	    x= 1; //�ۻ��� ����
	}else
	    x= 0; //��й�ȣ Ʋ��
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
}	       