package day0625;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptEx {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			List<DeptDto> deptList = new ArrayList<DeptDto>();
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); //url,user,password순 
			
			Statement stmt = con.createStatement();    
			ResultSet rs = stmt.executeQuery("select * from dept"); 
		
			while(rs.next()) { //다음 레코드 있으면 
				DeptDto dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString(2));
				dto.setLoc(rs.getString(3));
				
				deptList.add(dto);
			/*	System.out.print("deptno : " + rs.getInt("deptno") + ", "); 
				System.out.print("dname : " + rs.getString("dname") + ", ");
				System.out.println("loc : " + rs.getString(3));*/
			}
			
			for(DeptDto dto : deptList) {
				System.out.println(dto);
			}
		
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch (SQLException ee) {
			System.out.println("Connection Error");
			ee.printStackTrace();
		}
	}
}
