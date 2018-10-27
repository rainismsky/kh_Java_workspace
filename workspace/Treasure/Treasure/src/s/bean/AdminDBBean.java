package s.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import j.show.ShowDataBean;
import logon.LogonDataBean;

public class AdminDBBean {
	private static AdminDBBean instance = new AdminDBBean();

	public static AdminDBBean getInstance() {
		return instance;
	}

	private AdminDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	//좋아요 리스트 카운트
		public int CountLikeRank() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ArrayList likeRankList = new ArrayList();
			int i = 0;
			

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(count(*)) from ilike group by show_no having count(*) >= 20");
				rs = pstmt.executeQuery();
				
				if (rs.next()){
					i = rs.getInt(1);
					}
			
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException ex) {
					}
				if (rs2 != null)
					try {
						rs2.close();
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
			return i;
		}
	
	//좋아요 리스트 가져오기
	public ArrayList getLikeRank(int startRow, int endRow) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList likeRankList = new ArrayList();
		int show_no = 0;
		

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, c, show_no from (select rownum r, c, show_no from(select count(*) c, show_no from ilike group by show_no having count(*) >=20 order by count(*))) where r >= ? and r <=?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				ShowDataBean sdb = new ShowDataBean();
				pstmt = conn.prepareStatement("select * from show where show_no = ?");
				pstmt.setInt(1, rs.getInt("show_no"));
				rs2 = pstmt.executeQuery();
				if(rs2.next()) {
					sdb.setShow_no(rs2.getInt("show_no"));
					sdb.setS_category_name(rs2.getString("s_category_name"));
					sdb.setShow_title(rs2.getString("show_title"));
					sdb.setUser_id(rs2.getString("user_id"));
					sdb.setShow_like(rs.getInt("c"));
					sdb.setShow_sale(rs2.getString("show_sale"));
					sdb.setShow_auction_ok(rs2.getString("show_auction_ok"));
					likeRankList.add(sdb);
				}
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (rs2 != null)
				try {
					rs2.close();
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
		return likeRankList;
	}
	
	//경매 허가
		public void auctionAllow(int show_no) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("update show set show_auction_ok = 'O' where show_no = ?");
				pstmt.setInt(1, show_no);
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
		
		//블랙 리스트 카운트
				public int CountBlackList() throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					int i = 0;
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select count(*) from blacklist");
						rs = pstmt.executeQuery();
						
						if (rs.next()){
							i = rs.getInt(1);
							}
					
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException ex) {
							}
						if (rs2 != null)
							try {
								rs2.close();
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
					return i;
				}
		
		//블랙리스트 명단 가져오기
		public ArrayList getBlackList(int startRow, int endRow) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ArrayList blackList = new ArrayList();
			int show_no = 0;
			

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select r, black_id, black_grade, black_name, black_birth, black_phone, black_reason, black_email from (select r, black_id, black_grade, black_name, black_birth, black_phone, black_reason, black_email from (select rownum r, black_id, black_grade, black_name, black_birth, black_phone, black_reason, black_email from blacklist order by black_grade) order by r) where r  >= ? and r <= ? ");
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					BlackListDataBean bldb = new BlackListDataBean();
					
						bldb.setBlack_id(rs.getString("black_id"));
						bldb.setBlack_grade(rs.getString("black_grade"));
						bldb.setBlack_name(rs.getString("black_name"));
						bldb.setBlack_birth(rs.getString("black_birth"));
						bldb.setBlack_phone(rs.getString("black_phone"));
						bldb.setBlack_reason(rs.getString("black_reason"));
						bldb.setBlack_email(rs.getString("black_email"));
						
						
						blackList.add(bldb);
					
				}
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException ex) {
					}
				if (rs2 != null)
					try {
						rs2.close();
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
			return blackList;
		}
		
		//블랙 리스트 카운트
		public int CountLeaveList() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			int i = 0;
			

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from user_leave");
				rs = pstmt.executeQuery();
				
				if (rs.next()){
					i = rs.getInt(1);
					}
			
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException ex) {
					}
				if (rs2 != null)
					try {
						rs2.close();
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
			return i;
		}
		
		//블랙리스트 명단 가져오기
				public ArrayList getLeaveList(int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList leaveList = new ArrayList();
					int show_no = 0;
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, ul_grade, ul_birth, ul_gender, ul_date, ul_reason from (select r, ul_grade, ul_birth, ul_gender, ul_date, ul_reason from (select rownum r, ul_grade, ul_birth, ul_gender, ul_date, ul_reason from user_leave order by ul_date desc) order by r) where r  >= ? and r <= ? ");
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							AdminUlDataBean audb = new AdminUlDataBean();
							
								audb.setUl_grade(rs.getString("ul_grade"));
								audb.setUl_birth(rs.getString("ul_birth"));
								audb.setUl_gender(rs.getString("ul_gender"));
								audb.setUl_date(rs.getTimestamp("ul_date"));
								audb.setUl_reason(rs.getString("ul_reason"));
																
								leaveList.add(audb);
							
						}
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException ex) {
							}
						if (rs2 != null)
							try {
								rs2.close();
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
					return leaveList;
				}
				
				//신고 작품 수 리스트 카운트
				public int CountReportList() throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					int i = 0;
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select count(*) from show where show_report > 0 ");
						rs = pstmt.executeQuery();
						
						if (rs.next()){
							i = rs.getInt(1);
							}
					
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException ex) {
							}
						if (rs2 != null)
							try {
								rs2.close();
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
					return i;
				}
				
				//신고 작품 명단 가져오기
				public ArrayList getReportList(int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList reportList = new ArrayList();
					int show_no = 0;
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, show_no, l_category_name, show_title, user_id, show_report from (select r, show_no, l_category_name, show_title, user_id, show_report from (select rownum r, show_no, l_category_name, show_title, user_id, show_report from show order by show_report) order by r) where r  >= ? and r <= ? and show_report >=1");
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							ShowDataBean sdb = new ShowDataBean();
							
								sdb.setShow_no(rs.getInt("show_no"));
								sdb.setL_category_name(rs.getString("l_category_name"));
								sdb.setShow_title(rs.getString("show_title"));
								sdb.setUser_id(rs.getString("user_id"));
								sdb.setShow_report(rs.getInt("show_report"));
																
								reportList.add(sdb);
							
						}
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException ex) {
							}
						if (rs2 != null)
							try {
								rs2.close();
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
					return reportList;
				}
				
				//신고 글 삭제
			public void reportDelete(int show_no) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("delete show where show_no = ?");
						pstmt.setInt(1, show_no);
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
			//회원 수 리스트 카운트
			public int CountUserList() throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				int i = 0;
				

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select count(*) from users");
					rs = pstmt.executeQuery();
					
					if (rs.next()){
						i = rs.getInt(1);
						}
				
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return i;
			}
			
			//회원 명단 가져오기
			public ArrayList getUserList(int startRow, int endRow) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ArrayList userList = new ArrayList();
				int show_no = 0;
				

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select rownum r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from users order by user_id) order by r) where r  >= ? and r <= ?");
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					rs = pstmt.executeQuery();
					
					while (rs.next()){
						LogonDataBean udb = new LogonDataBean();
						
							udb.setUser_id(rs.getString("user_id"));
							udb.setUser_pw(rs.getString("user_pw"));
							udb.setUser_grade(rs.getString("user_grade"));
							udb.setUser_name(rs.getString("user_name"));
							udb.setUser_birth(rs.getString("user_birth"));
							udb.setUser_gender(rs.getString("user_gender"));
							udb.setUser_phone(rs.getString("user_phone"));
							udb.setUser_email(rs.getString("user_email"));
							udb.setUser_pw_hint(rs.getString("user_pw_hint"));
							udb.setUser_introduction(rs.getString("user_introduction"));
							udb.setUser_photo(rs.getString("user_photo"));
							udb.setUser_con1(rs.getString("user_con1"));
							udb.setUser_con2(rs.getString("user_con2"));
							udb.setUser_con3(rs.getString("user_con3"));
							udb.setUser_date(rs.getTimestamp("user_date"));
							udb.setDay_post(rs.getInt("day_post"));
							udb.setTotal_like(rs.getInt("total_like"));
							udb.setTotal_post(rs.getInt("total_post"));
																						
							userList.add(udb);
						
					}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return userList;
			}
			
			//등급관리
			public void gradeUpDown(String user_id, String grade) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("update users set user_grade = ? where user_id = ?");
						pstmt.setString(1, grade);
						pstmt.setString(2, user_id);
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
			
			//등급관리
			public void registBlackList(String user_id, String grade, String blackListReason) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					LogonDataBean udb = new LogonDataBean();
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select * from users where user_id = ?");
						pstmt.setString(1, user_id);
						rs = pstmt.executeQuery();	
					if(rs.next()) {
						pstmt = conn.prepareStatement("insert into blacklist values(?, ?, ?, ?, ?, ?, ?");
						pstmt.setString(1, user_id);
						pstmt.setString(2, rs.getString("user_grade"));
						pstmt.setString(3, rs.getString("user_name"));
						pstmt.setString(4, rs.getString("user_birth"));
						pstmt.setString(5, rs.getString("user_phone"));
						pstmt.setString(6, blackListReason);
						pstmt.setString(7, rs.getString("user_email"));
						int i = pstmt.executeUpdate();
						if(i >= 1) {
							pstmt = conn.prepareStatement("delete from users where user_id = ?");
							pstmt.setString(1, user_id);
							pstmt.executeUpdate();
						}
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
					
				}
			// 쪽지보내기
			public void adminSendMessage(String sessionId, String user_id, String content, String subject) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;					
				ResultSet rs3 = null;					
				String firstBiddingp = null;
				ArrayList interestList = new ArrayList();
				AuctionDataBean adb = new AuctionDataBean();
				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("insert into send_msg values(SEND_MSG_SEQ.nextVal, ?, ?, ?, ?, sysdate)");
					pstmt.setString(1, user_id);
					pstmt.setString(2, sessionId);
					pstmt.setString(3, subject);
					pstmt.setString(4, content);
					int i = pstmt.executeUpdate();
					if(i == 1) {
						pstmt = conn.prepareStatement("select * from send_msg where send_to_id = ? and send_from_id = ? order by send_time desc");
						pstmt.setString(1, user_id);
						pstmt.setString(2, sessionId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
						int send_no = rs.getInt("send_no");
						pstmt = conn.prepareStatement("insert into recieve_msg values(RECIEVE_MSG_SEQ.nextval, ?, ?, ?, ?, sysdate)");
						pstmt.setString(1, user_id);
						pstmt.setString(2, sessionId);
						pstmt.setString(3, subject);
						pstmt.setString(4, content);
						int j = pstmt.executeUpdate();
						}
						
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
			
		}
	
			//유저 상세 정보 가져오기
			public LogonDataBean getUserDetail(String user_id) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ResultSet rs3 = null;
				
				ArrayList userList = new ArrayList();
				int show_no = 0;
				LogonDataBean udb = new LogonDataBean();

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select * from users where user_id = ?");
					pstmt.setString(1, user_id);
					rs = pstmt.executeQuery();
					
					if (rs.next()){
												
							udb.setUser_id(rs.getString("user_id"));
							udb.setUser_pw(rs.getString("user_pw"));
							udb.setUser_grade(rs.getString("user_grade"));
							udb.setUser_name(rs.getString("user_name"));
							udb.setUser_birth(rs.getString("user_birth"));
							udb.setUser_gender(rs.getString("user_gender"));
							udb.setUser_phone(rs.getString("user_phone"));
							udb.setUser_email(rs.getString("user_email"));
							udb.setUser_pw_hint(rs.getString("user_pw_hint"));
							udb.setUser_introduction(rs.getString("user_introduction"));
							udb.setUser_photo(rs.getString("user_photo"));
							udb.setUser_con1(rs.getString("user_con1"));
							udb.setUser_con2(rs.getString("user_con2"));
							udb.setUser_con3(rs.getString("user_con3"));
							udb.setUser_date(rs.getTimestamp("user_date"));
							udb.setDay_post(rs.getInt("day_post"));
							udb.setTotal_like(rs.getInt("total_like"));
							udb.setTotal_post(rs.getInt("total_post"));
						
							pstmt = conn.prepareStatement("select count(*) from follow where follower = ?");
							pstmt.setString(1, user_id);
							rs2 = pstmt.executeQuery();
							
							pstmt = conn.prepareStatement("select count(*) from follow where following = ?");
							pstmt.setString(1, user_id);
							rs3 = pstmt.executeQuery();
							if(rs2.next()) {
							udb.setTotal_following(rs2.getInt(1));
							}
							if(rs3.next()) {
							udb.setTotal_follower(rs3.getInt(1));
							}
							}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return udb;
			}
			//회원 명단 가져오기
			public ArrayList adminSearhName(String user_name, int startRow, int endRow) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ArrayList userList = new ArrayList();
				int show_no = 0;

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select rownum r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from users where user_name like ? order by user_id) order by r) where r  >= ? and r <= ?");
					pstmt.setString(1, "%" + user_name + "%");
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs = pstmt.executeQuery();
					
					while (rs.next()){
						LogonDataBean udb = new LogonDataBean();
						
							udb.setUser_id(rs.getString("user_id"));
							udb.setUser_pw(rs.getString("user_pw"));
							udb.setUser_grade(rs.getString("user_grade"));
							udb.setUser_name(rs.getString("user_name"));
							udb.setUser_birth(rs.getString("user_birth"));
							udb.setUser_gender(rs.getString("user_gender"));
							udb.setUser_phone(rs.getString("user_phone"));
							udb.setUser_email(rs.getString("user_email"));
							udb.setUser_pw_hint(rs.getString("user_pw_hint"));
							udb.setUser_introduction(rs.getString("user_introduction"));
							udb.setUser_photo(rs.getString("user_photo"));
							udb.setUser_con1(rs.getString("user_con1"));
							udb.setUser_con2(rs.getString("user_con2"));
							udb.setUser_con3(rs.getString("user_con3"));
							udb.setUser_date(rs.getTimestamp("user_date"));
							udb.setDay_post(rs.getInt("day_post"));
							udb.setTotal_like(rs.getInt("total_like"));
							udb.setTotal_post(rs.getInt("total_post"));
																						
							userList.add(udb);
						
					}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return userList;
			}	
			
			public ArrayList adminSearhGrade(String user_grade, int startRow, int endRow) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ArrayList userList = new ArrayList();
				int show_no = 0;

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select rownum r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from users where user_grade like ? order by user_id) order by r) where r  >= ? and r <= ?");
					pstmt.setString(1, "%" + user_grade + "%");
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs = pstmt.executeQuery();
					
					while (rs.next()){
						LogonDataBean udb = new LogonDataBean();
						
							udb.setUser_id(rs.getString("user_id"));
							udb.setUser_pw(rs.getString("user_pw"));
							udb.setUser_grade(rs.getString("user_grade"));
							udb.setUser_name(rs.getString("user_name"));
							udb.setUser_birth(rs.getString("user_birth"));
							udb.setUser_gender(rs.getString("user_gender"));
							udb.setUser_phone(rs.getString("user_phone"));
							udb.setUser_email(rs.getString("user_email"));
							udb.setUser_pw_hint(rs.getString("user_pw_hint"));
							udb.setUser_introduction(rs.getString("user_introduction"));
							udb.setUser_photo(rs.getString("user_photo"));
							udb.setUser_con1(rs.getString("user_con1"));
							udb.setUser_con2(rs.getString("user_con2"));
							udb.setUser_con3(rs.getString("user_con3"));
							udb.setUser_date(rs.getTimestamp("user_date"));
							udb.setDay_post(rs.getInt("day_post"));
							udb.setTotal_like(rs.getInt("total_like"));
							udb.setTotal_post(rs.getInt("total_post"));
																						
							userList.add(udb);
						
					}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return userList;
			}	
			
			public ArrayList adminSearhId(String user_id, int startRow, int endRow) throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ArrayList userList = new ArrayList();
				int show_no = 0;

				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from (select rownum r, user_id, user_pw, user_grade, user_name, user_birth, user_gender, user_phone, user_email, user_pw_hint, user_introduction, user_photo, user_con1, user_con2, user_con3, user_date, day_post, total_like, total_post "
							+ "from users where user_id like ? order by user_id) order by r) where r  >= ? and r <= ?");
					pstmt.setString(1, "%" + user_id +"%");
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs = pstmt.executeQuery();
					
					while (rs.next()){
						LogonDataBean udb = new LogonDataBean();
						
							udb.setUser_id(rs.getString("user_id"));
							udb.setUser_pw(rs.getString("user_pw"));
							udb.setUser_grade(rs.getString("user_grade"));
							udb.setUser_name(rs.getString("user_name"));
							udb.setUser_birth(rs.getString("user_birth"));
							udb.setUser_gender(rs.getString("user_gender"));
							udb.setUser_phone(rs.getString("user_phone"));
							udb.setUser_email(rs.getString("user_email"));
							udb.setUser_pw_hint(rs.getString("user_pw_hint"));
							udb.setUser_introduction(rs.getString("user_introduction"));
							udb.setUser_photo(rs.getString("user_photo"));
							udb.setUser_con1(rs.getString("user_con1"));
							udb.setUser_con2(rs.getString("user_con2"));
							udb.setUser_con3(rs.getString("user_con3"));
							udb.setUser_date(rs.getTimestamp("user_date"));
							udb.setDay_post(rs.getInt("day_post"));
							udb.setTotal_like(rs.getInt("total_like"));
							udb.setTotal_post(rs.getInt("total_post"));
																						
							userList.add(udb);
						
					}
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (SQLException ex) {
						}
					if (rs2 != null)
						try {
							rs2.close();
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
				return userList;
			}	
			
}

