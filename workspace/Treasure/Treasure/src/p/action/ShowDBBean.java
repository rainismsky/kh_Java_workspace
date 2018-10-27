package p.action;

import java.sql.*;
import java.util.*;

import e.list.AuctionDataBean;
import j.show.ShowDataBean;

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

	public int insertArticle(ShowDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int show_no = 0;

		conn = getConnection();
		String sql = "";
		sql = "insert into show(show_no, show_title, show_content, l_category_name, "
				+ "s_category_name, show_sale, show_image, show_date, show_auction_ok, show_report, user_id) "
				+ "values(show_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, article.getShow_title());
		pstmt.setString(2, article.getShow_content());
		pstmt.setString(3, article.getL_category_name());
		pstmt.setString(4, article.getS_category_name());
		pstmt.setString(5, article.getShow_sale());
		pstmt.setString(6, article.getShow_image());
		pstmt.setTimestamp(7, article.getShow_date());
		pstmt.setString(8, "X");
		pstmt.setInt(9, article.getShow_report());
		pstmt.setString(10, article.getUser_id());

		pstmt.executeUpdate();

		pstmt = conn.prepareStatement("select show_no from show order by show_no desc");
		rs = pstmt.executeQuery();
		if (rs.next()) {
			show_no = rs.getInt("show_no");
		}
		System.out.println("show_no" + show_no);
		return show_no;
	}

	// 해시태그
	public void insertH_tag(HashDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = getConnection();
		String sql = "";
		sql = "insert into hashtag(h_tag) values(?)";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, article.getH_tag());

		pstmt.executeUpdate();

	}

	// Main에 올라갈 작품이 있는지 없는지
	public int getMainArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from show");
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

	// 크리에이티브 메인
	public List getCreativeMainArticles(int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			String sql = "select * from (SELECT s.l_category_name, i.show_no, count(*) countedLike, show_image, s.show_title, s.user_id FROM ilike i , show s  "
					+ "where i.show_no= s.show_no and l_category_name=? "
					+ "group by s.l_category_name, i.show_no, show_image,show_title, s.user_id order by count(*) desc) where rownum<=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Creative Arts");
			pstmt.setInt(2, end);
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
					article.setShow_no(rs.getInt("show_no"));
					article.setUser_id(rs.getString("user_id"));
					article.setCountedLike(rs.getInt("countedLike"));
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

	// Retro Collection 메인
	public List getRetroMainArticles(int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			String sql = "select * from (SELECT s.l_category_name, i.show_no, count(*) countedLike, show_image, s.show_title, s.user_id FROM ilike i , show s  "
					+ "where i.show_no= s.show_no and l_category_name=? "
					+ "group by s.l_category_name, i.show_no, show_image,show_title, s.user_id order by count(*) desc) where rownum<=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Retro Collections");
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			String firstImg = "";

			if (rs.next()) {
				System.out.println("aaaaaaaaaaaaaaaa");
				articleList = new ArrayList(end);
				do {
					ShowDataBean article = new ShowDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
					firstImg = allImage.nextToken();
					article.setShow_image(firstImg);
					article.setShow_title(rs.getString("show_title"));
					article.setShow_no(rs.getInt("show_no"));
					article.setUser_id(rs.getString("user_id"));
					article.setCountedLike(rs.getInt("countedLike"));
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

	// Auction 메인
	public List getAuctionMainArticles(int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
			String sql = "select * from (SELECT i.show_no, a.auc_ing_no, a.auc_image, count(*) countedLike, s.show_title,a.auc_end, a.auc_sp, s.user_id FROM ilike i , AUCTION_ING a, show s \n" + 
		               "where i.show_no=a.show_no and s.show_no=i.show_no group by i.show_no, a.auc_ing_no, a.auc_image, s.show_title, a.auc_end, \n" + 
		               "a.auc_sp, s.user_id order by COUNT(*) desc) where rownum <=3";

			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			String firstImg = "";

			if (rs.next()) {
				
				articleList = new ArrayList(end);
				do {
					AuctionDataBean article = new AuctionDataBean();
					StringTokenizer allImage = new StringTokenizer(rs.getString("auc_image"),",");
					firstImg = allImage.nextToken();
					article.setAuc_image(firstImg);
		            article.setAuc_sp(rs.getInt("auc_sp"));
		            article.setAuc_end(rs.getTimestamp("auc_end"));
		            article.setAuc_ing_no(rs.getInt("auc_ing_no"));
					article.setUser_id(rs.getString("user_id"));
		            article.setCountedLike(rs.getInt("countedLike"));
		            article.setShow_title(rs.getString("show_title"));
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

	// 신고 조회 페이지
	public int getReportedArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from show where show_report^=0");
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

	public List getReportedArticles(int start, int end) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		String sql = "select * from show where show_report^=0 order by show_report desc";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, start);
			// pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					ShowDataBean article = new ShowDataBean();
					article.setShow_no(rs.getInt("show_no"));
					article.setL_category_name(rs.getString("l_category_name"));
					article.setShow_title(rs.getString("show_title"));
					article.setUser_id(rs.getString("user_id"));
					article.setShow_report(rs.getInt("show_report"));

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
}