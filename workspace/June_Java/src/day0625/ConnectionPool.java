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
	
		this.url =url; //�Ű������� �޾ƿ°� �Է���. . 
		this.user=user;
		this.password= password;
		this.initialCons = initialCons; //5
		this.maxCons = maxCons; //10
		
		if(initialCons<0)      //������ ��������� ���Ƿ� �ٲ��� 
			initialCons = 5;
		if(maxCons <0)
			maxCons = 10;
		
		/*
		 * �ʱ� Ŀ�ؼ� ������ ������ ArrayList�� ������ �� �ֵ��� �ʱ� Ŀ�ؼ� ����ŭ ArrayList�� �����Ѵ�.
		 */
		free = new ArrayList<Connection>(initialCons); //Ŀ�ؼ� 5�� �����Ҽ��ִ� ���� ������
		used = new ArrayList<Connection>(initialCons); //Ŀ�ؼ� 5�� �����Ҽ��ִ� ���� ������
		
		// initialCons ����ŭ Connection�� ����(free)�Ѵ�.
		while(numCons<initialCons) { //0<5
			addConnection(); //��� addconnection �޼ҵ� ȣ�� 
		}
	}
	
	private void addConnection() throws SQLException{
		free.add(getNewConnection()); //getNewConnectionȣ��
	}
	
	private Connection getNewConnection() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);//��ı���������ӵǾ��ִ� Ŀ�ؼ� ��ü�� �����ͼ� con�� ����
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("About to connect to " + con);
		// ���ؼ� ������ ������ ���ڰ� �����Ѵ�.
		++numCons; //Ŀ�ؼǰ��� 1����
		return con;
	}
	/*
	 * free�� �ִ� Ŀ�ؼ��� used�� �ű�� �۾� => free--->used
	 */
	public synchronized Connection getConnection() throws SQLException{
		/*
		 * free�� Connection�� ������ maxCons��ŭ Connection�� �� �����Ѵ�.
		 */
		if(free.isEmpty()) { //free arrayList�� ����ִٸ� 
			while(numCons < maxCons) {//�ִ밹����ŭ Ŀ�ؼǻ���
				addConnection(); 
			}
		}
		Connection _con;//Ŀ�ؼ�Ÿ���� ���� ���� 
		_con = free.get(free.size() -1); //free�� �������ִ� Ŀ�ؼ��ǰ���-1 ���ε������ִ� ���� _con�� ���� => �������ε����� ���� ����
		free.remove(_con); //���
		used.add(_con); 
		return _con;
	}
	/*
	 * used�� �ִ� Ŀ�ؼ��� free�� �ݳ��Ѵ�.
	 */
	public synchronized void releaseConnection(Connection _con) throws SQLException{
		boolean flag = false;
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag=true;
		}else {
			throw new SQLException("ConnectionPool" + "�� �����ʳ׿�!!");
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
	
	// ��� Connection �ڿ��� �ݳ��Ѵ�.
	public void closeAll() {
		// used�� �ִ� Ŀ�ؼ��� ��� �����Ѵ�.
		for(int i=0;i<used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		// free�� �ִ� Ŀ�ؼ��� ��� �����Ѵ�.
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