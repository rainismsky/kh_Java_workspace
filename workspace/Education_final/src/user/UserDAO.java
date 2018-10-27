package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
		
	private Connection conn; //db�� �����ϱ� ���� �ϳ��� ��ü ����
	private PreparedStatement pstmt;
	private ResultSet rs; //� ������ ���� �� �ִ� �ϳ��� ��ü ����
	
	public UserDAO() { //bbsDAO ������ ���� => �ϳ��� ��ü�� ��������� �ڵ������� dbĿ�ؼ��� �̷����� �� ��.
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "scott";
			String dbPassword = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����Ŭ db ã��
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
	}catch(Exception e) {
		e.printStackTrace(); //���� �߻� �� �߻��� ������ �������� ���

}
}
	//�ϳ��� ������ ���� �α��� �õ��� ���� �Լ� ����!
	public int login(String userID,String userPassword) {
		String SQL="select userPassword from user1 where UserID=?";
		try {
			pstmt = conn.prepareStatement(SQL); //db�� ���� �����ϴ� �������� �ν��Ͻ��� ������
			pstmt.setString(1,userID);
			rs = pstmt.executeQuery(); //����� ���� �� �ִ� �ϳ��� ��ü�� ���� ����� �־���
			if(rs.next()) { //����� �����Ѵٸ� ������ ����ǰ���?
				if(rs.getString(1).equals(userPassword)) 
					return 1; //�α��� ����
				else
					return 0;//��.�� ����ġ
					
			}
			return -1; //ID ���� => ����� ��� �������� �Ѿ��
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //db ����
	
}
	public int join(User1 user) { //���� Ŭ�������� ��������� �ϳ��� �ν��Ͻ�
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
		return -1; //DB����
				}
	}