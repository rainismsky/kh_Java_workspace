package day0625;
import java.sql.*;

public class PreparedStatementEx {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //static멤버 이용해서 드라이버 연결
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); //connection연결
			String sql = "create table test2(id varchar(10),password varchar(10))"; //아이디와 패스워드 저장할 쿼리문을 저장
			pstmt = con.prepareStatement(sql); //그쿼리문을 preparestatement객체에 줌
			int updateCount = pstmt.executeUpdate(); //create라서 executeUpdate로 실행 : 객체안에저장되어있는 sql문을 실행함. 변경된 레코드의 갯수를 가져옴
			System.out.println("createCount : " + updateCount);
			
			sql = "insert into test2 values(?,?)"; //앞의 쿼리문은 변하지않고 저장할 값만 계속 바뀌니까 변경될 값을 ? 
			pstmt = con.prepareStatement(sql); //처리한 sql문을 prepareStatement에 저장
			pstmt.setString(1, "abc2022"); //값 세팅 각각 순서대로 저장됨
			pstmt.setString(2, "1111");
			updateCount = pstmt.executeUpdate(); //executeUpdate이용해서 실행. 변경된 레코드의 갯수 리턴됨
			System.out.println("insertCount : " + updateCount);
			
			sql = "select * from test2"; //select문 또 저장 
			pstmt = con.prepareStatement(sql); //prepareStatment객체에 저장한 sql문 ..저장 
			rs = pstmt.executeQuery(); //select라서 executeQuery로 실행함 
			while(rs.next()) { //다음레코드 있으면 반복
				System.out.print("id : " + rs.getString(1));
				System.out.println(", password : " + rs.getString(2));
			}
			
			sql = "drop table test2"; //drop문  저장 
			pstmt = con.prepareStatement(sql); //prepareStatment객체에 저장한 sql문을 저장 
			updateCount=pstmt.executeUpdate();//drop이니까 executeUpdate로 저장한 sql문 실행함. 변경된 레코드의 갯수 리턴됨
			System.out.println("dropCount : " + updateCount);
		}catch(SQLException sqle) {
			sqle.printStackTrace();
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
