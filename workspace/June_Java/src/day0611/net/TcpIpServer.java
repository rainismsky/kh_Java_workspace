package day0611.net;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ� �Ǿ����ϴ�");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "���� ��û�� ��ٸ��ϴ�.");
				// ���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept(); //blocking 
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("����������"); 
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
