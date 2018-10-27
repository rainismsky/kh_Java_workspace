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
			System.out.println("테이블 생성 완료.");
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
			System.out.println("email : (없으면 no 입력)");
			String email = scan.next();
			if(email.equals("no")) {
				stmt.executeUpdate("insert into member(id, password, name) values('"+id+"','"+password+"','"+name+"')");
			}else {
				stmt.executeUpdate("insert into member values('"+id+"','"+password+"','"+name+"','"+email+"')");
			}
			System.out.println("회원가입완료");
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
					System.out.println("로그인 성공");
					System.out.println("");
					count++;
				}
			}
			 con.close();
	         stmt.close();
	         
	         if(count ==0) {
	        	 System.out.println("로그인실패");
	        	 System.out.println("");
	         }
		}catch (SQLException ee) {
			ee.printStackTrace();
			System.out.println("오류");
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
					
					System.out.println(id+"회원 이름변경 성공");
					System.out.println("");
					count++;
					break;
				}
			}
			con.close();
			stmt.close();
			if(count==0) {
				System.out.println("id없음");
				System.out.println();
			}
		}catch(SQLException ee) {
			System.out.println("오류");
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
		
			System.out.println("1~7까지 정수만 입력하세요.");
			System.out.println("1.회원 테이블 생성");
			System.out.println("2.회원가입");
			System.out.println("3.로그인");
			System.out.println("4.이름 수정");
			System.out.println("5.비밀번호 확인");
			System.out.println("6.회원탈퇴");
			System.out.println("7.종료");

		
			
	}
		}
			

		
				