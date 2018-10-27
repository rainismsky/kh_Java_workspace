package day0625;
import java.sql.*;

public class ConnectionPoolEx {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPool cp = null;
		try {
			cp=ConnectionPool.getInstance("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger", 5, 10);
			//커넥션풀 안에있는 getInstance메소드 불러오고있음 ->static메소드 호출. 커넥션풀이가지고있는 최소갯수 5 최대갯수 10
			con = cp.getConnection();
			pstmt = con.prepareStatement("select * from dept");
			rs = pstmt.executeQuery(); //저장된쿼리 실행
			while(rs.next()) {
				System.out.println("deptno : " + rs.getInt(1) + ",");
				System.out.println("dname : " + rs.getString(2) +",");
				System.out.println("loc : " + rs.getString(3));
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) cp.releaseConnection(con);//커넥션 다 쓰고 반환
			}catch(SQLException _sqle) {
				_sqle.printStackTrace();
			}
		}
		cp.closeAll();
	}

}
