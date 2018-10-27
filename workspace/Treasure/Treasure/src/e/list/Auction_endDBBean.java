package e.list;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;
import java.util.*;


public class Auction_endDBBean {
	private static Auction_endDBBean instance = new Auction_endDBBean();

	public static Auction_endDBBean getInstance() {
		return instance;
	}

	private Auction_endDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public List getArticles(int start, int end, String l_category_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List articleList = new ArrayList();

		try {
			conn = getConnection();
			System.out.println("before pstmt");
			System.out.println(l_category_name);
			pstmt = conn.prepareStatement("select r, auc_end_no, user_id, auc_title, auc_image, l_category_name, win_price from "
							+ "(select rownum r, auc_end_no, user_id, auc_title, auc_image, l_category_name, win_price from "
							+ "(select auc_end_no, user_id, auc_title, auc_image, l_category_name, win_price from auction_end where l_category_name=? "
							+ "order by auc_end_no desc)) where r >= ? and r <=?");

			pstmt.setString(1, l_category_name);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			String firstImg = "";

			while(rs.next()){
					Auction_endDataBean article = new Auction_endDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("auc_image"), ",");
					firstImg = allImage.nextToken();
					article.setAuc_image(firstImg);
					article.setAuc_title(rs.getString("auc_title"));
					article.setUser_id(rs.getString("user_id"));
					article.setAuc_end_no(rs.getInt("auc_end_no"));
					article.setL_category_name(rs.getString("l_category_name"));
					article.setWin_price(rs.getInt("win_price"));

					articleList.add(article);

			}
			
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

			pstmt = conn.prepareStatement("select count(*) from auction_end where l_category_name=?");

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