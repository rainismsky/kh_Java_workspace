package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manage.TeacherProfileDataBean;

public class MainDBBean {
	private static MainDBBean instance = new MainDBBean();
	
	public static MainDBBean getInstance() {
		return instance;
	}
	
	private MainDBBean() {
	}
	
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//상담 신청
	public void insert_consult
	(String date, String name, String tel, String time, String service, String t_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "insert into CONSULT values(seq_c_num.nextval,?,?,?,?,?,?)");
            pstmt.setString(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, tel);
            pstmt.setString(4, time);
            pstmt.setString(5, service);
            pstmt.setString(6, t_id);
            pstmt.executeUpdate();          
                        
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
	
	//메인이미지 불러오기
	//MainAction.java
	public ArrayList<MainDataBean> get_mainImg () throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ArrayList<MainDataBean> list = new ArrayList<MainDataBean>();
        ResultSet rs = null;
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from main_img where m_type = 'main_img'");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	MainDataBean data = new MainDataBean();
            	data.setMain_img(rs.getString("main_img"));
            	list.add(data);
            }          
                        
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
	
	
	//보석 소개 이미지 불러오기
	//IntroAction.java
	public ArrayList<MainDataBean> get_introImg () throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ArrayList<MainDataBean> list = new ArrayList<MainDataBean>();
        ResultSet rs = null;
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from main_img where m_type = 'introduce_img'");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	MainDataBean data = new MainDataBean();
            	data.setMain_img(rs.getString("main_img"));
            	list.add(data);
            }          
                        
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
	
	
	//서비스 소개 이미지 불러오기
	//ServiceAction.java
	public ArrayList<MainDataBean> get_serviceImg () throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ArrayList<MainDataBean> list = new ArrayList<MainDataBean>();
        ResultSet rs = null;
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from main_img where m_type = 'service_img'");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	MainDataBean data = new MainDataBean();
            	data.setMain_img(rs.getString("main_img"));
            	list.add(data);
            }          
                        
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
	
	
	//선생님 소개 페이지
	//TeacherIntroAction.java
	
	//선생님 이름 조회하기
	public MainDataBean getTeacherProfile_name(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// ManageDataBean users = null;
		MainDataBean profile = null;
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from t_profile,teacher where t_profile.t_id=teacher.t_id and t_profile.t_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				profile = new MainDataBean();
				profile.setT_id(rs.getString("t_id"));
				profile.setT_name(rs.getString("t_name"));

			}
			System.out.println("완료");
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
		return profile;
	}
	
	//선생님 프로필 불러오기 (((보류중...)))
	public MainDataBean getTeacherProfile_list(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// ManageDataBean users = null;
		MainDataBean profile = null;
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from t_profile,teacher where t_profile.t_id=teacher.t_id and t_profile.t_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				profile = new MainDataBean();
				profile.setT_id(rs.getString("t_id"));
				profile.setT_intro(rs.getString("t_intro"));
				profile.setT_career(rs.getString("t_career"));
				profile.setT_img(rs.getString("t_img"));
				profile.setT_name(rs.getString("t_name"));
				profile.setT_tel(rs.getString("t_tel"));

				//profileList.add(profile);
			}
			System.out.println("완료");
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
		return profile;
	}
	
	
	//선생님 프로필 불러오기
	public  ArrayList<MainDataBean> getTeacherProfile(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MainDataBean> profileList = new ArrayList<MainDataBean>();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from t_profile,teacher where t_profile.t_id=teacher.t_id and t_profile.t_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_id);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainDataBean profile = new MainDataBean();
				profile.setT_id(rs.getString("t_id"));
				profile.setT_intro(rs.getString("t_intro"));
				profile.setT_career(rs.getString("t_career"));
				profile.setT_img(rs.getString("t_img"));
				profile.setT_name(rs.getString("t_name"));
				profile.setT_tel(rs.getString("t_tel"));

				profileList.add(profile);
			}	        
	                  
			
			System.out.println("완료");
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
		return profileList;
	}
	
}
