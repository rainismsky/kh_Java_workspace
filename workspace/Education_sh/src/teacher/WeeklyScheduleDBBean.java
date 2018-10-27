package teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;

public class WeeklyScheduleDBBean {

	
	private static WeeklyScheduleDBBean instance = new WeeklyScheduleDBBean();
	
	public static WeeklyScheduleDBBean getInstance() {
		return instance;
	}
	
	private WeeklyScheduleDBBean() {}

	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public List getWeeklySchedules(String id) throws Exception{
		System.out.println("[�ڹٺ�]"+id+"������ �ð�ǥ ��� �������� ����!");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List wsList = null;
		String sql="";
		
		try {
			conn = getConnection();
			sql = "select ws_num,ws_day,schedule,to_char(starttime,'hh24:mi'),to_char(endtime,'hh24:mi'),t_id from weeklyschedule where t_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wsList = new ArrayList();
				do {
					WeeklyScheduleDataBean wschedule = new WeeklyScheduleDataBean();
						wschedule.setWs_num(rs.getInt(1));
						wschedule.setWs_day(rs.getString(2));
						wschedule.setSchedule(rs.getString(3));
						wschedule.setStarttime(rs.getString(4));
						wschedule.setEndtime(rs.getString(5));
						wschedule.setT_id(rs.getString(6));
						wsList.add(wschedule);
						
						System.out.println(wschedule.getEndtime()+" "+wschedule.getStarttime());
				}while(rs.next());
				
			}else {
				wsList = Collections.EMPTY_LIST;
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return wsList;
	}
	
	
	public void insertWeeklySchedule(WeeklyScheduleDataBean ws) throws Exception{
		System.out.println("[�ڹٺ�]�ð�ǥ �߰�!"+ws);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int result = 0;
		
		try {
				conn = getConnection();
				sql = "insert into WeeklySchedule(ws_num,ws_day,schedule,starttime,endtime,t_id)"
						+ " values(seq_ws_num.nextval,?,?,TO_DATE(?,'hh24:mi'),TO_DATE(?,'hh24:mi'),?)";
				pstmt = conn.prepareStatement(sql);		
				pstmt.setString(1,ws.getWs_day());
				pstmt.setString(2, ws.getSchedule());
				pstmt.setString(3, ws.getStarttime());
				pstmt.setString(4, ws.getEndtime());
				pstmt.setString(5, ws.getT_id());
				result = pstmt.executeUpdate();
				
				if(result == 1) {
					System.out.println("[����]���������� ���");
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	public void deleteWeeklySchedule(int ws_num) throws Exception{
		System.out.println("[�ڹٺ�]�ð�ǥ ����!"+ws_num);

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from WeeklySchedule where ws_num=?");
			pstmt.setInt(1,ws_num);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("[����]");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	
	
	
	
}
