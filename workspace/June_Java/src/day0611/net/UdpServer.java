package day0611.net;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	public void start() throws IOException{
		// ��Ʈ 7777���� ����ϴ� ������ �����Ѵ�.
		DatagramSocket socket = new DatagramSocket(7777);//�����ͱ׷� ���Ϻ��� ����
		DatagramPacket inPacket,outPacket;//��Ŷ �ΰ� ����

		byte[] inMsg = new byte[10];//byte�迭 10ĭ¥�� ����
		byte[] outMsg; //����Ʈ�迭 ���� �س���
		
		while(true) { //���ѹݺ� ó��
			// �����͸� �����ϱ� ���� ��Ŷ�� �����Ѵ�.
			inPacket = new DatagramPacket(inMsg,inMsg.length);
			//�����ͱ׷���Ŷ�� ����Ʈ�迭 �����ϰ�,�迭�� ���̸�ŭ ���� ->�ּҿ���Ʈ �����ϱ� �޴� ������
			
			// ��Ŷ�� ���� �����͸� ����(receive)�Ѵ�.
			socket.receive(inPacket);//Ŭ���̾�Ʈ�� ������ ���������� ��ٸ� . inpacket�� ������ (0�� 1�� �������ϱ� 0�������)
			
			// ������ ��Ŷ���� ���� client�� IP�ּҿ� Port�� ��´�.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// ������ ���� �ð��� �ú��� ����([hh:mm:ss])�� ��ȯ�Ѵ�.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();// time�� byte�迭�� ��ȯ�Ѵ�.
			
			// ��Ŷ�� �����ؼ� client���� ����(send)�Ѵ�.
			outPacket = new DatagramPacket(outMsg,outMsg.length,address,port);
			socket.send(outPacket);
		}
	}
	public static void main(String[] args) {
		try {
			new UdpServer().start(); // UDP������ �����Ų��. start�޼ҵ� ȣ��
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
