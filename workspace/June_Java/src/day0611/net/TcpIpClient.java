package day0611.net;

import java.io.*;
import java.net.*;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp ="192.168.40.77";
			
			System.out.println("서버에 연결중입니다.서버IP : " + serverIp);
			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp,7777);//소켓객체를 만들음 -> 만드는 순간 서버소켓에 접근
			
			// 소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 소켓으로 부터 받은 데이터를 출력한다.
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			// 스트림과 소켓을 닫는다.
			dis.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
