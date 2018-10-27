package day0626;

import java.sql.*;
import java.util.*;

public class MemberEx {
	static Scanner scan = new Scanner(System.in);

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	void number1() {
		try {
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
			Statement stmt = con.createStatement(); 
			stmt.executeUpdate("create table member(id varchar2(30) primary key, password varchar2(30) not null,name varchar2(30), email varchar2(30);");
			System.out.println("���̺� ���� �Ϸ�.");
			 con.close();
	         stmt.close();
		}catch (SQLException ee) {
			System.out.println("Connection Error");
			System.out.println("");
		}
	}

	void number2() {
		try {
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
			Statement stmt = con.createStatement(); 
			System.out.println("id : ");
			String id = scan.next();
			System.out.println("password : ");
			String password =scan.next();
			System.out.println("name : ");
			String name = scan.next();
			System.out.println("email : (������ no �Է�)");
			String email = scan.next();
			if(email.equals("no")) {
				stmt.executeUpdate("insert into member(id, password, name) values('"+id+"','"+password+"','"+name+"')");
			}else {
				stmt.executeUpdate("insert into member values('"+id+"','"+password+"','"+name+"','"+email+"')");
			}
			System.out.println("ȸ�����ԿϷ�");
			System.out.println("");
			 con.close();
	         stmt.close();
		}catch (SQLException ee) {
			System.out.println("Connection Error");
			ee.printStackTrace();
		}
	}
	
	void number3() {
		int count = 0;
		try {
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
			Statement stmt = con.createStatement(); 
			
			System.out.println("id : ");
			String id = scan.next();
			System.out.println("password : ");
			String password =scan.next();
			ResultSet rs = stmt.executeQuery("select * from member;");
			
			while(rs.next()) {
				if(id.equals(rs.getString("id"))&&password.equals(rs.getString("password"))) {
					System.out.println("�α��� ����");
					System.out.println("");
					count++;
				}
			}
			 con.close();
	         stmt.close();
	         
	         if(count ==0) {
	        	 System.out.println("�α��ν���");
	        	 System.out.println("");
	         }
		}catch (SQLException ee) {
			ee.printStackTrace();
			System.out.println("����");
			System.out.println("");
		}
	}
	
	void number4() {
		int count=0;
		try {
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
			Statement stmt = con.createStatement(); 
			
			System.out.println("id : ");
			String id = scan.next();
			System.out.print("name : ");
			String name = scan.next();
			ResultSet rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String a = rs.getString("id");
				if(id.equals(a)) {
					stmt.executeUpdate("update member set name='"+name+"' where id = '"+id+"'");
					
					System.out.println(id+"ȸ�� �̸����� ����");
					System.out.println("");
					count++;
					break;
				}
			}
			con.close();
			stmt.close();
			if(count==0) {
				System.out.println("id����");
				System.out.println();
			}
		}catch(SQLException ee) {
			System.out.println("����");
			System.out.println("");
		}
	}
	
	void number5() {
		int count=0;
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Statement stmt = con.createStatement();
			
			System.out.println("id : ");
			String id = scan.next();
			System.out.print("name : ");
			String name = scan.next();
			ResultSet rs = stmt.executeQuery("select * from member");
			
			while(rs.next())
		}
	}
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		MemberEx m = new MemberEx();
		
			System.out.println("1~7���� ������ �Է��ϼ���.");
			System.out.println("1.ȸ�� ���̺� ����");
			System.out.println("2.ȸ������");
			System.out.println("3.�α���");
			System.out.println("4.�̸� ����");
			System.out.println("5.��й�ȣ Ȯ��");
			System.out.println("6.ȸ��Ż��");
			System.out.println("7.����");

		
			
	}
		}
			

		
				