package day0611.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("192.168.0.100", 20000);
		Scanner sc = new Scanner(System.in);
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		new Thread() {
			public void run() {
				while (true) {
					try {
						System.out.println(dis.readUTF());
					} catch (Exception e) {
						System.out.println("연결이 종료되었습니다.");
					}
				}
			}
		}.start();
		while (true) {
			String msg = sc.nextLine();
			dos.writeUTF(msg);
			dos.flush();
			if (msg.equals("exit")) {
				break;
			}
		}
		dis.close();
		dos.close();
		sock.close();
	}
}
