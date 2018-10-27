package day0611.net;

import java.io.*;
import java.net.*;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp ="192.168.40.77";
			
			System.out.println("������ �������Դϴ�.����IP : " + serverIp);
			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp,7777);//���ϰ�ü�� ������ -> ����� ���� �������Ͽ� ����
			
			// ������ �Է½�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������� ���� ���� �����͸� ����Ѵ�.
			System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
