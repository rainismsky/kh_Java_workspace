package day0625;

import java.io.*;
import java.util.*;
import java.sql.*;

public class PropertiesEx {
	public static void main(String[] args) {
		String driver = null;
		String url = null;
		String user = null;
		String password = null;
		
		Properties prop = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			FileInputStream fis = new FileInputStream("c://db.properties");
			prop = new Properties();
			
			prop.load(fis);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			password = prop.getProperty("password");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement("select ename from emp");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("¿Ã∏ß : " + rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			}catch(SQLException sqle) {	
			}
		}
	}
}
