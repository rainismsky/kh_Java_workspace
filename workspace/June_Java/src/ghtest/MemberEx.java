package day0625.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day0622.JDBC.ConnectionPool;

public class MemberEx {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void createMember(ConnectionPool cp) throws SQLException {
		String sql = "create table MEMBER(id varchar2(20) primary key," + "	password varchar2(20) not null,"
				+ " name varchar2(20) not null," + "email varchar2(100))";
		con = cp.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.executeQuery();

		if (con != null)
			cp.releaseConnection(con);

	}

	public void insertMember(ConnectionPool cp) throws IOException, SQLException {
		try {
			String id = consoleInput("id");
			String password = consoleInput("password");
			String name = consoleInput("name");
			String email = consoleInput("email");

			con = cp.getConnection();
			pstmt = con.prepareStatement("insert into MEMBER values(?,?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);

			int i = pstmt.executeUpdate();

			if (i == 0) {
				System.out.println("입력 실패");
			} else {
				System.out.println("입력 성공");
			}
		} finally {
			if (con != null)
				cp.releaseConnection(con);
		}
	}

	public String consoleInput(String input) throws IOException {
		BufferedReader br = null;
		try{
		System.out.print(input + " : ");
		InputStreamReader isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		String message = br.readLine();
		return message;
		}finally{
			//if(br != null) br.close(); // System.in close()금지!!
		}
	}

	public void loginMember(ConnectionPool cp) throws IOException, SQLException {

		String id = consoleInput("id");
		String password = consoleInput("password");
		try {
			con = cp.getConnection();
			pstmt = con.prepareStatement("select id,password from MEMBER where id=? AND password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}

		} finally {
			if (con != null)
				cp.releaseConnection(con);
		}
	}

	public void updateName(ConnectionPool cp) throws IOException, SQLException {
		try {
			String id = consoleInput("id");
			String name = consoleInput("name");

			con = cp.getConnection();
			pstmt = con.prepareStatement("update member set name=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, id);

			int i = pstmt.executeUpdate();

			if (i != 0) {
				System.out.println("이름 변경");
			} else {
				System.out.println("해당 id 없음");
			}

		} finally {
			if (con != null)
				cp.releaseConnection(con);
		}
	}

	public void selectPwd(ConnectionPool cp) throws IOException, SQLException {
		try {
			String id = consoleInput("id");
			String name = consoleInput("name");

			con = cp.getConnection();
			pstmt = con.prepareStatement("select password from member where id=? AND name=?");
			pstmt.setString(1, id);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("password ::: " + rs.getString("password"));
			} else {
				System.out.println("id나 이름이 틀림");
			}

		} finally {
			if (con != null)
				cp.releaseConnection(con);
		}
	}

	public void deleteMember(ConnectionPool cp) throws IOException, SQLException {

		String id = consoleInput("id");
		String password = consoleInput("password");
		try {
			con = cp.getConnection();
			pstmt = con.prepareStatement("delete from MEMBER where id=? AND password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			int i = pstmt.executeUpdate();

			if (i != 0) {
				System.out.println("회원 탈퇴");
			} else {
				System.out.println("탈퇴 실패");
			}

		} finally {
			if (con != null)
				cp.releaseConnection(con);
		}
	}

	public static void main(String[] args) {
		ConnectionPool cp = ConnectionPool.getInstance("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger", 5, 10);
		MemberEx be = new MemberEx();
		boolean flag = true;
		try {
			System.out.println("1~7까지 정수만 입력하세요.");
			System.out.println("1.회원 테이블 생성");
			System.out.println("2.회원가입");
			System.out.println("3.로그인");
			System.out.println("4.이름 수정");
			System.out.println("5.비밀번호 확인");
			System.out.println("6.회원탈퇴");
			System.out.println("7.종료");
			
			
			while(flag){
			Scanner scan = new Scanner(System.in);

			int i = scan.nextInt();

			switch (i) {
			case 1:
				be.createMember(cp);
				break;
			case 2:
				be.insertMember(cp);
				break;
			case 3:
				be.loginMember(cp);
				break;
			case 4:
				be.updateName(cp);
				break;
			case 5:
				be.selectPwd(cp);
				break;
			case 6:
				be.deleteMember(cp);
				break;
			default:
				if(i == 7){
					System.out.println("종료");
				}else{
				System.out.println("알맞은 번호가 아닙니다.");
				}
				flag = false;
				break;
			}
		}
		} catch (Exception e) {
			System.out.println("종료");
			e.printStackTrace();
		}finally {
			cp.closeAll();	
		}
		
	}

}
