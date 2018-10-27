package s.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDBBean {
	
	private static MessageDBBean instance = new MessageDBBean();

	public static MessageDBBean getInstance() {
		return instance;
	}

	private MessageDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//보낸사람으로 검색
	public ArrayList recieveMsgSearchFromId(String sessionId, String recieve_from_id, int startRow, int endRow) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList recieveMsgList = new ArrayList();
		int show_no = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from (select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from (select rownum r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from recieve_msg where recieve_to_id = ? and recieve_from_id like ? order by recieve_time) order by r) where r  >= ? and r <= ?");
			pstmt.setString(1, sessionId);
			pstmt.setString(2, "%" + recieve_from_id +"%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				MessageDataBean mdb = new MessageDataBean();
				
					mdb.setRecieve_no(rs.getInt("recieve_no"));
					mdb.setRecieve_to_id(rs.getString("recieve_to_id"));
					mdb.setRecieve_from_id(rs.getString("recieve_from_id"));
					mdb.setRecieve_subject(rs.getString("recieve_subject"));
					mdb.setRecieve_content(rs.getString("recieve_content"));
					mdb.setRecieve_time(rs.getTimestamp("recieve_time"));
																							
					recieveMsgList.add(mdb);
				
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
		return recieveMsgList;
	}	
	
	//제목으로 검색
	public ArrayList recieveMsgSearchSubject(String sessionId, String recieve_subject, int startRow, int endRow) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList recieveMsgList = new ArrayList();
		int show_no = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from (select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from (select rownum r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
					+ "from recieve_msg where recieve_to_id = ? and recieve_subject like ? order by recieve_time) order by r) where r  >= ? and r <= ?");
			pstmt.setString(1, sessionId);
			pstmt.setString(2, "%" + recieve_subject +"%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				MessageDataBean mdb = new MessageDataBean();
				
					mdb.setRecieve_no(rs.getInt("recieve_no"));
					mdb.setRecieve_to_id(rs.getString("recieve_to_id"));
					mdb.setRecieve_from_id(rs.getString("recieve_from_id"));
					mdb.setRecieve_subject(rs.getString("recieve_subject"));
					mdb.setRecieve_content(rs.getString("recieve_content"));
					mdb.setRecieve_time(rs.getTimestamp("recieve_time"));
																							
					recieveMsgList.add(mdb);
				
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
		return recieveMsgList;
	}
	
	//내용으로 검색
		public ArrayList recieveMsgSearchContent(String sessionId, String recieve_content, int startRow, int endRow) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList recieveMsgList = new ArrayList();
			int show_no = 0;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
						+ "from (select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
						+ "from (select rownum r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
						+ "from recieve_msg where recieve_to_id = ? and recieve_content like ? order by recieve_time) order by r) where r  >= ? and r <= ?");
				pstmt.setString(1, sessionId);
				pstmt.setString(2, "%" + recieve_content +"%");
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					MessageDataBean mdb = new MessageDataBean();
					
						mdb.setRecieve_no(rs.getInt("recieve_no"));
						mdb.setRecieve_to_id(rs.getString("recieve_to_id"));
						mdb.setRecieve_from_id(rs.getString("recieve_from_id"));
						mdb.setRecieve_subject(rs.getString("recieve_subject"));
						mdb.setRecieve_content(rs.getString("recieve_content"));
						mdb.setRecieve_time(rs.getTimestamp("recieve_time"));
																								
						recieveMsgList.add(mdb);
					
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
			return recieveMsgList;
		}
		
		//받은 메세지
				public ArrayList recieveMsgList(int startRow, int endRow, String sessionId) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ArrayList recieveMsgList = new ArrayList();
					int show_no = 0;

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
								+ "from (select r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
								+ "from (select rownum r, recieve_no, recieve_to_id, recieve_from_id, recieve_subject, recieve_content, recieve_time "
								+ "from recieve_msg where recieve_to_id = ? order by recieve_time) order by r) where r  >= ? and r <= ?");
						pstmt.setString(1, sessionId);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							MessageDataBean mdb = new MessageDataBean();
							
								mdb.setRecieve_no(rs.getInt("recieve_no"));
								mdb.setRecieve_to_id(rs.getString("recieve_to_id"));
								mdb.setRecieve_from_id(rs.getString("recieve_from_id"));
								mdb.setRecieve_subject(rs.getString("recieve_subject"));
								mdb.setRecieve_content(rs.getString("recieve_content"));
								mdb.setRecieve_time(rs.getTimestamp("recieve_time"));
																										
								recieveMsgList.add(mdb);
							
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
					return recieveMsgList;
				}
				
				//받는사람으로 검색
				public ArrayList sendMsgSearchToId(String sessionId, String send_to_id, int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					int show_no = 0;

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select rownum r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from send_msg where send_from_id = ? and send_to_id like ? order by send_time) order by r) where r  >= ? and r <= ?");
						pstmt.setString(1, sessionId);
						pstmt.setString(2, "%" + send_to_id +"%");
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							MessageDataBean mdb = new MessageDataBean();
							
								mdb.setSend_no(rs.getInt("send_no"));
								mdb.setSend_to_id(rs.getString("send_to_id"));
								mdb.setSend_from_id(rs.getString("send_from_id"));
								mdb.setSend_subject(rs.getString("send_subject"));
								mdb.setSend_content(rs.getString("send_content"));
								mdb.setSend_time(rs.getTimestamp("send_time"));
																										
								sendMsgList.add(mdb);
							
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
					return sendMsgList;
				}	
				
				//제목으로 검색
				public ArrayList sendMsgSearchSubject(String sessionId, String send_subject, int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					int show_no = 0;

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select rownum r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from send_msg where send_from_id = ? and send_subject like ? order by send_time) order by r) where r  >= ? and r <= ?");
						pstmt.setString(1, sessionId);
						pstmt.setString(2, "%" + send_subject +"%");
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							MessageDataBean mdb = new MessageDataBean();
							
								mdb.setSend_no(rs.getInt("send_no"));
								mdb.setSend_to_id(rs.getString("send_to_id"));
								mdb.setSend_from_id(rs.getString("send_from_id"));
								mdb.setSend_subject(rs.getString("send_subject"));
								mdb.setSend_content(rs.getString("send_content"));
								mdb.setSend_time(rs.getTimestamp("send_time"));
																										
								sendMsgList.add(mdb);
							
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
					return sendMsgList;
				}
				
				//내용으로 검색
				public ArrayList sendMsgSearchContent(String sessionId, String send_content, int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select rownum r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from send_msg where send_from_id = ? and send_content like ? order by send_time) order by r) where r  >= ? and r <= ?");
						pstmt.setString(1, sessionId);
						pstmt.setString(2, "%" + send_content +"%");
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							MessageDataBean mdb = new MessageDataBean();
							
								mdb.setSend_no(rs.getInt("send_no"));
								mdb.setSend_to_id(rs.getString("send_to_id"));
								mdb.setSend_from_id(rs.getString("send_from_id"));
								mdb.setSend_subject(rs.getString("send_subject"));
								mdb.setSend_content(rs.getString("send_content"));
								mdb.setSend_time(rs.getTimestamp("send_time"));
																										
								sendMsgList.add(mdb);
							
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
					return sendMsgList;
				}
				
				//보낸쪽지 리스트 검색
				public ArrayList sendMsgList(String sessionId, int startRow, int endRow) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from (select rownum r, send_no, send_to_id, send_from_id, send_subject, send_content, send_time "
								+ "from send_msg where send_from_id = ? order by send_time) order by r) where r  >= ? and r <= ?");
						
						pstmt.setString(1, sessionId);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							MessageDataBean mdb = new MessageDataBean();
							
								mdb.setSend_no(rs.getInt("send_no"));
								mdb.setSend_to_id(rs.getString("send_to_id"));
								mdb.setSend_from_id(rs.getString("send_from_id"));
								mdb.setSend_subject(rs.getString("send_subject"));
								mdb.setSend_content(rs.getString("send_content"));
								mdb.setSend_time(rs.getTimestamp("send_time"));
																										
								sendMsgList.add(mdb);
							
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
					return sendMsgList;
				}
				
				//보낸쪽지 삭제
				public void deleteSendMessage(int send_no) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("delete from send_msg where send_no = ?");
						pstmt.setInt(1, send_no);
						pstmt.executeUpdate();
												
						
						
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
					
				}
				
				//받은쪽지 삭제
				public void deleteRecieveMessage(int recieve_no) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					ArrayList sendMsgList = new ArrayList();
					

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("delete from recieve_msg where recieve_no = ?");
						pstmt.setInt(1, recieve_no);
						pstmt.executeUpdate();
												
						
						
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
					
				}

}
