package p.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void insertArticle(NoticeDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 0;
		int n_no = article.getN_no();

		String sql = "";

		try {
			conn = getConnection();
			sql += "select max(n_no) from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			sql = "insert into notice(n_no, n_title, n_view, n_date, n_content)"
					+ " values(NOTICE_SEQ.nextVal, ?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getN_title());
			pstmt.setInt(2, article.getN_view());
			pstmt.setTimestamp(3, article.getN_date());
			pstmt.setString(4, article.getN_content());
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

	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from notice");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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

	public List getArticles(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		String sql = "select n_no, n_title, n_date, n_content, n_view, r from (select n_no, n_title, n_date, n_content, n_view, rownum r from "
				+ "	(select n_no, n_title, n_date, n_content, n_view from notice order by n_no desc)) where r>=? and r<=?";
				//+ "select * from (select * from(select * from notice order by n_no desc)) where rownum>=? and rownum<=?";
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					NoticeDataBean article = new NoticeDataBean();

					article.setN_no(rs.getInt("n_no"));
					article.setN_title(rs.getString("n_title"));
					article.setN_view(rs.getInt("n_view"));
					article.setN_date(rs.getTimestamp("n_date"));
					article.setN_content(rs.getString("n_content"));

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

	// read
	public NoticeDataBean getArticle(int n_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update notice set n_view=n_view+1 where n_no = ?");
			pstmt.setInt(1, n_no);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from notice where n_no = ?");
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new NoticeDataBean();
				article.setN_no(rs.getInt("n_no"));
				article.setN_title(rs.getString("n_title"));
				article.setN_view(rs.getInt("n_view"));
				article.setN_date(rs.getTimestamp("n_date"));
				article.setN_content(rs.getString("n_content"));

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

	public NoticeDataBean updateGetArticle(int n_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from notice where n_no = ?");
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new NoticeDataBean();
				article.setN_no(rs.getInt("n_no"));
				article.setN_title(rs.getString("n_title"));
				article.setN_view(rs.getInt("n_view"));
				article.setN_date(rs.getTimestamp("n_date"));
				article.setN_content(rs.getString("n_content"));

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

	public int updateArticle(NoticeDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("1");
		String dbpasswd = "";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from notice where n_no = ?");
			pstmt.setInt(1, article.getN_no());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "update notice set n_title=?, n_content=? where n_no=?";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, article.getN_title());
				pstmt.setString(2, article.getN_content());
				pstmt.setInt(3, article.getN_no());

				x = pstmt.executeUpdate();
				// x = 1;

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

	// »èÁ¦pro
	public int deleteArticle(int n_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("1111111111");
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();
			sql += "select * from notice where n_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();
			
			System.out.println("n_no : " + n_no);
			
			if (rs.next()) {
				
				pstmt = conn.prepareStatement("delete from notice where n_no=?");
				pstmt.setInt(1, n_no);
				pstmt.executeUpdate();
				x = 1;
				System.out.println("x : " + x);

			} else
				x = 0;
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
