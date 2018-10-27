package e.list;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;
import java.util.*;


public class AuctionDBBean {
	private static AuctionDBBean instance = new AuctionDBBean();

	public static AuctionDBBean getInstance() {
		return instance;
	}

	private AuctionDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public List getArticles(int start, int end, String l_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int show_no = 0;

		List articleList = new ArrayList();

		try {
			conn = getConnection();
			System.out.println("start" + start);
			System.out.println("end" + end);
			System.out.println("before pstmt");

			pstmt = conn.prepareStatement(
					"select r, show_no, auc_ing_no, user_id, auc_image, auc_start, auc_end, auc_sp, l_category_name from "
							+ "(select rownum r, show_no, user_id, auc_ing_no, auc_image, auc_start, auc_sp, auc_end, l_category_name from "
							+ "(select show_no, user_id, auc_ing_no, auc_image, auc_start, auc_end, auc_sp, l_category_name from auction_ing where l_category_name=? "
							+ "order by auc_end desc)) where r >= ? and r <=?");

			pstmt.setString(1, l_category_name);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			String firstImg = "";
			System.out.println("beforedo");

			 if(rs.next()) {
				 articleList = new ArrayList(end);
				 
				do {
					System.out.println("dodo");
					AuctionDataBean article = new AuctionDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("auc_image"), ",");
					firstImg = allImage.nextToken();
					article.setAuc_image(firstImg);
					article.setAuc_ing_no(rs.getInt("auc_ing_no"));
					article.setAuc_sp(rs.getInt("auc_sp"));
					article.setL_category_name(rs.getString("l_category_name"));
					article.setAuc_start(rs.getTimestamp("auc_start"));
					article.setAuc_end(rs.getTimestamp("auc_end"));
					article.setUser_id(rs.getString("user_id"));
					article.setShow_no(rs.getInt("show_no"));

					show_no = rs.getInt("show_no");
					pstmt = conn.prepareStatement("select show_title from show where show_no=?");
					pstmt.setInt(1, show_no);
					/*pstmt.setInt(2, end);*/
					rs2 = pstmt.executeQuery();
					if (rs2.next()) {
					article.setShow_title(rs2.getString("show_title"));
					
					
					}
					articleList.add(article);
					
				} while (rs.next());
			}
/*		} catch (Exception ex) {
			ex.printStackTrace();*/
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


	public int getArticleCount(String l_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from auction_ing where l_category_name=?");

			pstmt.setString(1, l_category_name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
				System.out.println("rs" + rs.getInt(1));
				System.out.println("x" + x);
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
}