package day0611.net;

import java.io.*;
import java.net.URL;

public class NetworkEx4 {
	public static void main(String args[]) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://docs.oracle.com/javase/8/docs/api/index.html";  //�ּҸ� �ϴ� ���ڿ��� ������
		String line = "";
		
		try {
			url = new URL(address); //�ּ� �����ص� ���ڿ��� url�� �ٲ�
			input = new BufferedReader(new InputStreamReader(url.openStream())); //openStream���� inputStream��ü����
			//InputStreamReader�� 2����Ʈ�� �ø� ������ BufferedReader���
			
			while((line=input.readLine())!=null) { //�о�� ����input.readLine()�� line�������ϰ� �װ��� �ִٸ� ���
				System.out.println(line); 
			}
			input.close(); //����
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
