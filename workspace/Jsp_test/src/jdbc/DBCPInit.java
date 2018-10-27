package jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


//@WebServlet(urlPatterns="/", load
public class DBCPInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();   
	}

	private void loadJDBCDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "scott";
			String pw = "tiger";
//Ŀ�ؼ����丮 ����. Ŀ�ؼ� ���丮�� ���ο� Ŀ�ؼ��� �����Ҷ� ����Ѵ�.			
			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);
//DBCP�� Ŀ�ؼ� Ǯ�� Ŀ�ؼ��� �����Ҷ� ����ϴ� PoolableConnectionFactory ����
            //������ ���������� Ŀ�ؼ��� ����ְ� Ŀ�ؼ��� �����ϴµ� ����� �����Ѵ�. 
			//ex)Ŀ�ؼ��� close�ϸ� �������� �ʰ� Ŀ�ؼ� Ǯ�� ��ȯ
			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			 //Ŀ�ؼ��� ��ȿ���� Ȯ���Ҷ� ����ϴ� ������ �����Ѵ�.
			poolableConnFactory.setValidationQuery("select 1");
			 //Ŀ�ؼ� Ǯ�� ���� ������ �����Ѵ�.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			//��ȿ Ŀ�ؼ� �˻� �ֱ�
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			//Ǯ�� �ִ� Ŀ�ؼ��� ��ȿ���� �˻� ���� ����
			poolConfig.setTestWhileIdle(true);
			 //Ŀ�ؼ� �ּҰ��� ����
			poolConfig.setMinIdle(4);
			  //Ŀ�ؼ� �ִ� ���� ����
			poolConfig.setMaxTotal(50);
            //Ŀ�ؼ� Ǯ ����. ���ڷδ� ������ ������  PoolabeConnectionFactory�� GenericObjectPoolConfig�� ����Ѵ�.
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			//PoolabeConnectionFactory���� Ŀ�ؼ� Ǯ�� ����
			poolableConnFactory.setPool(connectionPool);
			//Ŀ�ؼ� Ǯ�� �����ϴ� jdbc ����̹��� ���.
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			
			PoolingDriver driver = 
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			 //������ Ŀ�ؼ� Ǯ ����̹��� ������ Ŀ�ؼ� Ǯ�� ����Ѵ�. �̸��� pool�̴�.
			
			driver.registerPool("pool", connectionPool); //Ŀ�ؼ��� �����Ҷ� ���� �κ��� �߿��ϴ� �ϼ��� -������
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}