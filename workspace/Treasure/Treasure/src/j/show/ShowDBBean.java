package j.show;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
	
	//show_detail.jsp 정보 가저오기
	public ShowDataBean getShowInfo(int show_no, String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet s_rs = null;	//show
		ResultSet u_rs = null;	//user
		

		
		ShowDataBean sdb = new ShowDataBean();
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from show where show_no = ?");
			pstmt.setInt(1, show_no);
			s_rs = pstmt.executeQuery();
			
			pstmt = conn.prepareStatement("select * from users where user_id = ?");
			pstmt.setString(1, user_id);
			u_rs = pstmt.executeQuery();
			if(s_rs.next() && u_rs.next()) {
				sdb.setShow_no(s_rs.getInt("show_no"));
				sdb.setL_category_name(s_rs.getString("l_category_name"));
				sdb.setS_category_name(s_rs.getString("s_category_name"));
				sdb.setShow_title(s_rs.getString("show_title"));
				sdb.setUser_id(s_rs.getString("user_id"));
				sdb.setShow_sale(s_rs.getString("show_sale"));
				sdb.setShow_image(s_rs.getString("show_image"));
				sdb.setShow_content(s_rs.getString("show_content"));
				sdb.setShow_date(s_rs.getTimestamp("show_date"));
				sdb.setShow_report(s_rs.getInt("show_report"));
				sdb.setShow_auction_ok(s_rs.getString("show_auction_ok"));
				sdb.setUser_photo(u_rs.getString("user_photo"));
				sdb.setUser_introduction(u_rs.getString("user_introduction"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(s_rs != null) try { s_rs.close(); } catch(SQLException ex) {}
			if(u_rs != null) try { u_rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return sdb;
	}
	
	//show_detail.jsp 해시태그 가저오기
	public List getHashtag (int show_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List hashtagList = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from hashtag where show_no = ?");
			pstmt.setInt(1, show_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				hashtagList = new ArrayList<>();
				do {
					ShowDataBean sdb = new ShowDataBean();
					sdb.setH_tag(rs.getString("h_tag"));
					
					hashtagList.add(sdb);
				} while(rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return hashtagList;
	}
	
	//show_detail.jsp 한줄평 가저오기
	public List getLcomment (int show_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List lcommentList = null;
		String comm_user_id = "";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from line_comment where show_no=? order by l_comm_no desc");
			pstmt.setInt(1, show_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lcommentList = new ArrayList<>();
				do {
					ShowDataBean sdb = new ShowDataBean();
					sdb.setL_comm_no(rs.getInt("l_comm_no"));
					sdb.setL_comm_content(rs.getString("l_comm_content"));
					sdb.setL_comm_date(rs.getTimestamp("l_comm_date"));
					sdb.setComm_user_id(rs.getString("user_id"));
					
					comm_user_id = rs.getString("user_id");
					
					pstmt = conn.prepareStatement("select user_photo from users where user_id=?");
					pstmt.setString(1, comm_user_id);
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
	
	//show_detail.jsp 좋아요 등록 여부 가저오기
	public int checkIlike(int show_no, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		int i = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ilike where show_no = ? and user_id = ?");
			pstmt.setInt(1, show_no);
			pstmt.setString(2, sessionId);
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
	
	//show_detail.jsp 좋아요 등록하기
	public void ilikeShow(int show_no, String sessionId, String artist) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into ilike values(?,?)");
			pstmt.setInt(1, show_no);
			pstmt.setString(2, sessionId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update users set total_like=total_like+1 where user_id=?");
			pstmt.setString(1, artist);
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException ex) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
	//show_detail.jsp 좋아요 취소하기
		public void deleteilikeShow(int show_no, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from ilike where show_no = ? and user_id = ?");
				pstmt.setInt(1, show_no);
				pstmt.setString(2, sessionId);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
		}
	
	//show_detail.jsp 담아두기 등록 여부 가저오기
		public int checkBookmark(int show_no, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int check = 0;
			int i = 0;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from bookmark where show_no = ? and user_id = ?");
				pstmt.setInt(1, show_no);
				pstmt.setString(2, sessionId);
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
		
		//show_detail.jsp 담아두기 등록하기
		public void bookmarkShow(int show_no, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("insert into bookmark values(?,?)");
				pstmt.setInt(1, show_no);
				pstmt.setString(2, sessionId);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
		}
		
		//show_detail.jsp 담아두기 취소하기
		public void deletebookmarkShow(int show_no, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from bookmark where show_no = ? and user_id = ?");
				pstmt.setInt(1, show_no);
				pstmt.setString(2, sessionId);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
		}
			
		//show_detail.jsp 작품 좋아요 수 가져오기
		public int countLike(int show_no) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x = 0;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from ilike where show_no=?");
				pstmt.setInt(1, show_no);
				rs = pstmt.executeQuery();
				
				if( rs.next()) {
					x = rs.getInt(1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//show_detail.jsp 신고 등록하기
		public int reportShow(int show_no, String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x = 0;
			
			try {
				conn = getConnection();
				
				pstmt = conn.prepareStatement("select * from report_user where show_no=? and user_id=?");
				pstmt.setInt(1, show_no);
				pstmt.setString(2, sessionId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					x = 0;
				} else {
					pstmt = conn.prepareStatement("update show set show_report=show_report+1 where show_no=?");
					pstmt.setInt(1, show_no);
					pstmt.executeUpdate();
					
					pstmt = conn.prepareStatement("insert into report_user values(?,?)");
					pstmt.setInt(1, show_no);
					pstmt.setString(2, sessionId);
					pstmt.executeUpdate();
					
					x = 1;
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//my_interest.jsp 관심 전시 가져오기
		public List getInterestShow (String con) {
			System.out.println("getInterestShow");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			List interestList = null;
			
			try {
				
				conn = getConnection();
				
				pstmt = conn.prepareStatement("select * from (SELECT s_category_name, show_no, show_image, user_id, show_title FROM show  "
						+ "where s_category_name=? "
						+ "order by dbms_random.value) where rownum<=?");
				pstmt.setString(1, con);
				pstmt.setInt(2, 3);
				rs = pstmt.executeQuery();
				String firstImg = "";
				
				if (rs.next()) {
					interestList = new ArrayList(3);
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						
						int show_no = rs.getInt("show_no");
						pstmt = conn.prepareStatement("select count(*) countedlike from ilike where show_no=?");
						pstmt.setInt(1, show_no);
						rs2 = pstmt.executeQuery();
						if(rs2.next()) {
							sdb.setCountedLike(rs2.getInt("countedlike"));
						}
						
						interestList.add(sdb);
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
			
			return interestList;
		}
		
		//my_following.jsp 나의 팔로잉 작품 가져오기
		public List getFollowingShow (String sessionId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List followingList = null;
			
			try {
				conn = getConnection();
				String sql = "select * from (select following, show_no, show_image, user_id, show_title "
						+ "from follow, show where following = user_id and follower = ? "
						+ "order by dbms_random.value) where rownum <= 9";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				String firstImg = "";

				if(rs.next()) {
					followingList = new ArrayList(9);
					
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						followingList.add(sdb);
					} while (rs.next());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return followingList;
		}
		
		//my_likebookmark.jsp 좋아요 가져오기
		public List getLikeShow(String sessionId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			List likeList = null;
			
			try {
				conn = getConnection();
				String sql = "select * from (select s.show_no, s.show_image, s.user_id, s.show_title "
						+ "from ilike i, show s where i.show_no = s.show_no and i.user_id = ? order by s.show_no desc) where rownum <= 3";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				String firstImg = "";
				
				if(rs.next()) {
					likeList = new ArrayList(3);
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						
						int show_no = rs.getInt("show_no");
						pstmt = conn.prepareStatement("select count(*) countedlike from ilike where show_no=?");
						pstmt.setInt(1, show_no);
						rs2 = pstmt.executeQuery();
						if(rs2.next()) {
							sdb.setCountedLike(rs2.getInt("countedlike"));
						}
						
						likeList.add(sdb);
					} while (rs.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(rs2 != null) try { rs2.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return likeList;
		}
		
		//my_likebookmark.jsp 북마크 가져오기
		public List getBookmarkShow(String sessionId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			List bookmarkList = null;
			
			try {
				conn = getConnection();
				String sql = "select * from (select s.show_no, s.show_image, s.user_id, s.show_title "
						+ "from bookmark b, show s where b.show_no = s.show_no and b.user_id = ? order by s.show_no desc) where rownum <= 3";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				String firstImg = "";
				
				if(rs.next()) {
					bookmarkList = new ArrayList(3);
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						
						int show_no = rs.getInt("show_no");
						pstmt = conn.prepareStatement("select count(*) countedlike from ilike where show_no=?");
						pstmt.setInt(1, show_no);
						rs2 = pstmt.executeQuery();
						if(rs2.next()) {
							sdb.setCountedLike(rs2.getInt("countedlike"));
						}
						
						bookmarkList.add(sdb);
					} while (rs.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(rs2 != null) try { rs2.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return bookmarkList;
		}
		
		//my_like.jsp 좋아요 가져오기 all
		public List getAllLikeShow(String sessionId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			List likeList = null;
			
			try {
				conn = getConnection();
				String sql = "select s.show_no, s.show_image, s.user_id, s.show_title "
						+ "from ilike i, show s where i.show_no = s.show_no and i.user_id = ? order by s.show_no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				String firstImg = "";
				
				if(rs.next()) {
					likeList = new ArrayList(3);
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						
						int show_no = rs.getInt("show_no");
						pstmt = conn.prepareStatement("select count(*) countedlike from ilike where show_no=?");
						pstmt.setInt(1, show_no);
						rs2 = pstmt.executeQuery();
						if(rs2.next()) {
							sdb.setCountedLike(rs2.getInt("countedlike"));
						}
						
						likeList.add(sdb);
					} while (rs.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(rs2 != null) try { rs2.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return likeList;
		}
		
		//my_bookmark.jsp 북마크 가져오기 all
		public List getAllBookmarkShow(String sessionId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			List bookmarkList = null;
			
			try {
				conn = getConnection();
				String sql = "select s.show_no, s.show_image, s.user_id, s.show_title "
						+ "from bookmark b, show s where b.show_no = s.show_no and b.user_id = ? order by s.show_no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				String firstImg = "";
				
				if(rs.next()) {
					bookmarkList = new ArrayList(3);
					do {
						ShowDataBean sdb = new ShowDataBean();
						StringTokenizer allImage = new StringTokenizer(rs.getString("show_image"), ",");
						firstImg = allImage.nextToken();
						sdb.setShow_image(firstImg);
						sdb.setShow_no(rs.getInt("show_no"));
						sdb.setUser_id(rs.getString("user_id"));
						sdb.setShow_title(rs.getString("show_title"));
						
						int show_no = rs.getInt("show_no");
						pstmt = conn.prepareStatement("select count(*) countedlike from ilike where show_no=?");
						pstmt.setInt(1, show_no);
						rs2 = pstmt.executeQuery();
						if(rs2.next()) {
							sdb.setCountedLike(rs2.getInt("countedlike"));
						}
						
						bookmarkList.add(sdb);
					} while (rs.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(SQLException ex) {}
				if(rs2 != null) try { rs2.close(); } catch(SQLException ex) {}
				if(pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if(conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return bookmarkList;
		}
		
		
		
}
