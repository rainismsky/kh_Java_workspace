package logon;

import java.sql.*;

import javax.sql.*;

import logon.BoardDataBean;

import javax.naming.*;
import java.util.*;

public class BoardDBBean {
	private static BoardDBBean instance = new BoardDBBean();

	public static BoardDBBean getInstance() {
		return instance;
	}

	private BoardDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// writePro.jsp
	public void insertArticle(BoardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 답변글인지 일반글인지를 구분해서 입력시켜주는 로직!!!
		int b_no = article.getB_no();

		int number = 0;
		String sql = "";

		try {
			conn = getConnection();
			// 쿼리를 작성
			sql = "insert into board values(board_seq.NEXTVAL,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, article.getB_category());
			pstmt.setString(2, article.getB_head());
			pstmt.setString(3, article.getB_title());
			pstmt.setInt(4, article.getB_view());
			pstmt.setString(5, article.getUser_id());
			pstmt.setString(6, article.getB_content());
			pstmt.setString(7, article.getB_image());
			pstmt.setTimestamp(8, article.getB_date());
			
			
			pstmt.executeUpdate();
			
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
	}


	// list.jsp : 페이징을 위해서 전체 DB에 입력된 행의수가 필요하다...!!!
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from board");
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

	// list.jsp ==> Paging!!! DB로부터 여러행을 결과로 받는다.
	public List getArticles(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date,r " + 
					"from (select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date,rownum r " + 
					"from (select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date " + 
					"from board order by b_no desc)) where r >= ? and r <=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					BoardDataBean article = new BoardDataBean();
					article.setB_no(rs.getInt("b_no"));
					article.setB_category(rs.getInt("b_category"));
					article.setB_head(rs.getString("b_head"));
					article.setB_title(rs.getString("b_title"));
					article.setB_view(rs.getInt("b_view"));
					article.setUser_id(rs.getString("user_id"));
					article.setB_content(rs.getString("b_content"));
					article.setB_image(rs.getString("b_image"));
					article.setB_date(rs.getTimestamp("b_date"));
					articleList.add(article);
				} while (rs.next());
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
		return articleList;
	}
	
public int getArticleCount(int n, String searchKeyword) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String[] column_name = {"user_id","b_title","b_content"};
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from board_test where "+column_name[n]+" like '%"+searchKeyword+"%'");
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return x;
	}

 public List getArticles(int start, int end, int n, String searchKeyword) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		
		String[] column_name = {"user_id","b_title","b_content"};
		
		try
		{
			conn = getConnection();
			
			String sql = "select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date,r "	
						+ "from (select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date,rownum r "
						+"from (select b_no,b_category,b_head,b_title,b_view,user_id,b_content,b_image,b_date "
						+"from board_test order by ref desc, re_step asc) where "+column_name[n]+" like '%"+searchKeyword+"%' order by ref desc, re_step asc ) where r >= ? and r <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2,	end);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				articleList = new ArrayList(end);
				
				do{
					BoardDataBean article = new BoardDataBean();
					
					article.setB_no(rs.getInt("b_no"));
					article.setB_category(rs.getInt("b_category"));
					article.setB_head(rs.getString("b_head"));
					article.setB_title(rs.getString("b_title"));
					article.setB_view(rs.getInt("b_view"));
					article.setUser_id(rs.getString("user_id"));
					article.setB_content(rs.getString("b_content"));
					article.setB_image(rs.getString("b_image"));
					article.setB_date(rs.getTimestamp("b_date"));
					
					
					articleList.add(article);
				}while(rs.next());
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		
		return articleList;
	}

	// read.jsp : DB로부터 한줄의 데이터를 가져온다.
	public BoardDataBean getArticle(int b_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update board set b_view=b_view+1 where b_no = ?");
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from board where b_no = ?");
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardDataBean();
				article.setB_no(rs.getInt("b_no"));
				article.setB_category(rs.getInt("b_category"));
				article.setB_head(rs.getString("b_head"));
				article.setB_title(rs.getString("b_title"));
				article.setB_view(rs.getInt("b_view"));
				article.setUser_id(rs.getString("user_id"));
				article.setB_content(rs.getString("b_content"));
				article.setB_image(rs.getString("b_image"));
				article.setB_date(rs.getTimestamp("b_date"));
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
		return article;
	}

	// updateForm.jsp : 수정폼에 한줄의 데이터를 가져올때.
	public BoardDataBean updateGetArticle(int b_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from board where b_no = ?");
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new BoardDataBean();
				article.setB_no(rs.getInt("b_no"));
				article.setB_category(rs.getInt("b_category"));
				article.setB_head(rs.getString("b_head"));
				article.setB_title(rs.getString("b_title"));
				article.setB_view(rs.getInt("b_view"));
				article.setUser_id(rs.getString("user_id"));
				article.setB_content(rs.getString("b_content"));
				article.setB_image(rs.getString("b_image"));
				article.setB_date(rs.getTimestamp("b_date"));
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
		return article;
	}

	// updatePro.jsp : 실제 데이터를 수정하는 메소드.
	public int updateArticle(BoardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int x = -1;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update board set user_id=?,b_title=?,b_content=?,b_image=? where b_no=?");

					pstmt.setString(1, article.getUser_id());
					pstmt.setString(2, article.getB_title());
					pstmt.setString(3, article.getB_content());
					pstmt.setString(4, article.getB_image());
					pstmt.setInt(5, article.getB_no());
					pstmt.executeUpdate();
					
					x = 1;
				
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally { 
				
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

	public int deleteArticle(int b_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int x = 0;
		try {
			conn = getConnection();

		pstmt = conn.prepareStatement("delete from board where b_no = ?");
				pstmt.setInt(1, b_no);
				pstmt.executeUpdate();
				x = 1; // 글삭제 성공
			
				
		
	}  catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
	
	/*public List getLcomment (int b_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List bcommentList = null;
		String b_user_id = "";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from b_comment where b_no=? order by b_c_no desc");
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bcommentList = new ArrayList<>();
				do {
					B_commentDataBean bcd = new B_commentDataBean();
					bcd.setB_c_no(rs.getInt("b_c_no"));
					bcd.setB_c_content(rs.getString("b_c_content"));
					bcd.setB_c_date(rs.getTimestamp("b_c_date"));
					bcd.setUser_id(rs.getString("user_id"));
					
					pstmt = conn.prepareStatement("select user_photo from users where user_id=?");
					pstmt.setString(1, user_id);
					rs1 = pstmt.executeQuery();
					
					if(rs1.next()) {
					sdb.setComm_user_photo(rs1.getString("user_photo"));
					}
					
					lcommentList.add(sdb);
				} while(rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return lcommentList;
	}
	
	public void insertBcomment (B_commentDataBean bcd, int b_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into b_comment values(b_comment_seq.NEXTVAL,?,?,?,?)");
			
			pstmt.setInt(1, b_no);
			pstmt.setString(2, bcd.getB_c_content());
			pstmt.setString(3, bcd.getUser_id());
			pstmt.setTimestamp(4, bcd.getB_c_date());
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}*/

}
