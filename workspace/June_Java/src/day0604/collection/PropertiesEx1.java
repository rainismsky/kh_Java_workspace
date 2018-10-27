package day0604.collection;

import java.util.Properties;
import java.util.Enumeration;//Iterator

class PropertiesEx1{
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("UserName","Michael"); //�Ӽ�(��Ʈ����Ʈ) �����ϱ�
		prop.setProperty("lovely","SunAe");
		prop.setProperty("dbDRV","oracle.jdbc.driver.OracleDriver");

		String user = prop.getProperty("UserName"); //�Ӽ� ��������
		String love = prop.getProperty("lovely");
		String db_drv = prop.getProperty("dbDRV");
		System.out.println("user");
		System.out.println("love");
		System.out.println("db_drv");

		System.out.println("------------ keys ------------");
		Enumeration keys = prop.propertyNames(); //Ű���鸸 ����
		while(keys.hasMoreElements())
			System.out.println(keys.nextElement());

		prop.list(System.out);
	}
}
