package day0625;
import java.sql.*;

public class BatchInsertEx {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ResultSet rs = null;
		Connection con = null;
		Statement stmt = null;
		String sql = null;
		boolean commit = false;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			stmt = con.createStatement();
			sql = "create table test4(id varchar2(10) primary key, " + "password varchar2(10))";
			stmt.executeUpdate(sql);
			
			con.setAutoCommit(false);
			stmt.addBatch("INSERT INTO test4 " + "VALUES('abc1011' , '1111')");
			stmt.addBatch("INSERT INTO test4 " + "VALUES('abc2011' , '2222')");
			stmt.addBatch("INSERT INTO test4 " + "VALUES('abc3033' , '3333')");
			stmt.addBatch("INSERT INTO test4 " + "VALUES('abc4011' , '4444')");
			
			int [] updateCounts = stmt.executeBatch();
			commit = true;
			con.commit();
			con.setAutoCommit(commit);
			
			rs = stmt.executeQuery("SELECT * FROM test4");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				System.out.println("id : " + id + " , password : " + password);
			}
		}catch(SQLException sqle) {
				sqle.printStackTrace();
			}finally {
				try {
					if(!commit) con.rollback();
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null)con.close();
				}catch(SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
	}

