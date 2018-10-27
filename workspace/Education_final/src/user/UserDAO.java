package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
		
	private Connection conn; //db에 접근하기 위한 하나의 객체 생성
	private PreparedStatement pstmt;
	private ResultSet rs; //어떤 정보를 담을 수 있는 하나의 객체 생성
	
	public UserDAO() { //bbsDAO 생성자 생성 => 하나의 객체를 만들었을때 자동적으로 db커넥션이 이뤄지게 해 줌.
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "scott";
			String dbPassword = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 db 찾기
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
	}catch(Exception e) {
		e.printStackTrace(); //오류 발생 시 발생한 오류가 무엇인지 출력

}
}
	//하나의 계정에 대한 로그인 시도를 위한 함수 생성!
	public int login(String userID,String userPassword) {
		String SQL="select userPassword from user1 where UserID=?";
		try {
			pstmt = conn.prepareStatement(SQL); //db에 값을 삽입하는 형식으로 인스턴스를 가져옴
			pstmt.setString(1,userID);
			rs = pstmt.executeQuery(); //결과를 담을 수 있는 하나의 객체에 실행 결과를 넣어줌
			if(rs.next()) { //결과가 존재한다면 이쪽이 실행되겠지?
				if(rs.getString(1).equals(userPassword)) 
					return 1; //로그인 성공
				else
					return 0;//비.번 불일치
					
			}
			return -1; //ID 없음 => 결과가 없어서 이쪽으로 넘어옴
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //db 오류
	
}
	public int join(User1 user) { //유저 클래스에서 만들어지는 하나의 인스턴스
		String SQL = "INSERT INTO USER1 values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserID());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3,user.getUserName());
			pstmt.setString(4,user.getUserGender());
			pstmt.setString(5,user.getUserEmail());
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB오류
				}
	}