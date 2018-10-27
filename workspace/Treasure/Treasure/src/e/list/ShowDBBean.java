package e.list;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class ShowDBBean {
	private static ShowDBBean instance = new ShowDBBean();

	public static ShowDBBean getInstance() {
		return instance;
	}

	private ShowDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public List getArticles(int start, int end, String s_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List articleList = null;
		int total_like=0;
		int show_no = 0;
		String sql = "";
		try {
			conn = getConnection();
			System.out.println("start" + start);
			System.out.println("end" + end);
			
				pstmt = conn.prepareStatement("select r, show_no, user_id, show_title,show_image,l_category_name, s_category_name from "
						+ "(select rownum r, show_no, user_id, show_title,show_image,l_category_name, s_category_name from "
						+ "(select user_id, show_no, show_title,show_image,l_category_name, s_category_name from show where s_category_name=? "
						+ "order by show_date desc)) where r >= ? and r <=?");
				
				pstmt.setString(1, s_category_name);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				String firstImg = "";

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					ShowDataBean article = new ShowDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
					firstImg = allImage.nextToken();
					article.setShow_image(firstImg);
					article.setShow_title(rs.getString("show_title"));
					article.setUser_id(rs.getString("user_id"));
					article.setShow_no(rs.getInt("show_no"));
					article.setL_category_name(rs.getString("l_category_name"));
					article.setS_category_name(rs.getString("s_category_name"));
					
					show_no = rs.getInt("show_no");
					
					pstmt = conn.prepareStatement("select count(*) from ilike where show_no=?");
					pstmt.setInt(1, show_no);
					rs2 = pstmt.executeQuery();
					if(rs2.next()) {
						article.setTotal_like(rs2.getInt(1));
					}
					
					System.out.println(article.getTotal_like());
					
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

	public int getArticleCount(String s_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from show where s_category_name=?");
			pstmt.setString(1, s_category_name);
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
	
	public List getSearchList(int start, int end, String search, String l_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		List articleList = null;
		articleList = new ArrayList();
		String sql = "";
		String firstImg = "";
				try {
			conn = getConnection();
			
				pstmt = conn.prepareStatement("select r, a.s_category_name, a.show_no, a.l_category_name, a.show_title, a.user_id, a.show_image "
						+ "from (select rownum r, s.show_no, s.s_category_name, s.l_category_name, s.show_title, s.user_id, s.show_image "
						+ "from show s, (select show_no from (select h_tag, show_no from hashtag where h_tag like ? order by show_no) "
						+ "group by show_no order by show_no) h where s.show_no = h.show_no and s.l_category_name = ? order by r) a "
						+ "where r >= ? and r <= ?");
				
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, l_category_name);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				rs = pstmt.executeQuery();
				

			while (rs.next()) {
				
				pstmt = conn.prepareStatement("select count(*) from ilike where show_no = ?");
				pstmt.setInt(1, rs.getInt("show_no"));
				rs2 = pstmt.executeQuery();
					ShowDataBean article = new ShowDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
					firstImg = allImage.nextToken();
					article.setShow_image(firstImg);
					article.setShow_title(rs.getString("show_title"));
					article.setUser_id(rs.getString("user_id"));
					article.setShow_no(rs.getInt("show_no"));
					if(rs2.next()) {
					article.setTotal_like(rs2.getInt(1));
					}else {
						article.setTotal_like(0);
					}
					article.setL_category_name(rs.getString("l_category_name"));
					article.setS_category_name(rs.getString("s_category_name"));

					articleList.add(article);
					
				
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
}