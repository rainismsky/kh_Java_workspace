package s.bean;

import java.sql.*;

import javax.sql.*;

import j.show.ShowDataBean;

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

	// auction_ing정보 가져오기.jsp
	public AuctionDataBean getAuctionInfo(int auc_ing_no, String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		
		
		int show_no = 0;
		AuctionDataBean adb = new AuctionDataBean();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no = ?");
			pstmt.setInt(1, auc_ing_no);
			rs = pstmt.executeQuery();
			if (rs.next()){
				show_no = rs.getInt("show_no");
					
			}
			pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no =" + auc_ing_no);
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement("select * from show where show_no = " + show_no);
			rs2 = pstmt.executeQuery();
			pstmt = conn.prepareStatement("select * from users where user_id = '" + user_id + "'");
			rs3 = pstmt.executeQuery();
			

			if (rs.next() && rs2.next() && rs3.next()){
				adb.setAuc_ing_no(rs.getInt("auc_ing_no"));
				adb.setShow_no(rs.getInt("show_no"));
				adb.setAuc_image(rs.getString("auc_image"));
				adb.setUser_id(rs.getString("user_id"));
				adb.setAuc_sp(rs.getInt("auc_sp"));
				adb.setAuc_unit(rs.getInt("auc_unit"));
				adb.setAuc_start(rs.getTimestamp("auc_start"));
				adb.setAuc_end(rs.getTimestamp("auc_end"));
				adb.setShow_title(rs2.getString("show_title"));
				adb.setL_category_name(rs2.getString("l_category_name"));
				adb.setShow_content(rs2.getString("show_content"));
				adb.setUser_photo(rs3.getString("user_photo"));
				adb.setUser_introduction(rs3.getString("user_introduction"));
						
			} else {
				
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
			if (rs3 != null)
				try {
					rs3.close();
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
		return adb;
	}
	//좋아요 가져오기
	public int countIlike(int an) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		int show_no = 0;
		int countIlike = 0;
		
		int sno = 0;
		AuctionDataBean adb = new AuctionDataBean();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no = ?");
			pstmt.setInt(1, an);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				show_no = rs.getInt("show_no");
			}
			pstmt = conn.prepareStatement("select count(*) from ilike where show_no = ?");
			pstmt.setInt(1, show_no);
			rs = pstmt.executeQuery();
			if (rs.next()){
				countIlike = rs.getInt(1);
					
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
			if (rs3 != null)
				try {
					rs3.close();
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
		return countIlike;
	}
	
	// auction 입찰자/입찰금액 가져오기
	public HashMap getI_Bidder(int auc_ing_no, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int mybidp = 0;
		int i = 0;
		List bidderList = null;
		AuctionDataBean adb = new AuctionDataBean();
		int[] bidderList2 = new int[5]; 
		bidderList = new ArrayList(5);
		HashMap bidderMap = new HashMap();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from "
					+ "(select i_bidding_p, i_bidder, rownum r from "
					+ "(select i_bidding_p, i_bidder from ing_bid where auc_ing_no = ? "
					+ "order by i_bidding_p desc)) "
					+ "where r between 1 and 3");
			pstmt.setInt(1, auc_ing_no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(i);
				bidderMap.put("bidp" + i, rs.getInt("i_bidding_p"));
				i++;
			}
			switch(i) {
			case 0 : 
				for(int j = 0; j <3; j++) {
					bidderMap.put("bidp" + j, 0);
					
					}
				break;
			case 1 :
				for(int j = 1; j <3; j++) {
					bidderMap.put("bidp" + j, 0);
							
				}
				break;
			case 2 :
				bidderMap.put("bidp2", 0);
				
				break;
			}
			
			pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ? and i_bidder = ?");
			pstmt.setInt(1, auc_ing_no);
			pstmt.setString(2, sessionId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bidderMap.put("mybidp", rs.getInt("i_bidding_p"));
				
			}else {
				bidderMap.put("mybidp", 0);
			
			}
			
			pstmt = conn.prepareStatement("select max(r) mr from (select i_bidding_p, i_bidder, rownum r from (select i_bidding_p, i_bidder from ing_bid where auc_ing_no = ? order by i_bidding_p desc))");
			pstmt.setInt(1, auc_ing_no);
			rs = pstmt.executeQuery();
						
			if (rs.next()){
				bidderMap.put("countbid", rs.getInt(1));
				/*bidderList2[4] = rs.getInt("mr");*/
				/*adb.setBidding_p(rs.getInt("mr"));
				bidderList.add(adb);*/
	
			} else {
				bidderMap.put("countbid", 0);
				/*bidderList2[4] = 0;*/
				/*adb.setBidding_p(0);
				bidderList.add(adb);*/				
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
		return bidderMap;
	}
	
	//입찰하기
	public void bid(int auc_ing_no, String sessionId, int i_bidding_p) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ? and i_bidder = ?");
			pstmt.setInt(1, auc_ing_no);
			pstmt.setString(2, sessionId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			pstmt = conn.prepareStatement("update ing_bid set i_bidding_p = ? where auc_ing_no = ? and i_bidder = ?");
			pstmt.setInt(1, i_bidding_p);
			pstmt.setInt(2, auc_ing_no);
			pstmt.setString(3, sessionId);
			i = pstmt.executeUpdate();
			} else {
				pstmt = conn.prepareStatement("insert into ing_bid values(?, ?, ?)");
				pstmt.setInt(1, auc_ing_no);
				pstmt.setString(2, sessionId);
				pstmt.setInt(3 , i_bidding_p);
				pstmt.executeUpdate();
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
	//관심경매 등록하기
	public void insertinterestAuc(int an, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into interest_auction values(?, ?)");
			pstmt.setInt(1, an);
			pstmt.setString(2, sessionId);
			i = pstmt.executeUpdate();
			System.out.println(i);	
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
	public void deleteinterestAuc(int an, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from interest_auction where auc_ing_no = ? and user_id = ?");
			pstmt.setInt(1, an);
			pstmt.setString(2, sessionId);
			i = pstmt.executeUpdate();
				
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
	
	//관심경매 등록 여부
	public int checkinterestAuc(int auc_ing_no, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from interest_auction where auc_ing_no = ? and user_id = ?");
			pstmt.setInt(1, auc_ing_no);
			pstmt.setString(2, sessionId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = 1;				
			}else {
				check = 0;
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
		return check;		
}
	//진행중->마감경매
	/*public AuctionDataBean_end MoveToEndAuc(int an) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			ResultSet rs4 = null;
			int sno = 0;
			String userId = "";
			String state = null;
			ArrayList bidderList = new ArrayList();
			AuctionDataBean_end adbe = new AuctionDataBean_end();
			int i = 0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no = ?");
				pstmt.setInt(1, an);
				rs = pstmt.executeQuery();
				if(rs.next()){
				sno = rs.getInt("show_no");
				userId = rs.getString("user_id");
				}
				
				pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no = ?");
				pstmt.setInt(1, an);
				rs = pstmt.executeQuery();
				pstmt = conn.prepareStatement("select * from show where show_no = ?");
				pstmt.setInt(1, sno);
				rs2 = pstmt.executeQuery();
				pstmt = conn.prepareStatement("select * from users where user_id = ?");
				pstmt.setString(1, userId);
				rs3 = pstmt.executeQuery();
				
				if(rs.next() && rs2.next() && rs3.next()) {
					adbe.setAuc_end_no(rs.getInt("auc_ing_no"));
					adbe.setAuc_title(rs2.getString("show_title"));
					adbe.setAuc_content(rs2.getString("show_content"));
					adbe.setL_category_name(rs.getString("l_category_name"));
					System.out.println("dbbean" + rs.getString("auc_image"));
					adbe.setAuc_image(rs.getString("auc_image"));
					adbe.setUser_id(rs.getString("user_id"));
					adbe.setAuc_sp(rs.getInt("auc_sp"));
					adbe.setAuc_unit(rs.getInt("auc_unit"));
					adbe.setAuc_state(0);
					adbe.setAuc_end(rs.getTimestamp("auc_end"));
					adbe.setUser_photo(rs3.getString("user_photo"));
					adbe.setUser_introduction(rs3.getString("user_introduction"));
																
				}
				pstmt = conn.prepareStatement("insert into auction_end values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setInt(1, rs.getInt("auc_ing_no"));
				pstmt.setString(2, rs2.getString("show_title"));
				pstmt.setString(3, rs2.getString("show_content"));
				pstmt.setString(4, rs.getString("l_category_name"));
				pstmt.setString(5, rs.getString("auc_image"));
				pstmt.setString(6, rs.getString("user_id"));
				pstmt.setInt(7, rs.getInt("auc_sp"));
				pstmt.setInt(8, rs.getInt("auc_unit"));
				pstmt.setInt(9, 0);
				pstmt.setString(10, "선정중");
				pstmt.setInt(11, 0);
				pstmt.setTimestamp(12, rs.getTimestamp("auc_end"));
				pstmt.setString(13, "선정중");
				pstmt.setTimestamp(14, rs.getTimestamp("auc_end"));
				i= pstmt.executeUpdate();
				System.out.println("i" + i);
				if(i == 1) {
					System.out.println("if");
					pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ?");
					pstmt.setInt(1, an);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						System.out.println("while");
						AuctionDataBean_end adbe2 = new AuctionDataBean_end();
						adbe2.setE_bidder(rs.getString("i_bidder"));
						adbe2.setE_bidding_p(rs.getInt("i_bidding_p"));
						bidderList.add(adbe2);
						pstmt = conn.prepareStatement("insert into end_bid values(?,?,?)");
						pstmt.setInt(1, an);
						pstmt.setString(2, rs.getString("i_bidder"));
						pstmt.setInt(3, rs.getInt("i_bidding_p"));
						i= pstmt.executeUpdate();
					}
					if(i == 1) {
					System.out.println("if2" + sno);
					pstmt = conn.prepareStatement("delete from show where show_no = ?");
					pstmt.setInt(1, sno);
					int j = 0;
					j = pstmt.executeUpdate();
					System.out.println("j" + j);
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
			return adbe;
	}	*/
	
	//진행중->마감경매
		public void MoveToEndAuc() throws Exception {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				ResultSet rs3 = null;
				ResultSet rs4 = null;
				int sno = 0;
				int an = 0;
				int auc_ing_no = 0;
				String userId = "";
				int state = 0;
				ArrayList bidderList = new ArrayList();
				AuctionDataBean_end adbe = new AuctionDataBean_end();
				int i = 0;
				try {
					conn = getConnection();
					pstmt = conn.prepareStatement("select * from auction_ing where AUC_END <= sysdate");
					rs = pstmt.executeQuery();
					while(rs.next()){
						System.out.println("while??");
					sno = rs.getInt("show_no");
					userId = rs.getString("user_id");
					an = rs.getInt("auc_ing_no");
					/*pstmt = conn.prepareStatement("select * from auction_ing where auc_ing_no = ?");
					pstmt.setInt(1, an);
					rs = pstmt.executeQuery();*/
					pstmt = conn.prepareStatement("select * from show where show_no = ?");
					pstmt.setInt(1, sno);
					rs2 = pstmt.executeQuery();
					pstmt = conn.prepareStatement("select * from users where user_id = ?");
					pstmt.setString(1, userId);
					rs3 = pstmt.executeQuery();
					pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ?");
					pstmt.setInt(1, an);
					rs4 = pstmt.executeQuery();
					if(rs4.next()) {
					state = 0;	
					} else {
						state = 1;
					}
					if(rs2.next() && rs3.next()) {
						adbe.setAuc_end_no(rs.getInt("auc_ing_no"));
						adbe.setAuc_title(rs2.getString("show_title"));
						adbe.setAuc_content(rs2.getString("show_content"));
						adbe.setL_category_name(rs.getString("l_category_name"));
						System.out.println("dbbean" + rs.getString("auc_image"));
						adbe.setAuc_image(rs.getString("auc_image"));
						adbe.setUser_id(rs.getString("user_id"));
						adbe.setAuc_sp(rs.getInt("auc_sp"));
						adbe.setAuc_unit(rs.getInt("auc_unit"));
						adbe.setAuc_state(state);
						adbe.setAuc_end(rs.getTimestamp("auc_end"));
						adbe.setUser_photo(rs3.getString("user_photo"));
						adbe.setUser_introduction(rs3.getString("user_introduction"));
																	
					}
					pstmt = conn.prepareStatement("insert into auction_end values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setInt(1, rs.getInt("auc_ing_no"));
					pstmt.setString(2, rs2.getString("show_title"));
					pstmt.setString(3, rs2.getString("show_content"));
					pstmt.setString(4, rs.getString("l_category_name"));
					pstmt.setString(5, rs.getString("auc_image"));
					pstmt.setString(6, rs.getString("user_id"));
					pstmt.setInt(7, rs.getInt("auc_sp"));
					pstmt.setInt(8, rs.getInt("auc_unit"));
					pstmt.setInt(9, state);
					pstmt.setString(10, "선정중");
					pstmt.setInt(11, 0);
					pstmt.setTimestamp(12, rs.getTimestamp("auc_end"));
					pstmt.setString(13, "선정중");
					pstmt.setTimestamp(14, rs.getTimestamp("auc_end"));
					i= pstmt.executeUpdate();
					System.out.println("i" + i);
					if(i == 1 && state == 0) {
						System.out.println("if");
						pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ?");
						pstmt.setInt(1, an);
						rs4 = pstmt.executeQuery();
						while(rs4.next()) {
							System.out.println("while");
							AuctionDataBean_end adbe2 = new AuctionDataBean_end();
							adbe2.setE_bidder(rs4.getString("i_bidder"));
							adbe2.setE_bidding_p(rs4.getInt("i_bidding_p"));
							bidderList.add(adbe2);
							pstmt = conn.prepareStatement("insert into end_bid values(?,?,?)");
							pstmt.setInt(1, an);
							pstmt.setString(2, rs4.getString("i_bidder"));
							pstmt.setInt(3, rs4.getInt("i_bidding_p"));
							i= pstmt.executeUpdate();
						}
						if(i == 1) {
						System.out.println("if2" + sno);
						pstmt = conn.prepareStatement("delete from show where show_no = ?");
						pstmt.setInt(1, sno);
						int j = 0;
						j = pstmt.executeUpdate();
						pstmt = conn.prepareStatement("delete from ing_bid where auc_ing_no = ?");
						pstmt.setInt(1, an);
						int k = 0;
						k = pstmt.executeUpdate();
						System.out.println("j" + j);
						}
					}else if(state == 1) {
						pstmt = conn.prepareStatement("delete from auction_ing where auc_ing_no = ?");
						pstmt.setInt(1, an);
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
	//마감 경매 입찰자
	public HashMap getE_Bidder(int an, String user_id, String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int mybidp = 0;
		int i = 0;
		List bidderList = null;
		AuctionDataBean adb = new AuctionDataBean();
		int[] bidderList2 = new int[5]; 
		bidderList = new ArrayList(5);
		HashMap bidderMap = new HashMap();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from "
					+ "(select e_bidding_p, e_bidder, rownum r from "
					+ "(select e_bidding_p, e_bidder from end_bid where auc_end_no = ? "
					+ "order by e_bidding_p desc)) "
					+ "where r between 1 and 3");
			pstmt.setInt(1, an);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(i);
				/*bidderList2[i] = rs.getInt("mp");*/
				/*bidderList.add(adb);*/
				bidderMap.put("bidp" + i, rs.getInt("e_bidding_p"));
				i++;
			}
			switch(i) {
			case 0 : 
				for(int j = 0; j <3; j++) {
					bidderMap.put("bidp" + j, 0);
					/*bidderList2[j] = 0;*/
					/*adb.setBidding_p(0);
					bidderList.add(adb);*/
				}
				break;
			case 1 :
				for(int j = 1; j <3; j++) {
					bidderMap.put("bidp" + j, 0);
					/*bidderList2[j] = 0;*/
					/*adb.setBidding_p(0);
					bidderList.add(adb);*/				
				}
				break;
			case 2 :
				bidderMap.put("bidp2", 0);
				/*bidderList2[2] = 0;*/
				/*adb.setBidding_p(0);
				bidderList.add(adb);*/	
				break;
			}
			
			pstmt = conn.prepareStatement("select * from end_bid where auc_end_no = ? and e_bidder = ?");
			pstmt.setInt(1, an);
			pstmt.setString(2, sessionId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bidderMap.put("mybidp", rs.getInt("e_bidding_p"));
				/*bidderList2[3] = rs.getInt("mp");*/
				/*adb.setBidding_p(rs.getInt("mp"));
				bidderList.add(adb);*/
			}else {
				bidderMap.put("mybidp", 0);
				/*bidderList2[3] = 0;*/
				/*adb.setBidding_p(0);
				bidderList.add(adb);*/
			}
			
			pstmt = conn.prepareStatement("select max(r) mr from (select e_bidding_p, e_bidder, rownum r from (select e_bidding_p, e_bidder from end_bid where auc_end_no = ? order by e_bidding_p desc))");
			pstmt.setInt(1, an);
			rs = pstmt.executeQuery();
						
			if (rs.next()){
				bidderMap.put("countbid", rs.getInt(1));
				/*bidderList2[4] = rs.getInt("mr");*/
				/*adb.setBidding_p(rs.getInt("mr"));
				bidderList.add(adb);*/
	
			} else {
				bidderMap.put("countbid", 0);
				/*bidderList2[4] = 0;*/
				/*adb.setBidding_p(0);
				bidderList.add(adb);*/				
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
		return bidderMap;
	}
	//경매마감 상세페이지
	public AuctionDataBean_end getInfoEnd(int auc_end_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		int sno = 0;
		String userId = "";
		String state = null;
		ArrayList bidderList = new ArrayList();
		AuctionDataBean_end adbe = new AuctionDataBean_end();
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from auction_end where auc_end_no = ?");
			pstmt.setInt(1, auc_end_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
			userId = rs.getString("user_id");
			}
			pstmt = conn.prepareStatement("select * from auction_end where auc_end_no = ?");
			pstmt.setInt(1, auc_end_no);
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement("select * from users where user_id = ?");
			pstmt.setString(1, userId);
			rs2 = pstmt.executeQuery();
			if(rs.next() && rs2.next()) {
				adbe.setAuc_end_no(rs.getInt("auc_end_no"));
				adbe.setAuc_title(rs.getString("auc_title"));
				adbe.setWinner(rs.getString("winner"));
				adbe.setReview(rs.getString("review"));
				adbe.setReview_date(rs.getTimestamp("review_date"));
				adbe.setAuc_content(rs.getString("auc_content"));
				adbe.setWin_price(rs.getInt("win_price"));
				adbe.setL_category_name(rs.getString("l_category_name"));
				adbe.setAuc_image(rs.getString("auc_image"));
				adbe.setUser_id(rs.getString("user_id"));
				adbe.setAuc_sp(rs.getInt("auc_sp"));
				adbe.setAuc_unit(rs.getInt("auc_unit"));
				adbe.setAuc_state(rs.getInt("auc_state"));
				adbe.setAuc_end(rs.getTimestamp("auc_end"));
				adbe.setUser_photo(rs2.getString("user_photo"));
				adbe.setUser_introduction(rs2.getString("user_introduction"));
				pstmt = conn.prepareStatement("select * from users where user_id = ?");
				pstmt.setString(1, rs.getString("winner"));
				rs3 = pstmt.executeQuery();		
				if(rs3.next()) {
					adbe.setWinner_photo(rs3.getString("user_photo"));
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
		return adbe;
}

	//나의 경매 현황
	// 경매 가능 작품 가져오기
	public ArrayList getInfoAucOk(String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String state = null;
		ArrayList aucOkList = new ArrayList();
		ShowDataBean sdb = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from show where show_sale = ? and show_auction_ok = ? and user_id = ?");
			pstmt.setString(1, "yes");
			pstmt.setString(2, "O");
			pstmt.setString(3, sessionId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sdb = new ShowDataBean();
				sdb.setShow_no(rs.getInt("show_no"));
				sdb.setShow_title(rs.getString("show_title"));
				StringTokenizer sauc_img = new StringTokenizer(rs.getString("show_image"), ",");
				String auc_img = sauc_img.nextToken();
				sdb.setShow_image(auc_img);
				aucOkList.add(sdb);											
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
		return aucOkList;
}
	
	// 경매 등록하기
		public void insertAuc(String sessionId, int show_no, int auc_sp, int auc_unit, Timestamp auc_end, Timestamp auc_start ) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String state = null;
			ArrayList aucOkList = new ArrayList();
			ShowDataBean sdb = null;
			int i = 0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from show where show_auction_ok = ? and user_id = ? and show_no = ?");
				pstmt.setString(1, "O");
				pstmt.setString(2, sessionId);
				pstmt.setInt(3, show_no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					pstmt = conn.prepareStatement("insert into auction_ing values(AUCTION_ING_SEQ.nextVal, ?, ?, ?, ?, ?, ?, ?, ?)");
					pstmt.setInt(1, show_no);
					pstmt.setString(2, rs.getString("l_category_name"));
					pstmt.setString(3, rs.getString("show_image"));				
					pstmt.setString(4, sessionId);				
					pstmt.setInt(5, auc_sp);				
					pstmt.setInt(6, auc_unit);				
					pstmt.setTimestamp(7, auc_start);				
					pstmt.setTimestamp(8, auc_end);	
					int k = pstmt.executeUpdate();
					if(k > 0) {
					pstmt = conn.prepareStatement("update show set show_auction_ok = ? where show_no = ?");
					pstmt.setString(1, "E");
					pstmt.setInt(2, show_no);
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
	// 판매중 작품 가져오기
	public ArrayList getInfoSailing(String sessionId) throws Exception {
		Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      ResultSet rs3 = null;
	      String firstBiddingp = null;
	      ArrayList sailingList = new ArrayList();
	      AuctionDataBean adb = null;
	      try {
	         conn = getConnection();
	         pstmt = conn.prepareStatement("select * from auction_ing where user_id = ?");
	         pstmt.setString(1, sessionId);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            adb = new AuctionDataBean();
	            pstmt = conn.prepareStatement("select * from show where show_no = ?");
	            pstmt.setInt(1, rs.getInt("show_no"));
	            rs3 = pstmt.executeQuery();
	            if(rs3.next()) {
	               adb.setShow_title(rs3.getString("show_title"));
	            }
	            adb.setAuc_ing_no(rs.getInt("auc_ing_no"));
	            /*adb.setAuc_image(rs.getString("auc_image"));*/
	            StringTokenizer sauc_img = new StringTokenizer(rs.getString("auc_image"), ",");
				String auc_img = sauc_img.nextToken();
				adb.setAuc_image(auc_img);
	            adb.setAuc_end(rs.getTimestamp("auc_end"));
	            adb.setAuc_sp(rs.getInt("auc_sp"));
	            adb.setAuc_unit(rs.getInt("auc_unit"));
	            pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ? order by I_BIDDING_P desc");
	            pstmt.setInt(1, rs.getInt("auc_ing_no"));
	            rs2 = pstmt.executeQuery();
	            if(rs2.next()) {
	            adb.setI_bidding_p(rs2.getInt("i_bidding_p"));   
	            } else {
	               adb.setI_bidding_p(0);
	            }
	            sailingList.add(adb);
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
	      return sailingList;

}
	// 판매완료 작품 가져오기(낙찰자 선정중)
	/*public ArrayList getInfoSailEnd0(String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		HashMap sailEndMap = new HashMap();
		ArrayList sailEndList = new ArrayList();
		AuctionDataBean_end adbe = new AuctionDataBean_end();
		int i = 1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from auction_end where user_id = ? and auc_state = ?");
			pstmt.setString(1, sessionId);
			pstmt.setInt(2, 0);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				adbe.setAuc_end_no(rs.getInt("auc_end_no"));
				adbe.setAuc_image(rs.getString("auc_image"));
				adbe.setAuc_end(rs.getTimestamp("auc_end"));
				adbe.setAuc_sp(rs.getInt("auc_sp"));
				adbe.setAuc_unit(rs.getInt("auc_unit"));
				pstmt = conn.prepareStatement("select * from "
						+ "(select e_bidding_p, e_bidder, rownum r from "
						+ "(select e_bidding_p, e_bidder from end_bid where auc_end_no = ? "
						+ "order by e_bidding_p desc)) "
						+ "where r between 1 and 3");
				pstmt.setInt(1, rs.getInt("auc_end_no"));
				rs2 = pstmt.executeQuery();
				while(rs2.next()) {
				adbe.setE_bidderi(e_bidder1);
				}
				sailEndList.add(adbe);
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
		return sailEndList;
}*/
	//판매완료 작품 가져오기
	public ArrayList getInfoSailEnd(String sessionId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList sailEndList = new ArrayList();
		AuctionDataBean_end adbe = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from auction_end where user_id = ? order by auc_state");
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				adbe = new AuctionDataBean_end();
				pstmt = conn.prepareStatement("select e_bidder,e_bidding_p from (select auc_end_no,e_bidder,e_bidding_p,rownum r "
						+ "from end_bid order by e_bidding_p desc) where rownum>=1 and rownum<=3 and auc_end_no = ? ");
				pstmt.setInt(1, rs.getInt("auc_end_no"));
				rs2=pstmt.executeQuery();
				adbe.setAuc_end_no(rs.getInt("auc_end_no"));
				StringTokenizer sauc_img = new StringTokenizer(rs.getString("auc_image"), ",");
				String auc_img = sauc_img.nextToken();
				adbe.setAuc_image(auc_img);
				adbe.setAuc_end(rs.getTimestamp("auc_end"));
				adbe.setAuc_title(rs.getString("auc_title"));
				adbe.setAuc_sp(rs.getInt("auc_sp"));
				adbe.setAuc_unit(rs.getInt("auc_unit"));
				adbe.setAuc_state(rs.getInt("auc_state"));
				adbe.setWinner(rs.getString("winner"));
				adbe.setWin_price(rs.getInt("win_price"));
				if(!rs2.next()) {
					adbe.setE_bidding_p1(0);
					adbe.setE_bidder1("-");
					adbe.setE_bidding_p2(0);
					adbe.setE_bidder2("-");
					adbe.setE_bidding_p3(0);
					adbe.setE_bidder3("-");
				}
				adbe.setE_bidding_p1(rs2.getInt("e_bidding_p"));
				adbe.setE_bidder1(rs2.getString("e_bidder"));
				adbe.setE_bidding_p2(0);
				adbe.setE_bidder2("-");
				adbe.setE_bidding_p3(0);
				adbe.setE_bidder3("-");
				for(int i = 2; rs2.next(); i++) {
					if(i==2) {
						adbe.setE_bidding_p2(rs2.getInt("e_bidding_p"));
						adbe.setE_bidder2(rs2.getString("e_bidder"));
						
					}else if(i==3) {
						adbe.setE_bidding_p3(rs2.getInt("e_bidding_p"));
						adbe.setE_bidder3(rs2.getString("e_bidder"));
					}else
						break;
						
				}
				sailEndList.add(adbe);
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
		return sailEndList;
}
	
	//낙찰자 선정하기 창 오픈
	public AuctionDataBean_end setWinner1(int an, String e_bidder) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String firstBiddingp = null;
		ArrayList buyingList = new ArrayList();
		AuctionDataBean_end adbe = new AuctionDataBean_end();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, e_bidder, e_bidding_p, auc_end_no "
					+ "from (select rownum r, e_bidder,e_bidding_p, auc_end_no "
					+ "from (select auc_end_no,e_bidder,e_bidding_p "
					+ "from end_bid where auc_end_no = ? order by e_bidding_p desc)) "
					+ "where r>=1 and r<=3  and e_bidder = ?");
			pstmt.setInt(1, an);
			pstmt.setString(2, e_bidder);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				adbe.setAuc_end_no(rs.getInt("auc_end_no"));
				adbe.setE_bidding_p(rs.getInt("e_bidding_p"));	
				adbe.setE_bidder(rs.getString("e_bidder"));	
				adbe.setBidding_p_rank(rs.getInt("r"));	
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
		return adbe;
}
	
	//낙찰자 선정하기
		public void setWinner2(int auc_ing_no, String e_bidder, int e_bidding_p) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int show_no = 0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("update auction_end set winner = ?, win_price = ?, auc_state = 2 where auc_end_no = ?");
				pstmt.setString(1, e_bidder);
				pstmt.setInt(2, e_bidding_p);
				pstmt.setInt(3, auc_ing_no);			
				pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement("select * from auction_end where auc_end_no = ?");
				pstmt.setInt(1, auc_ing_no);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					show_no = rs.getInt("show_no");
				}
				pstmt = conn.prepareStatement("delete from show where show_no = ?");
				pstmt.setInt(1, show_no);
				rs = pstmt.executeQuery();
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
			
	}

	// 구매중 작품 가져오기
		public ArrayList getInfoBuying(String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			ResultSet rs4 = null;
			String firstBiddingp = null;
			ArrayList buyingList = new ArrayList();
			AuctionDataBean adb = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from ing_bid where i_bidder = ?");
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					adb = new AuctionDataBean();
					adb.setAuc_ing_no(rs.getInt("auc_ing_no"));
					adb.setMyBidding_p(rs.getInt("i_bidding_p"));
					pstmt = conn.prepareStatement("select auc_end, auc_sp, auc_unit, show_title, auc_image "
							+ "from show, (select * "
							+ "from auction_ing where auc_ing_no = ?) ai "
							+ "where show.show_no = ai.show_no");
					pstmt.setInt(1, rs.getInt("auc_ing_no"));
					rs2 = pstmt.executeQuery();
					if(rs2.next()) {
						StringTokenizer sauc_img = new StringTokenizer(rs2.getString("auc_image"), ",");
						String auc_img = sauc_img.nextToken();
						adb.setAuc_image(auc_img);
					adb.setShow_title(rs2.getString("show_title"));
					adb.setAuc_end(rs2.getTimestamp("auc_end"));
					adb.setAuc_sp(rs2.getInt("auc_sp"));
					adb.setAuc_unit(rs2.getInt("auc_unit"));
					pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ? order by I_BIDDING_P desc");
					pstmt.setInt(1, rs.getInt("auc_ing_no"));
					rs3 = pstmt.executeQuery();
					if(rs3.next()) {
					adb.setI_bidding_p(rs3.getInt("i_bidding_p"));	
					} else {
						adb.setI_bidding_p(0);
					}
					buyingList.add(adb);
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
			return buyingList;
	}
		// 구매완료 작품 가져오기
		public ArrayList getInfoBuyEnd(String sessionId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			ResultSet rs4 = null;
			String firstBiddingp = null;
			ArrayList buyEndList = new ArrayList();
			AuctionDataBean_end adbe = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from end_bid where e_bidder = ?");
				pstmt.setString(1, sessionId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					adbe = new AuctionDataBean_end();
					adbe.setAuc_end_no(rs.getInt("auc_end_no"));
					adbe.setMyBidding_p(rs.getInt("e_bidding_p"));
					adbe.setE_bidder(rs.getString("e_bidder"));
					pstmt = conn.prepareStatement("select * from auction_end where auc_end_no = ?");
					pstmt.setInt(1, rs.getInt("auc_end_no"));
					rs2 = pstmt.executeQuery();
					if(rs2.next()) {
						StringTokenizer sauc_img = new StringTokenizer(rs2.getString("auc_image"), ",");
						String auc_img = sauc_img.nextToken();
						adbe.setAuc_image(auc_img);
					adbe.setUser_id(rs2.getString("user_id"));
					adbe.setAuc_title(rs2.getString("auc_title"));
					adbe.setAuc_end(rs2.getTimestamp("auc_end"));
					adbe.setAuc_sp(rs2.getInt("auc_sp"));
					adbe.setAuc_unit(rs2.getInt("auc_unit"));
					adbe.setAuc_state(rs2.getInt("auc_state"));
					adbe.setReview(rs2.getString("review"));
					adbe.setWinner(rs2.getString("winner"));
					adbe.setWin_price(rs2.getInt("win_price"));
					pstmt = conn.prepareStatement("select r, e_bidder, e_bidding_p "
							+ "from (select rownum r, e_bidder,e_bidding_p "
							+ "from (select auc_end_no,e_bidder,e_bidding_p "
							+ "from end_bid where auc_end_no = ? order by e_bidding_p desc)) "
							+ "where r>=1 and r<=3  and e_bidder = ?");
					pstmt.setInt(1, rs.getInt("auc_end_no"));
					pstmt.setString(2, sessionId);
					rs3 = pstmt.executeQuery();
					if(rs3.next()) {
					adbe.setBidding_p_rank(rs3.getInt("r"));
					}
				}
					buyEndList.add(adbe);
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
			return buyEndList;
	}
		// 관심경매 작품 가져오기
				public ArrayList getInfoInterestAuc(String sessionId) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;					
					ResultSet rs3 = null;					
					String firstBiddingp = null;
					ArrayList interestList = new ArrayList();
					AuctionDataBean adb = null;
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select * from interest_auction where user_id = ?");
						pstmt.setString(1, sessionId);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							adb = new AuctionDataBean();
							adb.setAuc_ing_no(rs.getInt("auc_ing_no"));
							pstmt = conn.prepareStatement("select auc_end, auc_sp, auc_unit, show_title, auc_image "
									+ "from show, (select * "
									+ "from auction_ing where auc_ing_no = ?) ai "
									+ "where show.show_no = ai.show_no");
							pstmt.setInt(1, rs.getInt("auc_ing_no"));
							rs2 = pstmt.executeQuery();
							if(rs2.next()) {
								StringTokenizer sauc_img = new StringTokenizer(rs2.getString("auc_image"), ",");
								String auc_img = sauc_img.nextToken();
								adb.setAuc_image(auc_img);
							adb.setShow_title(rs2.getString("show_title"));
							adb.setAuc_end(rs2.getTimestamp("auc_end"));
							adb.setAuc_sp(rs2.getInt("auc_sp"));
							adb.setAuc_unit(rs2.getInt("auc_unit"));
							}
							pstmt = conn.prepareStatement("select * from ing_bid where auc_ing_no = ? order by I_BIDDING_P desc");
							pstmt.setInt(1, rs.getInt("auc_ing_no"));
							rs3 = pstmt.executeQuery();
							if(rs3.next()) {
							adb.setI_bidding_p(rs3.getInt("i_bidding_p"));	
							}
							interestList.add(adb);
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
				
				// 쪽지보내기
				public void sendMessage(String sessionId, String e_bidder, String content, String subject) throws Exception {
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
						pstmt.setString(1, e_bidder);
						pstmt.setString(2, sessionId);
						pstmt.setString(3, subject);
						pstmt.setString(4, content);
						int i = pstmt.executeUpdate();
						if(i == 1) {
							pstmt = conn.prepareStatement("select * from send_msg where send_to_id = ? and send_from_id = ? order by send_time desc");
							pstmt.setString(1, e_bidder);
							pstmt.setString(2, sessionId);
							rs = pstmt.executeQuery();
							if(rs.next()) {
							int send_no = rs.getInt("send_no");
							pstmt = conn.prepareStatement("insert into recieve_msg values(RECIEVE_MSG_SEQ.nextval, ?, ?, ?, ?, sysdate)");
							pstmt.setString(1, e_bidder);
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
				// 구매후기 form 내용
				public AuctionDataBean_end getInfoWriteForm(int auc_end_no, String sessionId) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;					
					ResultSet rs3 = null;					
					String firstBiddingp = null;
					ArrayList interestList = new ArrayList();
					AuctionDataBean_end adbe = new AuctionDataBean_end();
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select * from auction_end where auc_end_no = ?");
						pstmt.setInt(1, auc_end_no);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							adbe.setAuc_end_no(rs.getInt("auc_ing_no"));
							adbe.setAuc_title(rs2.getString("auc_title"));
							adbe.setUser_id(rs2.getString("user_id"));	
							
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
					return adbe;
			}
				//구매 후기 작성
				public void writeReview(int auc_end_no, String review) throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					ResultSet rs2 = null;					
					ResultSet rs3 = null;					
					String firstBiddingp = null;
					ArrayList interestList = new ArrayList();
					AuctionDataBean_end adbe = new AuctionDataBean_end();
					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("update auction_end set review = ?, review_date = sysdate where auc_end_no = ? ");
						pstmt.setString(1, review);
						pstmt.setInt(2, auc_end_no);
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
			
}