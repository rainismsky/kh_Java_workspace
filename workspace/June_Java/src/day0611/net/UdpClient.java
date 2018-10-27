package day0611.net;
import java.net.*;
import java.io.*;

public class UdpClient {
	public void start() throws IOException, UnknownHostException{
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("192.168.50.49");//inetAdrress��ü�� �ٲ㼭 ����
		
		// �����Ͱ� ����� �������� byte�迭�� �����Ѵ�.
		byte[] msg = new byte[100];//100ĭ¥�� byte�迭�� 0�� ����Ǿ�����
		
		DatagramPacket outPacket = new DatagramPacket(msg,1,serverAddress,7777);
		//100ĭ¥�� ����Ʈ�迭���� 1�� ���� ip�ּҿ� ��Ʈ��ȣ��..->�����»�����
		DatagramPacket inPacket = new DatagramPacket(msg,msg.length);
		//�ּҰ������Ƿ� �ش� ���̸�ŭ �޾Ƽ� �����ϰڴ� ��� ������
		
		datagramSocket.send(outPacket);   // DatagramPacket�� �����Ѵ�. �ش�ip�� ��Ʈ��ȣ�����ִ¾����� ��Ŷ�� ����
		datagramSocket.receive(inPacket); // DatagramPacket�� �����Ѵ�. 

		System.out.println("current server time :" + new String(inPacket.getData())); //data�� ������ String���� ... ���

		datagramSocket.close(); //����
	} // start()

	public static void main(String args[]) {
		try {
			new UdpClient().start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main 
}