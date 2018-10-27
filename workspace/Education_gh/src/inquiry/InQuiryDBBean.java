package inquiry;
		
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InQuiryDBBean {

	   private static InQuiryDBBean instance = new InQuiryDBBean();

	   public static InQuiryDBBean getInstance(){
	      return instance;
	   }

	   private InQuiryDBBean() {
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
		   
		      ArrayList<InQuiryDataBean> articleList = null;
		   
		      try {
		         conn = getConnection();	         
		    
		            pstmt = conn.prepareStatement("select count(*) from InQuiry");
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
	           
	            pstmt = conn.prepareStatement("select i_num,i_subject,i_content, r "
	            		+ "from (select i_num,i_subject,i_content, rownum r "
	            		+ "from (select * from Inquiry order by i_num desc)) where r>=? and r<=?");
	            
	            pstmt.setInt(1, start);
	            pstmt.setInt(2, end);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	
	            	System.out.println("asdfasdf");
	                
	            	articleList = new ArrayList(end);
	                do{
	                  InQuiryDataBean article= new InQuiryDataBean();
	                  article.setI_num(rs.getInt("i_num"));
	                  article.setI_subject(rs.getString("i_subject"));
	                  article.setI_content(rs.getString("i_content"));
	                  
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
	    //��񿡼� �ҷ��� ���� �־��ٶ� ������ �ϴ� ������ �����ϱ� ���� �ڵ�(insert into values!)
	    public void insertArticle(InQuiryDataBean article) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;

	       	String sql = "";

	        try {
	            conn = getConnection();

	    // ������ �ۼ�
	            sql = "insert into inquiry values(seq_i_num.nextval,?,?)";

	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, article.getI_num());
	            pstmt.setString(2, article.getI_subject());
	            pstmt.setString(3, article.getI_content());
	            
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
	    public InQuiryDataBean updateGetArticle(int i_num) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        InQuiryDataBean article=null;
	        try {
	            conn = getConnection();

	            pstmt = conn.prepareStatement(
	            "select * from InQuiry where i_num=?");
	            pstmt.setInt(1, i_num);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                article = new InQuiryDataBean();
	                article.setI_num(rs.getInt("i_num"));	              
	                article.setI_subject(rs.getString("i_subject"));
	                article.setI_content(rs.getString("i_content"));
	                
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
	    public int updateArticle(InQuiryDataBean article) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;

	        String dbpasswd="";
	        String sql="";
	int x=-1;
	        try {
	            conn = getConnection();
	           
	    pstmt = conn.prepareStatement(
	            "select i_content from InQuiry where i_num=?");
	            pstmt.setInt(1, article.getI_num());
	            rs = pstmt.executeQuery();
	           
	    if(rs.next()){
	dbpasswd= rs.getString("i_content");
	if(dbpasswd.equals(article.getI_content())){
	      sql="update inquiry set i_num=?,i_subject=?,i_content=? where i_num=?";
	
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setInt(1, article.getI_num());
	                pstmt.setString(2, article.getI_subject());
	                pstmt.setString(3, article.getI_content());
	                
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
	    public int deleteArticle(int i_num,String i_subject,String i_content) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;
	        String dbpasswd="";
	        int x=-1;
	        try {
	    conn = getConnection();

	            pstmt = conn.prepareStatement(
	            "select i_content from InQuiry where i_num=?");
	            pstmt.setString(1, i_subject);
	            rs = pstmt.executeQuery();
	           
	            if(rs.next()){
	dbpasswd= rs.getString("passwd");
	if(dbpasswd.equals(dbpasswd)){
	            pstmt = conn.prepareStatement(
	                  "delete from InQuiry where i_num=?");
	                    pstmt.setInt(1, i_num);
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