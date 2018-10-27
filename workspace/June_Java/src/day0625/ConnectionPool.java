package day0625;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	private ArrayList<Connection> free;
	private ArrayList<Connection> used;
	
	private String url;
	private String user;
	private String password;
	
	private int initialCons =0;
	private int maxCons =0;
	private int numCons =0;
	private static ConnectionPool cp; //null
	
	public static ConnectionPool getInstance(String url,String user,String password,
														int initialCons, int maxCons) {
		
		try {
			if(cp==null) {
				synchronized(ConnectionPool.class) {
					cp=new ConnectionPool(url,user,password,initialCons,maxCons);
				}
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return cp;
	}
	
	private ConnectionPool(String url,String user,String password,
								int initialCons,int maxCons) throws SQLException{
	
		this.url =url; //매개변수로 받아온것 입력중. . 
		this.user=user;
		this.password= password;
		this.initialCons = initialCons; //5
		this.maxCons = maxCons; //10
		
		if(initialCons<0)      //음수로 들어왔을경우 임의로 바꿔줌 
			initialCons = 5;
		if(maxCons <0)
			maxCons = 10;
		
		/*
		 * 초기 커넥션 개수를 각각의 ArrayList에 저장할 수 있도록 초기 커넥션 수만큼 ArrayList를 생성한다.
		 */
		free = new ArrayList<Connection>(initialCons); //커넥션 5개 저장할수있는 공간 만들음
		used = new ArrayList<Connection>(initialCons); //커넥션 5개 저장할수있는 공간 만들음
		
		// initialCons 수만큼 Connection을 생성(free)한다.
		while(numCons<initialCons) { //0<5
			addConnection(); //계속 addconnection 메소드 호출 
		}
	}
	
	private void addConnection() throws SQLException{
		free.add(getNewConnection()); //getNewConnection호출
	}
	
	private Connection getNewConnection() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);//스캇계정에접속되어있는 커넥션 객체를 가져와서 con에 저장
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("About to connect to " + con);
		// 컨넥션 생성될 때마다 숫자가 증가한다.
		++numCons; //커넥션갯수 1증가
		return con;
	}
	/*
	 * free에 있는 커넥션을 used로 옮기는 작업 => free--->used
	 */
	public synchronized Connection getConnection() throws SQLException{
		/*
		 * free에 Connection이 없으면 maxCons만큼 Connection을 더 생성한다.
		 */
		if(free.isEmpty()) { //free arrayList가 비어있다면 
			while(numCons < maxCons) {//최대갯수만큼 커넥션생성
				addConnection(); 
			}
		}
		Connection _con;//커넥션타입의 변수 선언 
		_con = free.get(free.size() -1); //free가 가지고있는 커넥션의갯수-1 의인덱스에있는 값을 _con에 저장 => 마지막인덱스의 값을 저장
		free.remove(_con); //비움
		used.add(_con); 
		return _con;
	}
	/*
	 * used에 있는 커넥션을 free로 반납한다.
	 */
	public synchronized void releaseConnection(Connection _con) throws SQLException{
		boolean flag = false;
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag=true;
		}else {
			throw new SQLException("ConnectionPool" + "에 있지않네요!!");
		}
		try {
			if(flag) {
				free.add(_con);
				numCons++;
			}else {
				_con.close();
			}
		}catch(SQLException e) {
			try {
				_con.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// 모든 Connection 자원을 반납한다.
	public void closeAll() {
		// used에 있는 커넥션을 모두 삭제한다.
		for(int i=0;i<used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		// free에 있는 커넥션을 모두 삭제한다.
		for (int i = 0; i < free.size(); i++) {
			Connection _con = (Connection) free.get(i);
			free.remove(i--);
			try {
				_con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
		}
		
	}
}
	public int getMaxCons() {
		return maxCons;
	}
	public int getNumCons() {
		return numCons;
	}
}