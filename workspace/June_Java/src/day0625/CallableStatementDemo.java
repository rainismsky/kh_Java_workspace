package day0625;
import java.sql.*;

public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			cstmt = con.prepareCall("{call adjust(?,?)}");
			cstmt.setString(1,"sys1011");
			cstmt.setFloat(2, 0.3f);
			cstmt.executeUpdate();
			
			pstmt = con.prepareStatement("select * from salary");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			}catch(SQLException e) {
					e.printStackTrace();
			}
		}
	}
}
