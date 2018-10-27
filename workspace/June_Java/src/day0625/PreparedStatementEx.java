package day0625;
import java.sql.*;

public class PreparedStatementEx {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //static��� �̿��ؼ� ����̹� ����
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String arg[]) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); //connection����
			String sql = "create table test2(id varchar(10),password varchar(10))"; //���̵�� �н����� ������ �������� ����
			pstmt = con.prepareStatement(sql); //���������� preparestatement��ü�� ��
			int updateCount = pstmt.executeUpdate(); //create�� executeUpdate�� ���� : ��ü�ȿ�����Ǿ��ִ� sql���� ������. ����� ���ڵ��� ������ ������
			System.out.println("createCount : " + updateCount);
			
			sql = "insert into test2 values(?,?)"; //���� �������� �������ʰ� ������ ���� ��� �ٲ�ϱ� ����� ���� ? 
			pstmt = con.prepareStatement(sql); //ó���� sql���� prepareStatement�� ����
			pstmt.setString(1, "abc2022"); //�� ���� ���� ������� �����
			pstmt.setString(2, "1111");
			updateCount = pstmt.executeUpdate(); //executeUpdate�̿��ؼ� ����. ����� ���ڵ��� ���� ���ϵ�
			System.out.println("insertCount : " + updateCount);
			
			sql = "select * from test2"; //select�� �� ���� 
			pstmt = con.prepareStatement(sql); //prepareStatment��ü�� ������ sql�� ..���� 
			rs = pstmt.executeQuery(); //select�� executeQuery�� ������ 
			while(rs.next()) { //�������ڵ� ������ �ݺ�
				System.out.print("id : " + rs.getString(1));
				System.out.println(", password : " + rs.getString(2));
			}
			
			sql = "drop table test2"; //drop��  ���� 
			pstmt = con.prepareStatement(sql); //prepareStatment��ü�� ������ sql���� ���� 
			updateCount=pstmt.executeUpdate();//drop�̴ϱ� executeUpdate�� ������ sql�� ������. ����� ���ڵ��� ���� ���ϵ�
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
